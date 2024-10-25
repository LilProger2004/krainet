package com.krainet.timetrack.repository;

import com.krainet.timetrack.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String employeeLogin);

    boolean existsByEmployeeEmail(String employeeEmail);

    boolean existsByUsername(String username);

    void deleteByEmployeeId(String employeeId);

    Employee findByEmployeeId(String employeeId);

    boolean existsByEmployeeId(String employeeId);
}