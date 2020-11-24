package edu.project.rent.service.subscriber.impls;


import edu.project.rent.data.FakeData;
import edu.project.rent.model.Item;
import edu.project.rent.model.Subscriber;
import edu.project.rent.repository.SubscriberRepository;
import edu.project.rent.service.subscriber.interfaces.ICrudSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudSubscriberMongoImpl implements ICrudSubscriber {
    @Autowired
    FakeData bata;

    @Autowired
    SubscriberRepository repository;

    private List<Subscriber> list = new ArrayList<>();

//    @PostConstruct
    //не будет загружать фейк дату в базу при отключином постконстракта
    void init() {
        list = bata.getSubscriber();
        list.size();
        repository.saveAll(list);
    }

    @Override
    public Subscriber create(Subscriber subscriber) {
        subscriber.setId(subscriber.getId());
        subscriber.setCreated_at(LocalDateTime.now());
        subscriber.setModified_at(LocalDateTime.now());
        return repository.save(subscriber);
    }

    @Override
    public Subscriber get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        subscriber.setModified_at(LocalDateTime.now());
        return repository.save(subscriber);
    }

    @Override
    public Subscriber delete(String id) {
        Subscriber subscriber = this.get(id);
        repository.deleteById(id);
        return subscriber;

    }

    @Override
    public List<Subscriber> getAll() {
        return repository.findAll();
    }


    public List<Subscriber> getAllSorted() {
        List<Subscriber> list = repository.findAll();
        List<Subscriber> sorted = list.stream()
                .sorted(Comparator.comparing(Subscriber::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        return sorted;
    }
    public List<Subscriber> getAllSortedByDate() {
        List<Subscriber> list = repository.findAll();
        List<Subscriber> sortedByDateMod = list.stream()
                .sorted(Comparator.comparing(Subscriber::getModified_at))
                .collect(Collectors.toList());
        return sortedByDateMod;
    }
    public List<Subscriber> getAllSortedById() {
        List<Subscriber> list = repository.findAll();
        List<Subscriber> sortById = list.stream()
                .sorted(Comparator.comparing(Subscriber::getId))
                .collect(Collectors.toList());
        return sortById;
    }

    public List<Subscriber> getByName(String name) {
        if (name.equals(""))return this.getAll();
        return this.getAll().stream().filter(subscriber -> subscriber.getName().contains(name))
                .collect(Collectors.toList());
    }
}
