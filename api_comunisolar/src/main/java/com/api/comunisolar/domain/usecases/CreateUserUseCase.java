package com.api.comunisolar.domain.usecases;

import com.api.comunisolar.data.repositories.UserRepository;
import com.api.comunisolar.domain.entities.RoleDomain;
import com.api.comunisolar.domain.entities.UserDomain;
import com.api.comunisolar.domain.entities.UserRequestDomain;
import com.api.comunisolar.domain.entities.UserResponseDomain;
import com.api.comunisolar.domain.exception.MyUserException;
import com.api.comunisolar.domain.mappers.UserMapperDomain;
import com.api.comunisolar.domain.utils.MyValidator;

public class CreateUserUseCase {
    private final UserRepository userRepository;
    private final UserMapperDomain userMapperDomain;
    private final GetRoleByNameUseCase getRoleByNameUseCase;
    private final MyValidator myValidator;

    public CreateUserUseCase(UserRepository userRepository, UserMapperDomain userMapperDomain, GetRoleByNameUseCase getRoleByNameUseCase, MyValidator myValidator) {
        this.userRepository = userRepository;
        this.userMapperDomain = userMapperDomain;
        this.getRoleByNameUseCase = getRoleByNameUseCase;
        this.myValidator = myValidator;
    }

    public UserResponseDomain execute(UserRequestDomain userRequestDomain) {
        if (myValidator.NullOrEmpty(userRequestDomain.getFullName()) ||
                myValidator.NullOrEmpty(userRequestDomain.getEmail()) ||
                myValidator.NullOrEmpty(userRequestDomain.getPasswordHash()) ||
                myValidator.NullOrEmpty(userRequestDomain.getIdentityDocument())) {
            throw new MyUserException("All fields must be completed, please verify your information");
        }

        RoleDomain roleDefault;

        roleDefault = getRoleByNameUseCase.execute("Field");
        //Imprimir en consolar roleDefault
        System.out.println(roleDefault + " Desde el caso de uso line34");

        if (roleDefault == null) {
            throw new MyUserException("Role not found");
        }


        var userDomain = new UserDomain();
        userDomain.setFullName(userRequestDomain.getFullName());
        userDomain.setEmail(userRequestDomain.getEmail());
        userDomain.setPasswordHash(userRequestDomain.getPasswordHash());
        userDomain.setEnabled(false);
        userDomain.setIdentityDocument(userRequestDomain.getIdentityDocument());
        userDomain.getCreatedAt();
        userDomain.getActivatedAt();
        userDomain.setRole(roleDefault);
        userRepository.save(userMapperDomain.fromDomainToData(userDomain));



        var userResponseDomain = new UserResponseDomain();
        userResponseDomain.setFullName(userDomain.getFullName());
        userResponseDomain.setEmail(userDomain.getEmail());
        userResponseDomain.setEnabled(userDomain.getEnabled());
        userResponseDomain.setIdentityDocument(userDomain.getIdentityDocument());
        userResponseDomain.setRole(userDomain.getRole());
        return userResponseDomain;
    }
}