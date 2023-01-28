package com.mou.exemplespringdata.Repository;

import com.mou.exemplespringdata.Model.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
}
