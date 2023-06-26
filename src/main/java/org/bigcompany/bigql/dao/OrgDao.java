package org.bigcompany.bigql.dao;

import org.bigcompany.bigql.model.Org;

import java.util.List;

public class OrgDao {
    private final List<Org> orgs;

    public OrgDao(List<Org> orgs) {this.orgs = orgs;}

    public Org getOrg(String id){
        return orgs.stream()
                .filter(org -> id.equals(org.getId()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}
