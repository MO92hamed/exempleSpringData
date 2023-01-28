package com.mou.exemplespringdata.Repository;

import com.mou.exemplespringdata.Model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
