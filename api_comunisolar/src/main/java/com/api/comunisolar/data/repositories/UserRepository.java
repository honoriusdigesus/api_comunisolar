package com.api.comunisolar.data.repositories;

import com.api.comunisolar.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //get by identityDocument return user
    User findByIdentityDocument(String identityDocument);
}
