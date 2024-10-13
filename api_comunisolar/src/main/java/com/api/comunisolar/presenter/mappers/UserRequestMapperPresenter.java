package com.api.comunisolar.presenter.mappers;

import com.api.comunisolar.domain.entities.UserRequestDomain;
import com.api.comunisolar.presenter.entities.UserRequestPresenter;

public class UserRequestMapperPresenter {
    //From UserRequestPresenter to UserRequestDomain
    public  UserRequestDomain fromPresenterToDomain(UserRequestPresenter userRequestPresenter){
        return new UserRequestDomain(
                userRequestPresenter.getFullName(),
                userRequestPresenter.getEmail(),
                userRequestPresenter.getPasswordHash(),
                userRequestPresenter.getIdentityDocument()
        );
    }

    //From UserRequestDomain to UserRequestPresenter
    public UserRequestPresenter fromDomainToPresenter(UserRequestDomain userRequestDomain){
        return new UserRequestPresenter(
                userRequestDomain.getFullName(),
                userRequestDomain.getEmail(),
                userRequestDomain.getPasswordHash(),
                userRequestDomain.getIdentityDocument()
        );
    }
}
