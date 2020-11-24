package edu.project.rent.repository;

import edu.project.rent.model.Item;
import edu.project.rent.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends MongoRepository<Record, String> {

}