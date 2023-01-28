package com.mou.exemplespringdata.Repository;

import com.mou.exemplespringdata.Model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
