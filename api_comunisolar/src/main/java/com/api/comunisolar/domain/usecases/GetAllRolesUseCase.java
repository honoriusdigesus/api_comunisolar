package com.api.comunisolar.domain.usecases;

import com.api.comunisolar.data.repositories.RoleRepository;
import com.api.comunisolar.domain.entities.RoleDomain;
import com.api.comunisolar.domain.mappers.RoleDomainMapper;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllRolesUseCase {
    private final RoleRepository roleRepository;
    private final RoleDomainMapper roleMapperDomain;

    public GetAllRolesUseCase(RoleRepository roleRepository, RoleDomainMapper roleMapperDomain) {
        this.roleRepository = roleRepository;
        this.roleMapperDomain = roleMapperDomain;
    }

    public List<RoleDomain> execute() {
        return roleRepository.findAll().stream().map(roleMapperDomain::fromDataToDomain).collect(Collectors.toList());
    }
}
