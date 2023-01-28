package com.mou.exemplespringdata.Model.dto;

import com.mou.exemplespringdata.Model.entity.Patient;
import com.mou.exemplespringdata.Model.entity.Payment;
import com.mou.exemplespringdata.Model.entity.Receipt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private Integer id;
    private String method;
    private Double amount;
    private String date;
    private Patient patient;
    private Receipt receipt;

    public static PaymentDto toPaymentDto(Payment payment){
        return PaymentDto
                .builder()
                .id(payment.getId())
                .method(payment.getMethod())
                .amount(payment.getAmount())
                .date(payment.getDate())
                .patient(payment.getPatient())
                .receipt(payment.getReceipt())
                .build();
    }
}
