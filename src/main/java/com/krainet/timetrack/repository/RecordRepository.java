package com.krainet.timetrack.repository;

import com.krainet.timetrack.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}