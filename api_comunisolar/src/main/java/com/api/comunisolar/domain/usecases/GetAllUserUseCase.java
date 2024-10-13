package com.api.comunisolar.domain.usecases;

import com.api.comunisolar.data.repositories.UserRepository;
import com.api.comunisolar.domain.entities.UserResponseDomain;
import com.api.comunisolar.domain.mappers.UserMapperDomain;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllUserUseCase {
    private final UserRepository userRepository;
    private final UserMapperDomain userMapperDomain;

    public GetAllUserUseCase(UserRepository userRepository, UserMapperDomain userMapperDomain) {
        this.userRepository = userRepository;
        this.userMapperDomain = userMapperDomain;
    }

    public List<UserResponseDomain> execute() {
        var listUsers = userRepository.findAll().stream()
                .map(userMapperDomain::fromDataToDomain)
                .collect(Collectors.toList());
        //Mappear a lista de usuários para a lista de usuários de respuesta
        return listUsers.stream()
                .map(userMapperDomain::fromUserDomainToUserDomainResponse)
                .collect(Collectors.toList());
    }
}
