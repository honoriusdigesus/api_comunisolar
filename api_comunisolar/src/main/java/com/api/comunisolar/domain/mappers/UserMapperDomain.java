package com.api.comunisolar.domain.mappers;

import com.api.comunisolar.data.entities.User;
import com.api.comunisolar.domain.entities.UserDomain;
import com.api.comunisolar.domain.entities.UserResponseDomain;

public class UserMapperDomain {
    //Role mapper from domain to data
    private final RoleDomainMapper roleMapperDomain;

    public UserMapperDomain(RoleDomainMapper roleMapperDomain) {
        this.roleMapperDomain = roleMapperDomain;
    }


    //from User to UserDomain
    public UserDomain fromDataToDomain(User user){
        return new UserDomain(
                user.getFullName(),
                user.getEmail(),
                user.getPasswordHash(),
                user.getEnabled(),
                user.getIdentityDocument(),
                user.getCreatedAt(),
                user.getActivatedAt(),
                roleMapperDomain.fromDataToDomain(user.getRole()));
    }

    //from UserDomain to User
    public User fromDomainToData(UserDomain userDomain){
        return new User(
                null,
                userDomain.getFullName(),
                userDomain.getEmail(),
                userDomain.getPasswordHash(),
                userDomain.getEnabled(),
                userDomain.getIdentityDocument(),
                userDomain.getCreatedAt(),
                userDomain.getActivatedAt(),
                roleMapperDomain.fromDomainToData(userDomain.getRole()));
    }

    public UserResponseDomain fromUserDomainToUserDomainResponse(UserDomain userDomain) {
        return new UserResponseDomain(
                userDomain.getFullName(),
                userDomain.getEmail(),
                userDomain.getEnabled(),
                userDomain.getIdentityDocument(),
                userDomain.getRole()
        );
    }


}

