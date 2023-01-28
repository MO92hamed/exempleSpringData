package com.mou.exemplespringdata.Model.dto;

import com.mou.exemplespringdata.Model.entity.Appointment;
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
public class DoctorDto {
    private Integer id;
    private String name;
    private String speciality;
    private String address;
    private Set<Appointment> appointments = new HashSet<>();
    private Department department;

    public static DoctorDto toDoctorDto(Doctor doctor){
        return DoctorDto
                .builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .speciality(doctor.getSpeciality())
                .address(doctor.getAddress())
                .appointments(doctor.getAppointments())
                .department(doctor.getDepartment())
                .build();
    }
}
