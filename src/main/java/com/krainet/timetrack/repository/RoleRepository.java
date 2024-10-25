package com.krainet.timetrack.repository;

import com.krainet.timetrack.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 *
 * Репозиторий  содержащий CRUD операции над моделью Role
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Override
    Optional<Role> findById(Long aLong);
}