package com.api.comunisolar.presenter.controllers;

import com.api.comunisolar.domain.usecases.*;
import com.api.comunisolar.presenter.entities.RolePresenter;
import com.api.comunisolar.presenter.mappers.RolePresenterMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final CreateRoleUseCase createRoleUseCase;
    private final RolePresenterMapper roleMapperPresenter;
    private final GetAllRolesUseCase getAllRolesUseCase;
    private final GetRoleByNameUseCase getRoleByNameUseCase;
    private final DeleteRoleByNameUseCase deleteRoleByNameUseCase;
    private final UpdateRoleByNameUseCase updateRoleByNameUseCase;

    public RoleController(
            CreateRoleUseCase createRoleUseCase,
            RolePresenterMapper roleMapperPresenter,
            GetAllRolesUseCase getAllRolesUseCase,
            GetRoleByNameUseCase getRoleByNameUseCase,
            DeleteRoleByNameUseCase deleteRoleByNameUseCase,
            UpdateRoleByNameUseCase updateRoleByNameUseCase
    ) {
        this.createRoleUseCase = createRoleUseCase;
        this.roleMapperPresenter = roleMapperPresenter;
        this.getAllRolesUseCase = getAllRolesUseCase;
        this.getRoleByNameUseCase = getRoleByNameUseCase;
        this.deleteRoleByNameUseCase = deleteRoleByNameUseCase;
        this.updateRoleByNameUseCase = updateRoleByNameUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<RolePresenter> createRole(@RequestBody RolePresenter rolePresenter) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roleMapperPresenter.fromDomainToPresenter(createRoleUseCase.execute(roleMapperPresenter.fromPresenterToDomain(rolePresenter))));
    }

    @GetMapping("/all-roles")
    public ResponseEntity<Iterable<RolePresenter>> getAllRoles() {
        //Map the response from the use case to the presenter
        List<RolePresenter> roles = getAllRolesUseCase.execute().stream().map(roleMapperPresenter::fromDomainToPresenter).collect(Collectors.toList());
        return ResponseEntity.
                status(HttpStatus.FOUND)
                .body(roles);
    }

    @GetMapping("/role-by-name/{name}")
    public ResponseEntity<RolePresenter> getRoleByName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(roleMapperPresenter.fromDomainToPresenter(getRoleByNameUseCase.execute(name)));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<RolePresenter> deleteRoleByName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roleMapperPresenter.fromDomainToPresenter(deleteRoleByNameUseCase.execute(name)));
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<RolePresenter> updateRoleByName(@PathVariable String name, @RequestBody RolePresenter rolePresenter) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roleMapperPresenter.fromDomainToPresenter(updateRoleByNameUseCase.execute(name, rolePresenter.getName())));
    }

}
