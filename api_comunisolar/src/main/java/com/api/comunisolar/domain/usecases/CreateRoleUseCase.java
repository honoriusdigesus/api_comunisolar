package com.api.comunisolar.domain.usecases;


import com.api.comunisolar.data.repositories.RoleRepository;
import com.api.comunisolar.domain.entities.RoleDomain;
import com.api.comunisolar.domain.exception.RoleException;
import com.api.comunisolar.domain.mappers.RoleDomainMapper;
import com.api.comunisolar.domain.utils.MyValidator;

public class CreateRoleUseCase {
    private final RoleRepository roleRepository;
    private final RoleDomainMapper roleMapperDomain;
    private final MyValidator validator;


    public CreateRoleUseCase(RoleRepository roleRepository, RoleDomainMapper roleMapperDomain, MyValidator validator) {
        this.roleRepository = roleRepository;
        this.roleMapperDomain = roleMapperDomain;
        this.validator = validator;
    }

    public RoleDomain execute(RoleDomain roleDomain) {
        if (validator.NullOrEmpty(roleDomain.getName())) {
            throw new RoleException("Name is required");
        }
        return roleMapperDomain.fromDataToDomain(roleRepository.save(roleMapperDomain.fromDomainToData(roleDomain)));
    }
}
