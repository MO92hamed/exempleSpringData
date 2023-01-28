package com.mou.exemplespringdata.Service;

import com.mou.exemplespringdata.Model.dto.EmployeeDto;
import com.mou.exemplespringdata.Model.entity.Employee;
import com.mou.exemplespringdata.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDto getOne(Integer id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent())
            return EmployeeDto.toEmployeeDto(employee.get());
        else
            return null;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Boolean isExist(Integer id){
        return employeeRepository.existsById(id);
    }

    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    }

    public void deleteAll(){
        employeeRepository.deleteAll();
    }

    public EmployeeDto createOne(EmployeeDto employeeDto){
        return
                EmployeeDto.toEmployeeDto(employeeRepository.save(Employee.toEmployeeEntity(employeeDto)));
    }

    public EmployeeDto updateOne(EmployeeDto employeeDto){
        return
                EmployeeDto.toEmployeeDto(employeeRepository.save(Employee.toEmployeeEntity(employeeDto)));

    }

}
