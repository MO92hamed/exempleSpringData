package com.mou.exemplespringdata.Service;

import com.mou.exemplespringdata.Model.dto.AppointmentDto;
import com.mou.exemplespringdata.Model.entity.Appointment;
import com.mou.exemplespringdata.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentDto getOne(Integer id){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent())
            return AppointmentDto.toAppointmentDto(appointment.get());
        else
            return null;
    }

    public List<Appointment> getAll(){
        return appointmentRepository.findAll();
    }

    public void deleteOneById(Integer id){
        appointmentRepository.deleteById(id);
    }

    public void deleteAll(){
        appointmentRepository.deleteAll();
    }

    public Boolean isExist(Integer id){
        return appointmentRepository.existsById(id);
    }

    public AppointmentDto createOne(AppointmentDto appointmentDto){
        return
                AppointmentDto.toAppointmentDto(appointmentRepository.save(Appointment.ToAppointmentEntity(appointmentDto)));
    }

    public AppointmentDto updateOne(AppointmentDto appointmentDto){
        return
                AppointmentDto.toAppointmentDto(appointmentRepository.save(Appointment.ToAppointmentEntity(appointmentDto)));
    }


}
