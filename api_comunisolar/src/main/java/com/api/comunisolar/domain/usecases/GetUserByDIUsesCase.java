package com.api.comunisolar.domain.usecases;

import com.api.comunisolar.data.repositories.UserRepository;
import com.api.comunisolar.domain.entities.UserResponseDomain;
import com.api.comunisolar.domain.exception.MyUserException;
import com.api.comunisolar.domain.mappers.UserMapperDomain;

import java.util.Optional;

public class GetUserByDIUsesCase {

    private final UserRepository userRepository;
    private final UserMapperDomain userMapperDomain;

    public GetUserByDIUsesCase(UserRepository userRepository, UserMapperDomain userMapperDomain) {
        this.userRepository = userRepository;
        this.userMapperDomain = userMapperDomain;
    }

    public UserResponseDomain execute(String identityDocument) {
        var user = userRepository.findByIdentityDocument(identityDocument);
        if (user == null) {
            throw new MyUserException("User not found");
        }
        var userDomain = userMapperDomain.fromDataToDomain(user);
        return userMapperDomain.fromUserDomainToUserDomainResponse(userDomain);
    }

}
