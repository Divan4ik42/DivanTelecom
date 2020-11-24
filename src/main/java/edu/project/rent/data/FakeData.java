package edu.project.rent.data;

import edu.project.rent.model.Build;
import edu.project.rent.model.Item;
import edu.project.rent.model.Record;
import edu.project.rent.model.Subscriber;
import edu.project.rent.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class FakeData {

    @Autowired
    RecordRepository recordRepository;

    private List<Build> builds = Stream.of(
            new Build("1", "build1", "center", LocalDateTime.now(), LocalDateTime.now()),
            new Build("2", "build2", "center", LocalDateTime.now(), LocalDateTime.now()),
            new Build("3", "build3", "center", LocalDateTime.now(), LocalDateTime.now()),
            new Build("4", "build4", "center", LocalDateTime.now(), LocalDateTime.now()),
            new Build("5", "build5", "center", LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());


    private List<Subscriber> subscriber = Stream.of(

            new Subscriber("1", "Alex", "-", "Sofiychuk", "+380997160000", "Golovna str.", "3532s535743474940", "all good", LocalDateTime.now(), LocalDateTime.now()),
            new Subscriber("2", "Kate", "-", "Drapak", "+380997162222", "Prospect str.", "37374746362246842", "all good", LocalDateTime.now(), LocalDateTime.now()),
            new Subscriber("3", "Sca", "-", "Sofiychuk", "+380997163333", "Golovna str.", "45135438156233746", "best of ALL", LocalDateTime.now(), LocalDateTime.now()),
            new Subscriber("4", "Irene", "-", "Bogachuk", "+380997161111", "Golovna str.", "31535353135453649", "all good", LocalDateTime.now(), LocalDateTime.now()),
            new Subscriber("5", "Irene", "-", "Bogachukx", "+380997161111x", "Golovna str.", "31535353135453649", "all good", LocalDateTime.now(), LocalDateTime.now())

    ).collect(Collectors.toList());


    private List<Record> records = Stream.of(
            new Record("1", "record1", "desk1", LocalDateTime.now(), LocalDateTime.now(), subscriber.get(0), builds.get(0), LocalDateTime.now(), LocalDateTime.now()),
            new Record("2", "record2", "desk1", LocalDateTime.now(), LocalDateTime.now(), subscriber.get(1), builds.get(1), LocalDateTime.now(), LocalDateTime.now()),
            new Record("3", "record3", "desk1", LocalDateTime.now(), LocalDateTime.now(), subscriber.get(2), builds.get(2), LocalDateTime.now(), LocalDateTime.now()),
            new Record("4", "record4", "desk1", LocalDateTime.now(), LocalDateTime.now(), subscriber.get(3), builds.get(3), LocalDateTime.now(), LocalDateTime.now()),
            new Record("5", "record5", "desk1", LocalDateTime.now(), LocalDateTime.now(), subscriber.get(4), builds.get(4), LocalDateTime.now(), LocalDateTime.now())


    ).collect(Collectors.toList());


    private List<Item> items = Stream.of(
            new Item("1", "Coca-cola", "drink", LocalDateTime.now(), LocalDateTime.now()),
            new Item("2", "Pepsi", "drink", LocalDateTime.now(), LocalDateTime.now()),
            new Item("3", "Jagermadsister", " Alco-drink", LocalDateTime.now(), LocalDateTime.now()),
            new Item("4", "Jagermaiscdcdter", " Alco-drink", LocalDateTime.now(), LocalDateTime.now()),
            new Item("5", "Jagermaisxscter", " Alco-drink", LocalDateTime.now(), LocalDateTime.now())

    ).collect(Collectors.toList());



//    @PostConstruct
    void init(){
        recordRepository.saveAll(records);
    }



    public List<Item> getItems() {
        return items;
    }

    public List<Subscriber> getSubscriber() {
        return subscriber;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setSubscriber(List<Subscriber> subscriber) {
        this.subscriber = subscriber;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}

