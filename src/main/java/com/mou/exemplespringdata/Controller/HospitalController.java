package com.mou.exemplespringdata.Controller;

import com.mou.exemplespringdata.Model.dto.HospitalDto;
import com.mou.exemplespringdata.Model.entity.Employee;
import com.mou.exemplespringdata.Model.entity.Hospital;
import com.mou.exemplespringdata.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping("/{id}")
    public ResponseEntity<HospitalDto> getHospital(@PathVariable Integer id){
        HospitalDto hospitalDto = hospitalService.getOne(id);
        return new ResponseEntity<>(hospitalDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospital(){
        List<Hospital> hospitals = hospitalService.getAll();
        return new ResponseEntity<>(hospitals, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHospital(@PathVariable Integer id){
        hospitalService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllHospitals(){
        hospitalService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HospitalDto> addHospital(@RequestBody HospitalDto hospitalDto){
        HospitalDto hospitalDto1 = hospitalService.createOne(hospitalDto);
        return new ResponseEntity<>(hospitalDto1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HospitalDto> updateHospital(@RequestBody HospitalDto hospitalDto){
        HospitalDto hospitalDto1 = hospitalService.updateOne(hospitalDto);
        return new ResponseEntity<>(hospitalDto1, HttpStatus.OK);
    }
}
