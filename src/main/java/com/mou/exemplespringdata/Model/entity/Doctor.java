package com.mou.exemplespringdata.Model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mou.exemplespringdata.Model.dto.DoctorDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "_doctor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer id;
    @Column(name = "doctor_name")
    private String name;
    @Column(name = "doctor_speciality")
    private String speciality;
    @Column(name = "doctor_address")
    private String address;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    public static Doctor toDoctorEntity(DoctorDto doctorDto){
        return Doctor
                .builder()
                .id(doctorDto.getId())
                .name(doctorDto.getName())
                .speciality(doctorDto.getSpeciality())
                .address(doctorDto.getAddress())
                .appointments(doctorDto.getAppointments())
                .department(doctorDto.getDepartment())
                .build();
    }

}
