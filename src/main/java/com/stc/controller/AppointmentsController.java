package com.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stc.request.AppointmentRequest;
import com.stc.serviceImpl.AppointmentsServieImpl;



import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin(allowedHeaders = "*", allowCredentials = "false", origins = "*")
@RestController
@RequestMapping(path = "/api/appointments", produces = "application/json")
public class AppointmentsController {
	
	
	@Autowired
	AppointmentsServieImpl appointmentService;
	
	
	
	
	
	@ApiOperation(value = "home ", nickname = "get all appointments")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ResponseEntity<?> home() {
           return new ResponseEntity<>(appointmentService.listAllAppointmentsToday(), HttpStatus.OK);	
	}

	
	@ApiOperation(value = "add ", nickname = "add new appointment")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody AppointmentRequest request) {
        return new ResponseEntity<>(appointmentService.addAppointment(request), HttpStatus.OK);	
		
	}
	
	
	@ApiOperation(value = "filterByName ", nickname = "filterByName")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(value = "/filterByName", method = RequestMethod.GET)
	public ResponseEntity<?> filterByName(@RequestParam("name") String patientName) {
        return new ResponseEntity<>(appointmentService.filterByName(patientName), HttpStatus.OK);	

	}
	
	
	@ApiOperation(value = "filterByDate ", nickname = "filterByDate")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(value = "/filterByDate", method = RequestMethod.GET)
	public ResponseEntity<?> filterByDate(@RequestParam("date") String date) {
        return new ResponseEntity<>(appointmentService.filterByDate(date), HttpStatus.OK);	

	}
	
	
	
	@ApiOperation(value = "cancel ", nickname = "cancel an appointment")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public ResponseEntity<?> cancel(@RequestParam("reservationCode") Long code , @RequestParam("CancelReason") String CancelReason) {
        return new ResponseEntity<>(appointmentService.cancelAppointmentByName(code, CancelReason), HttpStatus.OK);	

	}
	
	
	
	@ApiOperation(value = "previewByName ", nickname = "preview appointments by name ByName")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	@RequestMapping(value = "/previewByName", method = RequestMethod.GET)
	public ResponseEntity<?> previewByName(@RequestParam("patientName") String patientName) {
        return new ResponseEntity<>(appointmentService.previewPatientAppointmentHistoryByName(patientName), HttpStatus.OK);	

	}
	
	
	
	
	
	
	
	
}
