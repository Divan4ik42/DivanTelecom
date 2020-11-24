package edu.project.rent.service.subscriber.impls;

import edu.project.rent.data.FakeData;
import edu.project.rent.model.Item;
import edu.project.rent.model.Subscriber;
import edu.project.rent.service.subscriber.interfaces.ICrudSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CrudSubscriberFakeServiceImpl implements ICrudSubscriber {

    @Autowired
    FakeData fakeData;

    @Override
    public Subscriber create(Subscriber subscriber) {
        UUID id = UUID.randomUUID();
        subscriber.setId(id.toString());
        subscriber.setCreated_at(LocalDateTime.now());
        subscriber.setModified_at(LocalDateTime.now());
        fakeData.getSubscriber().add(subscriber);
        return subscriber;
    }

    @Override
    public Subscriber get(String id) {
        return this.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        String id = subscriber.getId();
        Subscriber subscriberToUpdate = this.getAll().stream().filter(el -> el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(subscriberToUpdate);
        subscriber.setModified_at(LocalDateTime.now());
        this.getAll().set(index, subscriber);

        return subscriber;
    }

    @Override
    public Subscriber delete(String id) {
        Subscriber subscriber = this.getAll().stream().filter(element->element.getId().equals(id))
                .findFirst().orElse(null);
        this.getAll().remove(subscriber);
        return subscriber;
    }

    @Override
    public List<Subscriber> getAll() {
        return fakeData.getSubscriber();
    }
}
