package com.api.comunisolar.config;

import com.api.comunisolar.domain.mappers.RoleDomainMapper;
import com.api.comunisolar.domain.mappers.UserMapperDomain;
import com.api.comunisolar.presenter.mappers.RolePresenterMapper;
import com.api.comunisolar.presenter.mappers.UserRequestMapperPresenter;
import com.api.comunisolar.presenter.mappers.UserResponseMapperPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class MappersConfig {
    @Bean
    public RoleDomainMapper roleMapperDomain(){
        return new RoleDomainMapper();
    }

    @Bean
    public UserRequestMapperPresenter userRequestMapperPresenter(){
        return new UserRequestMapperPresenter();
    }

    @Bean
    public UserMapperDomain userMapperDomain(RoleDomainMapper roleMapperDomain){
        return new UserMapperDomain(roleMapperDomain);
    }

    @Bean
    public UserResponseMapperPresenter userResponseMapperPresenter(RolePresenterMapper rolePresenterMapper){
        return new UserResponseMapperPresenter(rolePresenterMapper);
    }
}
