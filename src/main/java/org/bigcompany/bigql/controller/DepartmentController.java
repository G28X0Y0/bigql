package org.bigcompany.bigql.controller;

import org.bigcompany.bigql.dao.DepartmentDao;
import org.bigcompany.bigql.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private final DepartmentDao departmentDao;

    public DepartmentController(DepartmentDao departmentDao) {this.departmentDao = departmentDao;}

    @QueryMapping
    public Department department(Department department) {return departmentDao.getDepartment(department.getId()); }

    @MutationMapping
    public Department createDepartment(String name, String orgId) {
        Department department = new Department();
        department.setName(name);
        department.setOrgId(orgId);
        departmentDao.createDepartment(department);
        return department;
    }

}
