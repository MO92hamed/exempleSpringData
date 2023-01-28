package com.mou.exemplespringdata.Repository;

import com.mou.exemplespringdata.Model.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
}
