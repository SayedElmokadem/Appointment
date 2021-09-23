package com.stc.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stc.entity.AppointmentEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
	
	@Query(value = "SELECT a FROM AppointmentEntity a where a.name=:name")
	public List<AppointmentEntity> findByName(@Param("name") String name);
	
	@Query(value = "SELECT a FROM AppointmentEntity a where a.reservationDate=:date")
	public List<AppointmentEntity> findByreservationDate(@Param("date") String date);
	
	@Query(value = "SELECT a FROM AppointmentEntity a where a.resevationCode=:resevationCode")
	public AppointmentEntity findByresevationCode(@Param("resevationCode") Long resevationCode);
	
	
	
	
	

}
