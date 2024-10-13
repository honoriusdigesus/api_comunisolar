package com.api.comunisolar.domain.usecases;

import com.api.comunisolar.data.repositories.RoleRepository;
import com.api.comunisolar.domain.entities.RoleDomain;
import com.api.comunisolar.domain.exception.RoleException;
import com.api.comunisolar.domain.mappers.RoleDomainMapper;

public class GetRoleByNameUseCase {
    private final RoleRepository roleRepository;
    private final RoleDomainMapper roleMapperDomain;

    public GetRoleByNameUseCase(RoleRepository roleRepository, RoleDomainMapper roleMapperDomain) {
        this.roleRepository = roleRepository;
        this.roleMapperDomain = roleMapperDomain;
    }

    public RoleDomain execute(String name) {
        RoleDomain roleDomain = roleMapperDomain.fromDataToDomain(roleRepository.getByName(name));
        if (roleDomain.getName() == null) {
            throw new RoleException("Role not found");
        }
        return roleDomain;
    }
}
