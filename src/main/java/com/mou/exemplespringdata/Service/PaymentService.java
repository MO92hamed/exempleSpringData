package com.mou.exemplespringdata.Service;

import com.mou.exemplespringdata.Model.dto.PaymentDto;
import com.mou.exemplespringdata.Model.entity.Payment;
import com.mou.exemplespringdata.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public PaymentDto getOne(Integer id){
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent())
            return PaymentDto.toPaymentDto(payment.get());
        else
            return null;
    }

    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    public Boolean isExist(Integer id){
        return paymentRepository.existsById(id);
    }

    public void deleteOne(Integer id){
        paymentRepository.deleteById(id);
    }

    public void deleteAll(){
        paymentRepository.deleteAll();
    }

    public PaymentDto createOne(PaymentDto paymentDto){
        return
                PaymentDto.toPaymentDto(paymentRepository.save(Payment.toPaymentEntity(paymentDto)));
    }

    public PaymentDto updateOne(PaymentDto paymentDto){
        return
                PaymentDto.toPaymentDto(paymentRepository.save(Payment.toPaymentEntity(paymentDto)));
    }
}
