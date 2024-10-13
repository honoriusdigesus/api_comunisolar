package com.api.comunisolar.domain.usecases;

import com.api.comunisolar.data.repositories.RoleRepository;
import com.api.comunisolar.domain.entities.RoleDomain;
import com.api.comunisolar.domain.exception.RoleException;
import com.api.comunisolar.domain.mappers.RoleDomainMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class DeleteRoleByNameUseCase {

    private final RoleRepository roleRepository;
    private final GetRoleByNameUseCase getRoleByNameUseCase;
    private final RoleDomainMapper roleMapperDomain;


    public DeleteRoleByNameUseCase(RoleRepository roleRepository, GetRoleByNameUseCase getRoleByNameUseCase, RoleDomainMapper roleMapperDomain) {
        this.roleRepository = roleRepository;
        this.getRoleByNameUseCase = new GetRoleByNameUseCase(roleRepository, roleMapperDomain);
        this.roleMapperDomain = roleMapperDomain;
    }

    public RoleDomain execute(String name) {
        RoleDomain roleDomain = getRoleByNameUseCase.execute(name);
        if (roleDomain.getName() == null) {
            throw new RoleException("Role no found");
        }
        roleRepository.deleteByName(name);
        return roleDomain;
    }
}
