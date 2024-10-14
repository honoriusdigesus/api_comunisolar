package com.api.comunisolar.domain.usecases;

import com.api.comunisolar.data.repositories.UserRepository;
import com.api.comunisolar.domain.entities.UserResponseDomain;
import com.api.comunisolar.domain.exception.MyUserException;
import com.api.comunisolar.domain.mappers.UserMapperDomain;

public class DeleteUserByDIUseCase {
    private final UserRepository userRepository;
    private GetUserByDIUsesCase getUserByDIUsesCase;

    public DeleteUserByDIUseCase(UserRepository userRepository, GetUserByDIUsesCase getUserByDIUsesCase) {
        this.userRepository = userRepository;
        this.getUserByDIUsesCase = getUserByDIUsesCase;
    }

    public UserResponseDomain execute(String identityDocument) {
        var user = getUserByDIUsesCase.execute(identityDocument);
        if (user.getIdentityDocument() == null || user.getIdentityDocument().isEmpty()) {
            throw new MyUserException("User not found");
        }
        userRepository.deleteByIdentityDocument(user.getIdentityDocument());
        return user;
    }
}
