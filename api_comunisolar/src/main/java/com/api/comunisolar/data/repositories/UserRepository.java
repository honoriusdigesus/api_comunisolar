package com.api.comunisolar.data.repositories;

import com.api.comunisolar.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
