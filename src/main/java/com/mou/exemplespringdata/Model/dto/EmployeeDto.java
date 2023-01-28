package com.mou.exemplespringdata.Model.dto;

import com.mou.exemplespringdata.Model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private Integer id;
    private String name;
    private String address;

    public static EmployeeDto toEmployeeDto(Employee employee){
        return EmployeeDto
                .builder()
                .id(employee.getId())
                .name(employee.getName())
                .address(employee.getAddress())
                .build();
    }
}
