package org.bigcompany.bigql.graphql;

import org.bigcompany.bigql.dao.DepartmentDao;
import org.bigcompany.bigql.dao.OrgDao;
import org.bigcompany.bigql.model.Department;
import org.bigcompany.bigql.model.Org;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public DepartmentDao departmentDao(){
        List<Department> departments = new ArrayList<>();
        for(int departmentId = 0; departmentId < 10; ++departmentId){
            for(int orgId = 0; orgId < 10; ++orgId){
                Department department = new Department();
                department.setId("Department" + orgId + departmentId);
                department.setName("Department " + orgId + ":" + departmentId);
                departments.add(department);
            }
        }
        return new DepartmentDao(departments);
    }

    @Bean
    public OrgDao orgDao(){
        List<Org> orgs = new ArrayList<>();
        for (int orgId = 0; orgId < 10; ++orgId) {
            Org org = new Org();
            org.setId("Org" + orgId);
            org.setName("Org " + orgId);
            orgs.add(org);
        }
        return new OrgDao(orgs);
    }
}
