package com.api.comunisolar.presenter.controllers;

import com.api.comunisolar.domain.usecases.CreateUserUseCase;
import com.api.comunisolar.presenter.entities.UserRequestPresenter;
import com.api.comunisolar.presenter.entities.UserResponsePresenter;
import com.api.comunisolar.presenter.mappers.UserRequestMapperPresenter;
import com.api.comunisolar.presenter.mappers.UserResponseMapperPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserRequestMapperPresenter userRequestMapperPresenter;
    private final UserResponseMapperPresenter userResponseMapperPresenter;

    public UserController(CreateUserUseCase createUserUseCase, UserRequestMapperPresenter userRequestMapperPresenter, UserResponseMapperPresenter userResponseMapperPresenter) {
        this.createUserUseCase = createUserUseCase;
        this.userRequestMapperPresenter = userRequestMapperPresenter;
        this.userResponseMapperPresenter = userResponseMapperPresenter;
    }

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<UserResponsePresenter> createUser(@RequestBody UserRequestPresenter userRequestPresenter) {
        var userResponse = createUserUseCase.execute(userRequestMapperPresenter.fromPresenterToDomain(userRequestPresenter));
        var userResponsePresenter = userResponseMapperPresenter.fromDomainToPresenter(userResponse);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponsePresenter);
    }
}
