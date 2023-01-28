package com.mou.exemplespringdata.Service;

import com.mou.exemplespringdata.Model.dto.DepartmentDto;
import com.mou.exemplespringdata.Model.entity.Department;
import com.mou.exemplespringdata.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public DepartmentDto getById(Integer id){
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent())
            return DepartmentDto.toDepartmentDto(department.get());
        else
            return null;
    }

    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    public Boolean isExist(Integer id){
        return departmentRepository.existsById(id);
    }

    public void deleteOne(Integer id){
        departmentRepository.deleteById(id);
    }

    public void deleteAll(){
        departmentRepository.deleteAll();
    }

    public DepartmentDto createOne(DepartmentDto departmentDto){
        return DepartmentDto
                .toDepartmentDto(departmentRepository.save(Department.toDepartmentEntity(departmentDto)));
    }

    public DepartmentDto updateOne(DepartmentDto departmentDto){
        return DepartmentDto
                .toDepartmentDto(departmentRepository.save(Department.toDepartmentEntity(departmentDto)));
    }
}
