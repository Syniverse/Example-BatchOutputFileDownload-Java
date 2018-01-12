package com.syniverse.eis.aba.sample.models;

public class JobCompletedEvent {
	private Event event;
	
	public JobCompletedEvent(Event event) {
		this.event = event;
	}
	
	public String getType() {
		return event.getType();
	}

	public String getOutputFileUri() {
		return event.getFields().get("output_file_uri").toString();
	}
	
	public Integer getCompanyId() {
		return new Integer(event.getFields().get("company-id").toString());
	}
	
	public String getJobName() {
		return event.getFields().get("job_name").toString();
	}
	
	public String getInputFileUri() {
		return event.getFields().get("file_uri").toString();
	}
	
	public String getCompletionTime() {
		return event.getFields().get("job_exec_complete_timestamp").toString();
	}
	
	public String getRetryFileUri() {
		return event.getFields().get("error_file_uri").toString();
	}
	
	public String getErrorFileUri() {
		return event.getFields().get("error_details_file_uri").toString();
	}
	
	public String getJobStatus() {
		return event.getFields().get("job_exec_status").toString();
	}
	
	public String getScheduleUri() {
		return event.getFields().get("schedule_uri").toString();
	}
	
	public String getExecutionUri() {
		return event.getFields().get("execution_uri").toString();
	}
}
