package edu.project.rent.service.subscriber.impls;


import edu.project.rent.data.FakeData;
import edu.project.rent.model.Subscriber;
import edu.project.rent.repository.SubscriberRepository;
import edu.project.rent.service.subscriber.interfaces.ICrudSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
//@Component
public class CrudSubscriberMongoImpl implements ICrudSubscriber {
    @Autowired
    FakeData bata;

    @Autowired
    SubscriberRepository subscriberRepository;

    private List<Subscriber> list = new ArrayList<>();

    @PostConstruct
    //не будет загружать фейк дату в базу при отключином постконстракта
    void init() {
        list = bata.getSubscribers();
        list.size();
        subscriberRepository.saveAll(list);
    }

    @Override
    public Subscriber create(Subscriber subscriber) {
        subscriber.setId(subscriber.getId());
        subscriber.setCreated_at(LocalDateTime.now());
        subscriber.setModified_at(LocalDateTime.now());
        return subscriberRepository.save(subscriber);
    }

    @Override
    public Subscriber get(String id) {
        return subscriberRepository.findById(id).orElse(null);
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        subscriber.setModified_at(LocalDateTime.now());
        return subscriberRepository.save(subscriber);
    }

    @Override
    public Subscriber delete(String id) {
        Subscriber subscriber = this.get(id);
        subscriberRepository.deleteById(id);
        return subscriber;
    }

    @Override
    public List<Subscriber> getAll() {
        return subscriberRepository.findAll();
    }

}
