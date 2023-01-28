package com.mou.exemplespringdata.Repository;

import com.mou.exemplespringdata.Model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
