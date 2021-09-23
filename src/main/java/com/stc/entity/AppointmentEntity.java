package com.stc.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="appointments")
public class AppointmentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "recid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Column(name = "name")
	private String name;

	@Column(name = "reservation_date")
	private String reservationDate;

	@Column(name = "is_cancelled")
	private Boolean is_cancelled;

	@Column(name = "cancelReason")
	private String cancelReason;

	
	@Column(name = "resevationCode")
	private Long resevationCode;

	@Column(name = "cancelDate")
	private String cancelDate;

	public AppointmentEntity() {
		super();
	}

	

	public AppointmentEntity(String name, String reservationDate, Boolean is_cancelled, String cancelReason,
			Long resevationCode, String cancelDate) {
		super();
		this.name = name;
		this.reservationDate = reservationDate;
		this.is_cancelled = is_cancelled;
		this.cancelReason = cancelReason;
		this.resevationCode = resevationCode;
		this.cancelDate = cancelDate;
	}



	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Boolean getIs_cancelled() {
		return is_cancelled;
	}

	public void setIs_cancelled(Boolean is_cancelled) {
		this.is_cancelled = is_cancelled;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Long getResevationCode() {
		return resevationCode;
	}

	public void setResevationCode(Long resevationCode) {
		this.resevationCode = resevationCode;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}


	

}
