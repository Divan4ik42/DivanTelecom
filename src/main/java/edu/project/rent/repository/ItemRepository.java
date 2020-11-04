package edu.project.rent.repository;

import edu.project.rent.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface ItemRepository extends MongoRepository<Item, String> {

}