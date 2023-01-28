package com.mou.exemplespringdata.Service;

import com.mou.exemplespringdata.Model.dto.DepartmentDto;
import com.mou.exemplespringdata.Model.dto.DoctorDto;
import com.mou.exemplespringdata.Model.entity.Doctor;
import com.mou.exemplespringdata.Repository.DepartmentRepository;
import com.mou.exemplespringdata.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public DoctorDto getOne(Integer id){
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent())
            return DoctorDto.toDoctorDto(doctor.get());
        else
            return null;
    }

    public List<Doctor> getAll(){
        return doctorRepository.findAll();
    }

    public Boolean isExist(Integer id){
        return doctorRepository.existsById(id);
    }

    public void deleteOne(Integer id){
        departmentRepository.deleteById(id);
    }

    public void deleteAll(){
        departmentRepository.deleteAll();
    }

    public DoctorDto createOne(DoctorDto doctorDto){
        return
                DoctorDto.toDoctorDto(doctorRepository.save(Doctor.toDoctorEntity(doctorDto)));
    }

    public DoctorDto updateOne(DoctorDto doctorDto){
        return
                DoctorDto.toDoctorDto(doctorRepository.save(Doctor.toDoctorEntity(doctorDto)));
    }
}
