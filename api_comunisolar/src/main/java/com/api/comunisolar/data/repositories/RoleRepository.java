package com.api.comunisolar.data.repositories;

import com.api.comunisolar.data.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getByName(String name);

    // Delete by name
    @Modifying
    @Transactional
    @Query("DELETE FROM Role r WHERE r.name = ?1")
    void deleteByName(String name);

    //Update role by name
    @Modifying
    @Transactional
    @Query("UPDATE Role r SET r.name = ?2 WHERE r.name = ?1")
    void updateByName(String name, String newName);
}
