package edu.project.rent.service.subscriber.impls;

import edu.project.rent.data.FakeData;
import edu.project.rent.model.Subscriber;
import edu.project.rent.service.subscriber.interfaces.ICrudSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CrudSubscriberServiceImpl implements ICrudSubscriber {

    @Autowired
    FakeData fakeData;

    @Override
    public Subscriber create(Subscriber subscriber) {
        return null;
    }

    @Override
    public Subscriber get(String id) {
        return null;
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        return null;
    }

    @Override
    public Subscriber delete(String id) {
        return null;
    }

    @Override
    public List<Subscriber> getAll() {
        return fakeData.getSubscriber();
    }
}
