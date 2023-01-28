package com.mou.exemplespringdata.Repository;

import com.mou.exemplespringdata.Model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
