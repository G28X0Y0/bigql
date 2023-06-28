package org.bigcompany.bigql.controller;

import org.bigcompany.bigql.dao.DepartmentDao;
import org.bigcompany.bigql.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.UUID;

@RestController
public class DepartmentController {

    @Autowired
    private final DepartmentDao departmentDao;

    public DepartmentController(DepartmentDao departmentDao) {this.departmentDao = departmentDao;}

    @QueryMapping
    public Department department(Department department) {return departmentDao.getDepartment(department.getId()); }

    @QueryMapping
    //TODO: Fix this 'Could not resolve parameter [0] in public java.util.List<org.bigcompany.bigql.model.Department> org.bigcompany.bigql.controller.DepartmentController.getDepartments(int): No suitable resolver'
    public List<Department> getDepartments() {return departmentDao.getDepartments(); }

    @MutationMapping
    public Department createDepartment(@RequestBody @Argument String name, @Argument String orgId, @Argument String employeeId) {
        Department department = new Department();
        department.setId(UUID.randomUUID().toString());
        department.setName(name);
        department.setOrgId(orgId);
        department.setEmployee(employeeId);
        departmentDao.createDepartment(department);
        return department;
    }

}
