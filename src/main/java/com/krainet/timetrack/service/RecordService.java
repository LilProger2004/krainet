package com.krainet.timetrack.service;

import com.krainet.timetrack.model.Record;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RecordService {

    List<Record> findAllRecords();
    Record findById(Long id);
    void createRecord(Record record);
    void deleteRecord(Long recordId);
    void updateRecord(Record record);
    boolean existByTaskId(String taskId);

}
