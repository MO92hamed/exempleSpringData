package com.mou.exemplespringdata.Controller;

import com.mou.exemplespringdata.Model.dto.DoctorDto;
import com.mou.exemplespringdata.Model.entity.Doctor;
import com.mou.exemplespringdata.Repository.DoctorRepository;
import com.mou.exemplespringdata.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable Integer id){
        DoctorDto doctorDto = doctorService.getOne(id);
        return new ResponseEntity<>(doctorDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List doctors = doctorService.getAll();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Integer id){
        doctorService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllDoctors(){
        doctorService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto doctorDto1 = doctorService.createOne(doctorDto);
        return new ResponseEntity<>(doctorDto1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto doctorDto1 = doctorService.updateOne(doctorDto);
        return new ResponseEntity<>(doctorDto1, HttpStatus.OK);
    }

   /* @GetMapping("/{id}")
    public DoctorDto getDoctorById(@PathVariable("id") Integer id){
        return doctorService.getOne(id);
    }

    @GetMapping
    public List<Doctor> getAllDoctor(){
        return doctorService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable("id") Integer id){
        doctorService.deleteOne(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        doctorService.deleteAll();
    }

    @PostMapping
    public DoctorDto addDoctor(@RequestBody DoctorDto doctorDto){
        return doctorService.createOne(doctorDto);
    }

    @PutMapping
    public DoctorDto updateDoctor(@RequestBody DoctorDto doctorDto){
        return doctorService.updateOne(doctorDto);
    }*/
}
