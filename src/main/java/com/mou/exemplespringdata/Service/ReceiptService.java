package com.mou.exemplespringdata.Service;

import com.mou.exemplespringdata.Model.dto.ReceiptDto;
import com.mou.exemplespringdata.Model.entity.Receipt;
import com.mou.exemplespringdata.Repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReceiptService {
    @Autowired
    ReceiptRepository receiptRepository;

    public ReceiptDto getOne(Integer id){
        Optional<Receipt> receipt = receiptRepository.findById(id);
        if (receipt.isPresent())
            return ReceiptDto.toReceiptDto(receipt.get());
        else
            return null;
    }

    public List<Receipt> getAll(){
        return receiptRepository.findAll();
    }

    public Boolean isExist(Integer id){
        return receiptRepository.existsById(id);
    }

    public void deleteOne(Integer id){
        receiptRepository.deleteById(id);
    }

    public void deleteAll(){
        receiptRepository.deleteAll();
    }

    public ReceiptDto createOne(ReceiptDto receiptDto){
        return
                ReceiptDto.toReceiptDto(receiptRepository.save(Receipt.toReceiptEntity(receiptDto)));
    }

    public ReceiptDto updateOne(ReceiptDto receiptDto){
        return
                ReceiptDto.toReceiptDto(receiptRepository.save(Receipt.toReceiptEntity(receiptDto)));
    }
}
