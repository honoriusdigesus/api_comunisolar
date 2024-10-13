package com.api.comunisolar.domain.mappers;

import com.api.comunisolar.data.entities.Role;
import com.api.comunisolar.domain.entities.RoleDomain;
import org.springframework.stereotype.Component;

@Component
public class RoleDomainMapper {
    //from domain to data
    public Role fromDomainToData(RoleDomain roleDomain) {
        return new Role(roleDomain.getId(), roleDomain.getName());
    }

    //from data to domain
    public RoleDomain fromDataToDomain(Role role) {
        return new RoleDomain(role.getId(),role.getName());
    }
}
