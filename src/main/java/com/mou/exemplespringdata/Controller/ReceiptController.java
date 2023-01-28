package com.mou.exemplespringdata.Controller;

import com.mou.exemplespringdata.Model.dto.ReceiptDto;
import com.mou.exemplespringdata.Model.entity.Receipt;
import com.mou.exemplespringdata.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    @GetMapping("/{id}")
    public ResponseEntity<ReceiptDto> getReceipt(@PathVariable Integer id){
        ReceiptDto receiptDto = receiptService.getOne(id);
        return new ResponseEntity<>(receiptDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Receipt>> getAllReceipts(){
        List<Receipt> receipts = receiptService.getAll();
        return new ResponseEntity<>(receipts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReceipt(@PathVariable Integer id){
        receiptService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllReceipts(){
        receiptService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReceiptDto> addReceipt(@RequestBody ReceiptDto receiptDto){
        ReceiptDto receiptDto1 = receiptService.createOne(receiptDto);
        return new ResponseEntity<>(receiptDto1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ReceiptDto> updateReceipt(@RequestBody ReceiptDto receiptDto){
        ReceiptDto receiptDto1 = receiptService.updateOne(receiptDto);
        return new ResponseEntity<>(receiptDto1, HttpStatus.OK);
    }
}
