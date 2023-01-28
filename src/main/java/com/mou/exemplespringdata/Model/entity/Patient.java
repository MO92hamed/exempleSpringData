package com.mou.exemplespringdata.Model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mou.exemplespringdata.Model.dto.PatientDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "_patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer id;
    @Column(name = "patient_name")
    private String name;
    @Column(name = "patient_address")
    private String address;
    @Column(name = "patient_age")
    private Integer age;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Payment> payments = new HashSet<>();

    public static Patient toPatientEntity(PatientDto patientDto){
        return Patient
                .builder()
                .id(patientDto.getId())
                .name(patientDto.getName())
                .address(patientDto.getAddress())
                .age(patientDto.getAge())
                .appointments(patientDto.getAppointments())
                .payments(patientDto.getPayments())
                .build();
    }
}
