package com.syniverse.eis.aba.sample.models;

import java.util.Map;

public class Schedule {
	private String id;
	private String jobId;
	private String name;
	private String inputFileId;
	private Integer fileRetentionDays;
	private Integer scheduleRetentionDays;
	private String outputFileNamingExpression;
	private String outputFileFolder;
	private String outputFileTag;
	private Map<String, String> jobRuntimeContext;
	
	public Schedule(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getInputFileId() {
		return inputFileId;
	}

	public void setInputFileId(String inputFileId) {
		this.inputFileId = inputFileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFileRetentionDays() {
		return fileRetentionDays;
	}

	public void setFileRetentionDays(Integer fileRetentionDays) {
		this.fileRetentionDays = fileRetentionDays;
	}

	public Integer getScheduleRetentionDays() {
		return scheduleRetentionDays;
	}

	public void setScheduleRetentionDays(Integer scheduleRetentionDays) {
		this.scheduleRetentionDays = scheduleRetentionDays;
	}

	public String getOutputFileNamingExpression() {
		return outputFileNamingExpression;
	}

	public void setOutputFileNamingExpression(String outputFileNamingExpression) {
		this.outputFileNamingExpression = outputFileNamingExpression;
	}

	public String getOutputFileFolder() {
		return outputFileFolder;
	}

	public void setOutputFileFolder(String outputFileFolder) {
		this.outputFileFolder = outputFileFolder;
	}

	public String getOutputFileTag() {
		return outputFileTag;
	}

	public void setOutputFileTag(String outputFileTag) {
		this.outputFileTag = outputFileTag;
	}

	public Map<String, String> getJobRuntimeContext() {
		return jobRuntimeContext;
	}

	public void setJobRuntimeContext(Map<String, String> jobRuntimeContext) {
		this.jobRuntimeContext = jobRuntimeContext;
	}
}
