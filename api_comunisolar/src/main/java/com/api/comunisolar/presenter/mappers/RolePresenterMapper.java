package com.api.comunisolar.presenter.mappers;

import com.api.comunisolar.domain.entities.RoleDomain;
import com.api.comunisolar.presenter.entities.RolePresenter;
import org.springframework.stereotype.Component;

@Component
public class RolePresenterMapper {
    //from presenter to domain
    public RoleDomain fromPresenterToDomain(RolePresenter rolePresenter) {
        return new RoleDomain(null,rolePresenter.getName());
    }

    //from domain to presenter
    public RolePresenter fromDomainToPresenter(RoleDomain roleDomain) {
        return new RolePresenter(roleDomain.getId(), roleDomain.getName());
    }
}
