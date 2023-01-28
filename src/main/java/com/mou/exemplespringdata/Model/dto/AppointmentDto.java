package com.mou.exemplespringdata.Model.dto;

import com.mou.exemplespringdata.Model.entity.Appointment;
import com.mou.exemplespringdata.Model.entity.Doctor;
import com.mou.exemplespringdata.Model.entity.Patient;
import com.mou.exemplespringdata.Model.entity.Receipt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDto {
    private Integer id;
    private String reason;
    private Integer number;
    private String date;
    private Doctor doctor;
    private Patient patient;
    private Receipt receipt;

    public static AppointmentDto toAppointmentDto(Appointment appointment){
        return AppointmentDto
                .builder()
                .reason(appointment.getReason())
                .number(appointment.getNumber())
                .date(appointment.getDate())
                .doctor(appointment.getDoctor())
                .patient(appointment.getPatient())
                .receipt(appointment.getReceipt())
                .build();
    }
}
