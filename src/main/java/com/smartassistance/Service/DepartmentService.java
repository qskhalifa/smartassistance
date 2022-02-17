package com.smartassistance.Service;

import com.smartassistance.Model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    Department createDepartment(Department department);
    Department updateDepartment(Department department, Long departmentId);
    Department getDepartmentById(Long departmentId);
    Department getDepartmentByCode(Integer departmentCode);
    List<Department> getAllDepartments();
    boolean deleteDepartment(Long departmentId);
}
