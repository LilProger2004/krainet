package com.krainet.timetrack.service.serviceimpl;

import com.krainet.timetrack.model.Record;
import com.krainet.timetrack.repository.RecordRepository;
import com.krainet.timetrack.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImplements implements RecordService {

    final RecordRepository recordRepository;

    @Override
    public List<Record> findAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Record findById(Long id) {
        return recordRepository.findById(id).orElseThrow();
    }


    @Override
    public void createRecord(Record record) {
        recordRepository.save(record);
    }

    @Override
    public void deleteRecord(Long recordId) {
        recordRepository.deleteById(recordId);
    }

    @Override
    public void updateRecord(Record record) {
        recordRepository.save(record);
    }

    @Override
    public boolean existByTaskId(String taskId) {
        return recordRepository.existsByTask_TaskId(taskId);
    }
}
