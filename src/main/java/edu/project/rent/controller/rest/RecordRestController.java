package edu.project.rent.controller.rest;

import edu.project.rent.model.Item;
import edu.project.rent.model.Record;
import edu.project.rent.service.item.impls.CrudItemMongoImpl;
import edu.project.rent.service.record.impls.ICrudRecordServiceMongoImpl;
import edu.project.rent.service.subscriber.impls.CrudSubscriberMongoImpl;
import edu.project.rent.service.subscriber.interfaces.ICrudSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/record")

public class RecordRestController {

    @Autowired
    ICrudRecordServiceMongoImpl service;

    @Autowired
    CrudSubscriberMongoImpl subService;

    @RequestMapping("/list")
        //rest возвращает JASON

    List<Record> getAll() {
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Record deleteById(@PathVariable("id") String id) {
//        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
//                .findFirst().orElse(null);
//        service.getAll().remove(item);
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Record getById(@PathVariable("id") String id) {
//        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
//                .findFirst().orElse(null);
//        service.getAll().remove(item);
        return service.get(id);
    }

    @PostMapping("/create")
    Record create(@RequestBody Record record) {
        return service.create(record);
    }

    @PutMapping("/update")
    Record update(@RequestBody Record record) {
        return service.update(record);
    }


}
