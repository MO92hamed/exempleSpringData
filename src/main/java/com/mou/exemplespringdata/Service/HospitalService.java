package com.mou.exemplespringdata.Service;

import com.mou.exemplespringdata.Model.dto.HospitalDto;
import com.mou.exemplespringdata.Model.entity.Hospital;
import com.mou.exemplespringdata.Repository.DoctorRepository;
import com.mou.exemplespringdata.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public HospitalDto getOne(Integer id){
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent())
            return HospitalDto.toHospitalDto(hospital.get());
        else
            return null;
    }

    public List<Hospital> getAll(){
        return hospitalRepository.findAll();
    }

    public Boolean isExist(Integer id){
        return hospitalRepository.existsById(id);
    }

    public void deleteOne(Integer id){
        hospitalRepository.deleteById(id);
    }

    public void deleteAll(){
        hospitalRepository.deleteAll();
    }

    public HospitalDto createOne(HospitalDto hospitalDto){
        return
                HospitalDto.toHospitalDto(hospitalRepository.save(Hospital.toHospitalEntity(hospitalDto)));
    }

    public HospitalDto updateOne(HospitalDto hospitalDto){
        return
                HospitalDto.toHospitalDto(hospitalRepository.save(Hospital.toHospitalEntity(hospitalDto)));
    }
}
