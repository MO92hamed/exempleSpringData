package com.mou.exemplespringdata.Repository;

import com.mou.exemplespringdata.Model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
