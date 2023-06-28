package org.bigcompany.bigql.dao;

import org.bigcompany.bigql.model.Department;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentDao {
    private final List<Department> departments;

    public DepartmentDao(List<Department> departments) {this.departments = departments;}

    public List<Department> getDepartments(){
        return departments.stream()
                .collect(Collectors.toList());
    }

    public Department getDepartment(String id){
        return departments.stream()
                .filter(department -> id.equals(department.getId()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<Department> getDepartmentsInOrg(String org){
        return departments.stream()
                .filter(department -> org.equals(department.getOrgId()))
                .collect(Collectors.toList());
    }

    public void createDepartment(Department department) {
        departments.add(department);
    }
}

