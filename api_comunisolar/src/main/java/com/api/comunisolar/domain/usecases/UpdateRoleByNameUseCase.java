package com.api.comunisolar.domain.usecases;

import com.api.comunisolar.data.repositories.RoleRepository;
import com.api.comunisolar.domain.entities.RoleDomain;
import com.api.comunisolar.domain.exception.RoleException;
import com.api.comunisolar.domain.mappers.RoleDomainMapper;

public class UpdateRoleByNameUseCase {
    private final RoleRepository roleRepository;
    private final GetRoleByNameUseCase getRoleByNameUseCase;

    public UpdateRoleByNameUseCase(RoleRepository roleRepository, RoleDomainMapper roleMapperDomain) {
        this.roleRepository = roleRepository;
        this.getRoleByNameUseCase = new GetRoleByNameUseCase(roleRepository, roleMapperDomain);
    }

    public RoleDomain execute(String name, String newName) {
        RoleDomain roleDomain = getRoleByNameUseCase.execute(name);
        if (roleDomain.getName() == null) {
            throw new RoleException("Role not found");
        }
        roleRepository.updateByName(name, newName);
        roleDomain.setName(newName);
        return roleDomain;
    }
}
