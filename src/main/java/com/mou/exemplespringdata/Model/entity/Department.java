package com.mou.exemplespringdata.Model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mou.exemplespringdata.Model.dto.DepartmentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "_department")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer id;
    @Column(name = "department_name")
    private String name;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private Set<Doctor> doctors = new HashSet<>();

    public static Department toDepartmentEntity(DepartmentDto departmentDto){
        return
                Department
                        .builder()
                        .id(departmentDto.getId())
                        .name(departmentDto.getName())
                        .doctors(departmentDto.getDoctors())
                        .build();
    }
}
