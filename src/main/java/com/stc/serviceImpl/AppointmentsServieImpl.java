package com.stc.serviceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stc.Repository.AppointmentRepository;
import com.stc.entity.AppointmentEntity;
import com.stc.request.AppointmentRequest;
import com.stc.response.AppointmentResponse;
import com.stc.service.AppointmentsService;
import com.stc.utils.Util;

import net.bytebuddy.description.type.TypeDefinition.Sort;


@Service
public class AppointmentsServieImpl implements AppointmentsService {

	@Autowired
	AppointmentRepository appointmentRepo;

	@Autowired
	AppointmentResponse appointmentRes;

	@Autowired
	AppointmentRequest AppointmentReq;
	
	
	@Autowired
	Util util;

	@Override
	public ResponseEntity<?> listAllAppointmentsToday() {

	     Date date = Calendar.getInstance().getTime();  		
		List<AppointmentEntity> appointments = appointmentRepo.findByreservationDate(util.convertDateToDateString(date));

		if (appointments != null) {
			return new ResponseEntity<>(appointmentRes.mapEntityToResponse(appointments), HttpStatus.OK);

		}

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> addAppointment(AppointmentRequest appointment) {	
		return new ResponseEntity<>(appointmentRepo.save(AppointmentReq.mapRequestToEntity(appointment)),
				HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> previewPatientAppointmentHistoryByName(String patientName) {

		return new ResponseEntity<>((appointmentRes.mapEntityToResponse(appointmentRepo.findByName(patientName))),
				HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> cancelAppointmentByName(Long reservationCode, String CancelReason) {

		AppointmentEntity appointment = appointmentRepo.findByresevationCode(reservationCode);
	     Date date = Calendar.getInstance().getTime();  		
		appointment.setCancelReason(CancelReason);
		appointment.setCancelDate(util.convertDateToDateString(date));
		appointment.setIs_cancelled(true);
		return new ResponseEntity<>(appointmentRepo.save(appointment), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> filterByName(String patientName) {

		return new ResponseEntity<>((appointmentRes.mapEntityToResponse(appointmentRepo.findByName(patientName))),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> filterByDate(String date) {
		date=util.convertDateStringToSpecificFormat(date);
		return new ResponseEntity<>((appointmentRes.mapEntityToResponse(appointmentRepo.findByreservationDate(date))),
				HttpStatus.OK);
	}

}
