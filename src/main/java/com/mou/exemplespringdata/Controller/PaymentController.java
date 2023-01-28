package com.mou.exemplespringdata.Controller;

import com.mou.exemplespringdata.Model.dto.PatientDto;
import com.mou.exemplespringdata.Model.dto.PaymentDto;
import com.mou.exemplespringdata.Model.entity.Payment;
import com.mou.exemplespringdata.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getPayment(@PathVariable Integer id){
        PaymentDto paymentDto = paymentService.getOne(id);
        return new ResponseEntity<>(paymentDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayment(){
        List<Payment> payments = paymentService.getAll();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable Integer id){
        paymentService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllPayment(){
        paymentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentDto> addPatient(@RequestBody PaymentDto paymentDto){
        PaymentDto paymentDto1 = paymentService.createOne(paymentDto);
        return new ResponseEntity<>(paymentDto1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PaymentDto> updatePayment(@RequestBody PaymentDto paymentDto){
        PaymentDto paymentDto1 = paymentService.updateOne(paymentDto);
        return new ResponseEntity<>(paymentDto1, HttpStatus.OK);
    }
}
