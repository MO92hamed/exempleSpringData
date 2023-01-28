package com.mou.exemplespringdata.Model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mou.exemplespringdata.Model.dto.AppointmentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "_appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Integer id;
    @Column(name = "appointment_reason")
    private String reason;
    @Column(name = "appointment_number")
    private Integer number;
    @Column(name = "appointment_date")
    private String date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id")
    private Receipt receipt;

    public static Appointment ToAppointmentEntity(AppointmentDto appointmentDto){
        return Appointment
                .builder()
                .reason(appointmentDto.getReason())
                .number(appointmentDto.getNumber())
                .date(appointmentDto.getDate())
                .doctor(appointmentDto.getDoctor())
                .patient(appointmentDto.getPatient())
                .receipt(appointmentDto.getReceipt())
                .build();
    }
}
