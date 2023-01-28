package com.mou.exemplespringdata.Controller;

import com.mou.exemplespringdata.Model.dto.EmployeeDto;
import com.mou.exemplespringdata.Model.dto.PatientDto;
import com.mou.exemplespringdata.Model.entity.Patient;
import com.mou.exemplespringdata.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable Integer id){
        PatientDto patientDto = patientService.getOne(id);
        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatient(){
        List<Patient> patients = patientService.getAll();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer id){
        patientService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllPatient(){
        patientService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patientDto){
        PatientDto patientDto1 = patientService.createOne(patientDto);
        return new ResponseEntity<>(patientDto1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto){
        PatientDto patientDto1 = patientService.updateOne(patientDto);
        return new ResponseEntity<>(patientDto1, HttpStatus.OK);
    }
}
