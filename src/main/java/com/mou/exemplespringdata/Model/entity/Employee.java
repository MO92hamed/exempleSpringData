package com.mou.exemplespringdata.Model.entity;

import com.mou.exemplespringdata.Model.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "_employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_address")
    private String address;

    public static Employee toEmployeeEntity(EmployeeDto employeeDto){
        return Employee
                .builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .address(employeeDto.getAddress())
                .build();
    }
}
