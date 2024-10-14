package com.api.comunisolar.config;

import com.api.comunisolar.data.repositories.RoleRepository;
import com.api.comunisolar.data.repositories.UserRepository;
import com.api.comunisolar.domain.mappers.RoleDomainMapper;
import com.api.comunisolar.domain.mappers.UserMapperDomain;
import com.api.comunisolar.domain.usecases.*;
import com.api.comunisolar.domain.utils.MyValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public CreateRoleUseCase createRoleUseCase(RoleRepository roleRepository, RoleDomainMapper roleMapperDomain, MyValidator validator) {
        return new CreateRoleUseCase(roleRepository, roleMapperDomain, validator);
    }

    @Bean
    public GetAllRolesUseCase getAllRolesUseCase(RoleRepository roleRepository, RoleDomainMapper roleMapperDomain) {
        return new GetAllRolesUseCase(roleRepository, roleMapperDomain);
    }

    @Bean
    public GetRoleByNameUseCase getRoleByNameUseCase(RoleRepository roleRepository, RoleDomainMapper roleMapperDomain) {
        return new GetRoleByNameUseCase(roleRepository, roleMapperDomain);
    }

    @Bean
    public DeleteRoleByNameUseCase deleteRoleByNameUseCase(RoleRepository roleRepository, GetRoleByNameUseCase getRoleByNameUseCase, RoleDomainMapper roleMapperDomain) {
        return new DeleteRoleByNameUseCase(roleRepository, getRoleByNameUseCase, roleMapperDomain);
    }

    @Bean
    public UpdateRoleByNameUseCase updateRoleByNameUseCase(RoleRepository roleRepository, RoleDomainMapper roleMapperDomain) {
        return new UpdateRoleByNameUseCase(roleRepository, roleMapperDomain);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository, UserMapperDomain userMapperDomain, GetRoleByNameUseCase getRoleByNameUseCase , MyValidator validator) {
        return new CreateUserUseCase(userRepository, userMapperDomain, getRoleByNameUseCase, validator);
    }

    @Bean
    public GetAllUserUseCase getAllUserUseCase(UserRepository userRepository, UserMapperDomain userMapperDomain) {
        return new GetAllUserUseCase(userRepository, userMapperDomain);
    }

    @Bean
    public GetUserByDIUsesCase getUserByDIUsesCase(UserRepository userRepository, UserMapperDomain userMapperDomain) {
        return new GetUserByDIUsesCase(userRepository, userMapperDomain);
    }


}

/*

    private final UserRepository userRepository;
    private final UserMapperDomain userMapperDomain;
    private final GetRoleByNameUseCase getRoleByNameUseCase;
    private final MyValidator myValidator;

 */