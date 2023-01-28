package com.mou.exemplespringdata.Model.dto;

import com.mou.exemplespringdata.Model.entity.Appointment;
import com.mou.exemplespringdata.Model.entity.Patient;
import com.mou.exemplespringdata.Model.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private Set<Appointment> appointments = new HashSet<>();
    private Set<Payment> payments = new HashSet<>();

    public static PatientDto toPatientDto(Patient patient){
        return PatientDto
                .builder()
                .id(patient.getId())
                .name(patient.getName())
                .address(patient.getAddress())
                .age(patient.getAge())
                .appointments(patient.getAppointments())
                .payments(patient.getPayments())
                .build();
    }
}
