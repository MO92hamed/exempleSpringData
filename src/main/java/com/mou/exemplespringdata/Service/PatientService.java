package com.mou.exemplespringdata.Service;

import com.mou.exemplespringdata.Model.dto.PatientDto;
import com.mou.exemplespringdata.Model.entity.Patient;
import com.mou.exemplespringdata.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public PatientDto getOne(Integer id){
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent())
            return PatientDto.toPatientDto(patient.get());
        else
            return null;
    }

    public List<Patient> getAll(){
        return patientRepository.findAll();
    }

    public Boolean isExist(Integer id){
        return patientRepository.existsById(id);
    }

    public void deleteOne(Integer id){
        patientRepository.deleteById(id);
    }

    public void deleteAll(){
        patientRepository.deleteAll();
    }

    public PatientDto createOne(PatientDto patientDto){
        return
                PatientDto.toPatientDto(patientRepository.save(Patient.toPatientEntity(patientDto)));
    }

    public PatientDto updateOne(PatientDto patientDto){
        return
                PatientDto.toPatientDto(patientRepository.save(Patient.toPatientEntity(patientDto)));
    }
}
