package edu.project.rent.service.subscriber.interfaces;

import edu.project.rent.model.Subscriber;

import java.util.List;

public interface ICrudSubscriber {

    Subscriber create(Subscriber subscriber);
    Subscriber get(String id);
    Subscriber update(Subscriber subscriber);
    Subscriber delete(String id);

    List<Subscriber> getAll();

}
