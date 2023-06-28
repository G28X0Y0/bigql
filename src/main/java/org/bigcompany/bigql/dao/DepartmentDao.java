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

    public void createDepartment(Department department) {
        departments.add(department);
    }

    public Department updateDepartment(Department department) {
        try{
            Department departmentToUpdate = getDepartment(department.getId());
            departmentToUpdate.setName(department.getName());
            departmentToUpdate.setOrgId(department.getOrgId());
            departmentToUpdate.setEmployee(department.getEmployee());
            return departmentToUpdate;
        } catch (Exception e) {
            System.out.println("Error updating department: " + e.getMessage());
            return null;
        }
    }

    public boolean deleteDepartment(String id) {
        String query = "mutation"
        try{
            Department departmentToDelete = getDepartment(id);
            departments.remove(departmentToDelete);
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting department: " + e.getMessage());
            return false;
        }
    }

}

