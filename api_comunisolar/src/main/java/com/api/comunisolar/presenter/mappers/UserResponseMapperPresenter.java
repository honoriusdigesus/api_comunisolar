package com.api.comunisolar.presenter.mappers;

import com.api.comunisolar.domain.entities.UserDomain;
import com.api.comunisolar.domain.entities.UserRequestDomain;
import com.api.comunisolar.domain.entities.UserResponseDomain;
import com.api.comunisolar.presenter.entities.UserResponsePresenter;

public class UserResponseMapperPresenter {
    //From ROleDomain to RolePresenter
    private final RolePresenterMapper rolePresenterMapper;

    public UserResponseMapperPresenter(RolePresenterMapper rolePresenterMapper) {
        this.rolePresenterMapper = rolePresenterMapper;
    }

    //From UserResponsePresenter to UserResponseDomain
    public UserResponseDomain fromPresenterToDomain(UserResponsePresenter userResponsePresenter){
        return new UserResponseDomain(
                userResponsePresenter.getFullName(),
                userResponsePresenter.getEmail(),
                userResponsePresenter.getEnabled(),
                userResponsePresenter.getIdentityDocument(),
                rolePresenterMapper.fromPresenterToDomain(userResponsePresenter.getRole())
        );
    }

    //From UserResponseDomain to UserResponsePresenter
    public UserResponsePresenter fromDomainToPresenter(UserResponseDomain userResponseDomain){
        return new UserResponsePresenter(
                userResponseDomain.getFullName(),
                userResponseDomain.getEmail(),
                userResponseDomain.getEnabled(),
                userResponseDomain.getIdentityDocument(),
                rolePresenterMapper.fromDomainToPresenter(userResponseDomain.getRole())
        );
    }

    public UserResponsePresenter fromUserDomainToUserDomainResponse(UserResponseDomain userResponseDomain) {
        return new UserResponsePresenter(
                userResponseDomain.getFullName(),
                userResponseDomain.getEmail(),
                userResponseDomain.getEnabled(),
                userResponseDomain.getIdentityDocument(),
                rolePresenterMapper.fromDomainToPresenter(userResponseDomain.getRole())
        );
    }
}
