package com.api.comunisolar.presenter.controllers;

import com.api.comunisolar.domain.usecases.CreateUserUseCase;
import com.api.comunisolar.domain.usecases.GetAllUserUseCase;
import com.api.comunisolar.presenter.entities.UserRequestPresenter;
import com.api.comunisolar.presenter.entities.UserResponsePresenter;
import com.api.comunisolar.presenter.mappers.UserRequestMapperPresenter;
import com.api.comunisolar.presenter.mappers.UserResponseMapperPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserRequestMapperPresenter userRequestMapperPresenter;
    private final UserResponseMapperPresenter userResponseMapperPresenter;
    private final GetAllUserUseCase getAllUserUseCase;

    public UserController(
            CreateUserUseCase createUserUseCase,
            UserRequestMapperPresenter userRequestMapperPresenter,
            UserResponseMapperPresenter userResponseMapperPresenter,
            GetAllUserUseCase getAllUserUseCase
            ) {
        this.createUserUseCase = createUserUseCase;
        this.userRequestMapperPresenter = userRequestMapperPresenter;
        this.userResponseMapperPresenter = userResponseMapperPresenter;
        this.getAllUserUseCase = getAllUserUseCase;
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

    @GetMapping
    @RequestMapping("/all-users")
    public ResponseEntity<List<UserResponsePresenter>> getAllUsers() {
        var listUsers = getAllUserUseCase.execute();
        var listUsersPresenter = listUsers.stream()
                .map(userResponseMapperPresenter::fromUserDomainToUserDomainResponse)
                .toList();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listUsersPresenter);
    }

}
