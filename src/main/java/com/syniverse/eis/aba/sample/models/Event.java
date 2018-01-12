package com.syniverse.eis.aba.sample.models;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
	@JsonProperty("fld-val-list") private Map<String, Object> fields;
	@JsonProperty("evt-tp") private String type;
	@JsonProperty("timestamp") private Date time;
	
	public Map<String, Object> getFields() {
		return fields;
	}
	public void setFields(Map<String, Object> fields) {
		this.fields = fields;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
