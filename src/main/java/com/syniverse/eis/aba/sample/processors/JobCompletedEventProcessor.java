package com.syniverse.eis.aba.sample.processors;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syniverse.eis.aba.sample.models.Event;
import com.syniverse.eis.aba.sample.models.Execution;
import com.syniverse.eis.aba.sample.models.JobCompletedEvent;

/**
 * ESS event processing for event type "aba_job_completed"
 */
public class JobCompletedEventProcessor {
	private JobCompletedEvent jobCompletedEvent;
	private ObjectMapper objectMapper;

	public JobCompletedEventProcessor(Event event) {
		this.jobCompletedEvent = new JobCompletedEvent(event);
		this.objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/** 
	 * Uses data in this.jobCompletedEvent to
	 * 1) Get the Execution document from ABA
	 * 2) Download all output files for that Execution
	 * 3) Write output files to local absolute directory /aba-sample-output
	 */
	public void process() {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet executionRequest = new HttpGet(jobCompletedEvent.getExecutionUri());
			addHeaders(executionRequest, "application/json");
			CloseableHttpResponse executionResponse = httpClient.execute(executionRequest);
			HttpEntity executionEntity = executionResponse.getEntity();		
			Execution execution = objectMapper.readerFor(Execution.class).withRootName("execution").readValue(IOUtils.toString(executionEntity.getContent(), "UTF-8"));
			EntityUtils.consume(executionEntity);
			executionResponse.close();

			getFile(httpClient, jobCompletedEvent.getOutputFileUri(), "/aba-sample-output/" + execution.getId() + "/output.gzip");
			getFile(httpClient, jobCompletedEvent.getRetryFileUri(), "/aba-sample-output/" + execution.getId() + "/retry.txt");
			getFile(httpClient, jobCompletedEvent.getErrorFileUri(), "/aba-sample-output/" + execution.getId() + "/error.txt");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addHeaders(HttpGet request, String contentType) {
		String authHeader = ResourceBundle.getBundle("application").getString("user.sdc.bearer-token");
		request.addHeader("Authorization", authHeader);
		request.addHeader("int-companyid", String.valueOf(jobCompletedEvent.getCompanyId()));
		request.addHeader("Content-Type", contentType);
	}
	
	private void getFile(CloseableHttpClient httpClient, String fileUri, String localFileName) throws IOException {
		if (!"EMPTY_FILE".equals(fileUri)) {
			HttpGet fileRequest = new HttpGet(fileUri);
			addHeaders(fileRequest, "application/octet-stream");
			CloseableHttpResponse fileResponse = httpClient.execute(fileRequest);
			HttpEntity fileEntity = fileResponse.getEntity();	
			File result = new File(localFileName);
			FileUtils.copyInputStreamToFile(fileEntity.getContent(), result);
			EntityUtils.consume(fileEntity);
			fileResponse.close();
		}
	}
}
