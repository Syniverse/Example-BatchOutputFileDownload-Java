package com.syniverse.eis.aba.sample.controllers;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.syniverse.eis.aba.sample.models.Event;
import com.syniverse.eis.aba.sample.processors.JobCompletedEventProcessor;


/**
 * Intended to receive notifications for ABA events dispatched by ESS. 
 * Set up an ESS delivery configuration in SDC on this endpoint to have events sent to this sample.
 */
@Path("/ess/event-delivery")
public class EssEventController {
	/**
	 * Jersey/Jackson unmarshalls request JSON to object of this type.
	 */
	public static class EventDeliveryRequest {
		private String topic;
		private Integer attempt;
		@JsonProperty("event-id") private String eventId;
		private Event event;
		public String getTopic() {
			return topic;
		}
		public void setTopic(String topic) {
			this.topic = topic;
		}
		public Integer getAttempt() {
			return attempt;
		}
		public void setAttempt(Integer attempt) {
			this.attempt = attempt;
		}
		public String getEventId() {
			return eventId;
		}
		public void setEventId(String eventId) {
			this.eventId = eventId;
		}
		public Event getEvent() {
			return event;
		}
		public void setEvent(Event event) {
			this.event = event;
		}
	}
	/**
	 * The actual endpoint. Hard coded to explicitly process only ABA job completion events.
	 * @param eventDeliveryRequest Request body
	 * @return nothing of consequence
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response receiveEvent(EventDeliveryRequest eventDeliveryRequest) {
		if ("aba_job_completed".equals(eventDeliveryRequest.getEvent().getType())) {
			new JobCompletedEventProcessor(eventDeliveryRequest.getEvent()).process();
		}
		return Response.ok().build();
	}
}
