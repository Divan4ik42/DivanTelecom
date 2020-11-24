package edu.project.rent.controller.rest;

import edu.project.rent.model.Subscriber;
import edu.project.rent.service.subscriber.impls.CrudSubscriberFakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriber")
public class SubscriberRestController {

    @Autowired
    CrudSubscriberFakeServiceImpl service;

    @RequestMapping("/list")
    List<Subscriber> getSubscriber() {
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Subscriber deleteById(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Subscriber getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @PostMapping("/create")
    Subscriber create(@RequestBody Subscriber subscriber) {

        return service.create(subscriber);
    }

    @PutMapping("/update")
    Subscriber update(@RequestBody Subscriber subscriber) {
        return service.update(subscriber);
    }

}
