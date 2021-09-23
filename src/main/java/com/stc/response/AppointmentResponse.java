package com.stc.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stc.entity.AppointmentEntity;

@Component
public class AppointmentResponse {

	@JsonProperty("name")
	private String name;

	@JsonProperty("reservation_date")
	private String reservation_date;

	@JsonProperty("cancelReason")
	private String cancelReason;

	@JsonProperty("reservationCode")
	private Long reservationCode;

	@JsonProperty("cancelDate")
	private String cancelDate;

	public AppointmentResponse() {
		super();
	}

	public AppointmentResponse(String name, String reservation_date, String cancelReason, Long reservationCode,
			String cancelDate) {
		super();
		this.name = name;
		this.reservation_date = reservation_date;
		this.cancelReason = cancelReason;
		this.reservationCode = reservationCode;
		this.cancelDate = cancelDate;
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

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Long getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(Long reservationCode) {
		this.reservationCode = reservationCode;
	}

	public List<AppointmentResponse> mapEntityToResponse(List<AppointmentEntity> appointments) {

		List<AppointmentResponse> responseLst = new ArrayList<>();

		for (AppointmentEntity appointmentEntity : appointments) {
			AppointmentResponse obj = new AppointmentResponse();
			obj.name = appointmentEntity.getName();
			obj.cancelReason = appointmentEntity.getCancelReason();
			obj.reservation_date = appointmentEntity.getReservationDate();
			obj.setReservationCode(appointmentEntity.getResevationCode());
			obj.setCancelDate(appointmentEntity.getCancelDate());
			responseLst.add(obj);

		}

		return responseLst;

	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

}
