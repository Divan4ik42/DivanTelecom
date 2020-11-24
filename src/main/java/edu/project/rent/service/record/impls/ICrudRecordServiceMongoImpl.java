package edu.project.rent.service.record.impls;

import edu.project.rent.model.Build;
import edu.project.rent.model.Item;
import edu.project.rent.model.Record;
import edu.project.rent.model.Subscriber;
import edu.project.rent.repository.RecordRepository;
import edu.project.rent.service.record.interfaces.ICrudRecord;
import edu.project.rent.service.subscriber.impls.CrudSubscriberMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ICrudRecordServiceMongoImpl implements ICrudRecord {
    @Autowired
    RecordRepository repository;

    @Autowired
    CrudSubscriberMongoImpl subService;

    @Override
    public Record create(Record record) {
        record.setId(record.getId());
        record.setSubscriber(record.getSubscriber());
        record.setBuild(record.getBuild());
        record.setCreated_at(LocalDateTime.now());
        record.setModified_at(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public Record get(String id) {
        return null;
    }

    @Override
    public Record update(Record record) {
        return null;
    }

    @Override
    public Record delete(String id) {
        return null;
    }

    @Override
    public List<Record> getAll() {
        return repository.findAll();
    }
}
