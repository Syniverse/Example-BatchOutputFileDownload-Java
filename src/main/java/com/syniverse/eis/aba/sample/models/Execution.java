package com.syniverse.eis.aba.sample.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Execution {

	private String id;
	private Schedule schedule;
	private String status;
	private String statusReason;
	private Date startTimestamp;
	private Date statusUpdateTimestamp;
	private String outputFileId;
	@JsonProperty("outputFileURI")
	private String outputFileUri;
	private String errorDetailFileId;
	@JsonProperty("errorDetailFileURI")
	private String errorFileUri;
	private String retryFileId;
	@JsonProperty("retryFileURI")
	private String retryFileUri;
	private long recordSuccessCount;
	private long recordRetryCount;
	private long recordErrorCount;
	
	public Execution(){}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Schedule getScheduleDetail() {
		return schedule;
	}
	public void setScheduleDetail(Schedule schedule) {
		this.schedule = schedule;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}
	public Date getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public Date getStatusUpdateTimestamp() {
		return statusUpdateTimestamp;
	}
	public void setStatusUpdateTimestamp(Date statusUpdateTimestamp) {
		this.statusUpdateTimestamp = statusUpdateTimestamp;
	}
	public String getOutputFileId() {
		return outputFileId;
	}
	public void setOutputFileId(String outputFileId) {
		this.outputFileId = outputFileId;
	}
	public String getErrorDetailFileId() {
		return errorDetailFileId;
	}
	public void setErrorDetailFileId(String errorDetailFileId) {
		this.errorDetailFileId = errorDetailFileId;
	}
	public String getErrorFileUri() {
		return errorFileUri;
	}
	public void setErrorFileUri(String errorFileUri) {
		this.errorFileUri = errorFileUri;
	}
	public String getOutputFileUri() {
		return outputFileUri;
	}
	public void setOutputFileUri(String outputFileUri) {
		this.outputFileUri = outputFileUri;
	}
	public long getRecordSuccessCount() {
		return recordSuccessCount;
	}
	public void setRecordSuccessCount(long recordSuccessCount) {
		this.recordSuccessCount = recordSuccessCount;
	}
	public long getRecordRetryCount() {
		return recordRetryCount;
	}
	public void setRecordRetryCount(long recordRetryCount) {
		this.recordRetryCount = recordRetryCount;
	}
	public long getRecordErrorCount() {
		return recordErrorCount;
	}
	public void setRecordErrorCount(long recordErrorCount) {
		this.recordErrorCount = recordErrorCount;
	}
	public String getRetryFileId() {
		return retryFileId;
	}
	public void setRetryFileId(String retryFileId) {
		this.retryFileId = retryFileId;
	}
	public String getRetryFileUri() {
		return retryFileUri;
	}
	public void setRetryFileUri(String retryFileUri) {
		this.retryFileUri = retryFileUri;
	}
}
