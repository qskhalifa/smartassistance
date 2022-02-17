package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Department;
import com.smartassistance.Repo.DepartmentRepository;
import com.smartassistance.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        //Checking if the department already Exist in the DB
        Department existDepartment = departmentRepository.findDepartmentByCode(department.getCode()).orElse(null);

        if (existDepartment == null) {
            return departmentRepository.save(department);
        }

        return null;
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        // Check if there is department with the given ID
        Department existDepartment = departmentRepository.findById(departmentId).orElse(null);

        if (existDepartment != null) {
            existDepartment.setDepartmentName(department.getDepartmentName());
            existDepartment.setCode(department.getCode());
            existDepartment.setCollege(department.getCollege());
            return departmentRepository.save(existDepartment);
        }

        return null;
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    @Override
    public Department getDepartmentByCode(Integer departmentCode) {
        return departmentRepository.findDepartmentByCode(departmentCode).orElse(null);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public boolean deleteDepartment(Long departmentId) {
        // Check if there is department with the given ID
        Department existDepartment = departmentRepository.findById(departmentId).orElse(null);

        if (existDepartment != null) {
            departmentRepository.delete(existDepartment);
            return true;
        }

        return false;
    }
}
