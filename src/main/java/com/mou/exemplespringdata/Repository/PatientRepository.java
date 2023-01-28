package com.mou.exemplespringdata.Repository;

import com.mou.exemplespringdata.Model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
