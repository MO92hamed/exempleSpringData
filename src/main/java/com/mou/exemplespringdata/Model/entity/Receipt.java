package com.mou.exemplespringdata.Model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mou.exemplespringdata.Model.dto.ReceiptDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "_receipt")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private Integer id;
    @Column(name = "receipt_status")
    private String status;

    @OneToMany(mappedBy = "receipt")
    @JsonIgnore
    private Set<Payment> payments = new HashSet<>();

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    public static Receipt toReceiptEntity(ReceiptDto receiptDto){
        return Receipt
                .builder()
                .id(receiptDto.getId())
                .status(receiptDto.getStatus())
                .payments(receiptDto.getPayments())
                .appointment(receiptDto.getAppointment())
                .build();
    }
}
