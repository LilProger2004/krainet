package com.krainet.timetrack.repository;

import com.krainet.timetrack.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 *
 * Репозиторий  содержащий CRUD операции над моделью Record
 *
 */
@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    @Override
    void deleteById(Long id);

    List<Record> findByEmployee_EmployeeId(String employeeId);

    boolean existsByTask_TaskId(String taskId);
}