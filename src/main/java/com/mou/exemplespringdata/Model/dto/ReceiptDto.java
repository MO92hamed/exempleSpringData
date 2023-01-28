package com.mou.exemplespringdata.Model.dto;

import com.mou.exemplespringdata.Model.entity.Appointment;
import com.mou.exemplespringdata.Model.entity.Payment;
import com.mou.exemplespringdata.Model.entity.Receipt;
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
public class ReceiptDto {
    private Integer id;
    private String status;
    private Set<Payment> payments = new HashSet<>();
    private Appointment appointment;

    public static ReceiptDto toReceiptDto(Receipt receipt){
        return ReceiptDto
                .builder()
                .id(receipt.getId())
                .status(receipt.getStatus())
                .payments(receipt.getPayments())
                .appointment(receipt.getAppointment())
                .build();
    }
}
