package com.mou.exemplespringdata.Controller;

import com.mou.exemplespringdata.Model.dto.DepartmentDto;
import com.mou.exemplespringdata.Model.entity.Department;
import com.mou.exemplespringdata.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Integer id){
        DepartmentDto departmentDto = departmentService.getById(id);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> departments = departmentService.getAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer id){
        departmentService.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllDepartments(){
        departmentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = departmentService.createOne(departmentDto);
        return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = departmentService.updateOne(departmentDto);
        return  new ResponseEntity<>(departmentDto1, HttpStatus.OK);
    }

    /*@GetMapping("/{id}")
    public DepartmentDto getDepartment(@PathVariable("id") Integer id){
        return departmentService.getById(id);
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAll();
    }

    @GetMapping("exist")
    public Boolean isDepartmentExist(@PathVariable Integer id){
        return departmentService.isExist(id);
    }

    @DeleteMapping("/")
    public void deleteDepartment(@PathVariable Integer id){
        departmentService.deleteOne(id);
    }

    @PostMapping
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.createOne(departmentDto);
    }

    @PutMapping
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.updateOne(departmentDto);
    }*/
}
