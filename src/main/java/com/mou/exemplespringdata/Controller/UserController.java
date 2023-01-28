package com.mou.exemplespringdata.Controller;

import com.mou.exemplespringdata.Model.dto.ReceiptDto;
import com.mou.exemplespringdata.Model.dto.UserDto;
import com.mou.exemplespringdata.Model.entity.Receipt;
import com.mou.exemplespringdata.Model.entity.User;
import com.mou.exemplespringdata.Service.ReceiptService;
import com.mou.exemplespringdata.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getReceipt(@PathVariable Integer id){
        UserDto userDto = userService.getOne(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllReceipts(){
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReceipt(@PathVariable Integer id){
        userService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllReceipts(){
        userService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> addReceipt(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.createOne(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateReceipt(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.updateOne(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.OK);
    }
}
