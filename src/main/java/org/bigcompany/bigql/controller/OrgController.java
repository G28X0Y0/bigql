package org.bigcompany.bigql.controller;

import org.bigcompany.bigql.dao.OrgDao;
import org.bigcompany.bigql.model.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgController {

    @Autowired
    private final OrgDao orgDao;

    public OrgController(OrgDao orgDao) {this.orgDao = orgDao;}

    @QueryMapping
    public Org org(Org org) {return orgDao.getOrg(org.getId()); }
}
