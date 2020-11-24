package edu.project.rent.service.record.interfaces;

import edu.project.rent.model.Item;
import edu.project.rent.model.Record;

import java.util.List;

public interface ICrudRecord {

    Record create(Record record);
    Record get(String id);
    Record update(Record record);
    Record delete(String id);

    List<Record> getAll();

}
