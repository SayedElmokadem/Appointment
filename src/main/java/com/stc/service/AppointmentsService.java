package com.stc.service;

import org.springframework.http.ResponseEntity;

import com.stc.request.AppointmentRequest;

public interface AppointmentsService {
	
	ResponseEntity<?> listAllAppointmentsToday();
	ResponseEntity<?> filterByName(String patientName);
	ResponseEntity<?> filterByDate(String date);
	ResponseEntity<?> addAppointment(AppointmentRequest appointment);
	ResponseEntity<?> previewPatientAppointmentHistoryByName(String patientName);
	ResponseEntity<?> cancelAppointmentByName(Long reservationCode,String CancelReason);





	
	

}
