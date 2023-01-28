package com.mou.exemplespringdata.Model.dto;

import com.mou.exemplespringdata.Model.entity.Department;
import com.mou.exemplespringdata.Model.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
    private Integer id;
    private String name;

    private Set<Doctor> doctors = new HashSet<>();

    public static DepartmentDto toDepartmentDto(Department department){
        return
                DepartmentDto
                        .builder()
                        .id(department.getId())
                        .name(department.getName())
                        .doctors(department.getDoctors())
                        .build();
    }
}
