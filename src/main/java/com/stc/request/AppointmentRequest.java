package com.stc.request;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stc.entity.AppointmentEntity;

@Component
public class AppointmentRequest {
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("reservation_date")
	private String reservation_date;


	public AppointmentRequest() {
		super();
	}
	
	

	public AppointmentRequest(String name, String reservation_date) {
		super();
		this.name = name;
		this.reservation_date = reservation_date;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}

	
	public AppointmentEntity mapRequestToEntity(AppointmentRequest request){
		
		long millis = new java.util.Date().getTime();
		AppointmentEntity entity=new AppointmentEntity();
		entity.setName(request.getName());
		entity.setReservationDate(request.getReservation_date());
		entity.setResevationCode(millis);
		
		return entity;
		
		
	}
	

}
