package com.api.comunisolar.data.repositories;

import com.api.comunisolar.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //get by identityDocument return user
    User findByIdentityDocument(String identityDocument);

    //delete by identityDocument return user
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.identityDocument = ?1")
    void deleteByIdentityDocument(String identityDocument);
}
