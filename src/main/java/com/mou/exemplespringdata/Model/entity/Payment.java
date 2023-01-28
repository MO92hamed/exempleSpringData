package com.mou.exemplespringdata.Model.entity;

import com.mou.exemplespringdata.Model.dto.PaymentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "_payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer id;
    @Column(name = "payment_method")
    private  String method;
    @Column(name = "payment_amount")
    private Double amount;
    @Column(name = "payment_date")
    private String date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;
    public static Payment toPaymentEntity(PaymentDto paymentDto){
        return Payment
                .builder()
                .id(paymentDto.getId())
                .method(paymentDto.getMethod())
                .amount(paymentDto.getAmount())
                .date(paymentDto.getDate())
                .patient(paymentDto.getPatient())
                .receipt(paymentDto.getReceipt())
                .build();
    }
}
