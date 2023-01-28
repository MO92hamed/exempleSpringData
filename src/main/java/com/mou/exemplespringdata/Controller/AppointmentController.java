package com.mou.exemplespringdata.Controller;

import com.mou.exemplespringdata.Model.dto.AppointmentDto;
import com.mou.exemplespringdata.Model.entity.Appointment;
import com.mou.exemplespringdata.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointment(@PathVariable Integer id){
        AppointmentDto appointmentDto = appointmentService.getOne(id);
        return new ResponseEntity<>(appointmentDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        List<Appointment> appointments = appointmentService.getAll();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Integer id){
        appointmentService.deleteOneById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllAppointment(){
        appointmentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto appointmentDto1 = appointmentService.createOne(appointmentDto);
        return new ResponseEntity<>(appointmentDto1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AppointmentDto> updateAppointment(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto appointmentDto1 = appointmentService.updateOne(appointmentDto);
        return new ResponseEntity<>(appointmentDto1, HttpStatus.OK);
    }



   /* @GetMapping("/")
    public AppointmentDto getById(@PathVariable Integer id){
        return appointmentService.getOne(id);
    }

    @GetMapping
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAll();
    }

    @GetMapping("/exist")
    public Boolean isAppointmentExists(@RequestParam Integer id){
        return appointmentService.isExist(id);
    }

    @DeleteMapping("/")
    public void deleteAppointment(@PathVariable Integer id){
        appointmentService.deleteOneById(id);
    }

    @DeleteMapping
    public void deleteAllAppointment(){
        appointmentService.deleteAll();
    }

    @PostMapping
    public AppointmentDto addAppointment(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.createOne(appointmentDto);
    }

    @PutMapping
    public AppointmentDto updateAppointment(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.updateOne(appointmentDto);
    }*/
}
