package edu.project.rent.controller.rest;

import edu.project.rent.model.Item;
import edu.project.rent.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {
@Autowired
//    FakeData data;
    ItemServiceImpl service;

    @RequestMapping("/get/all") //rest возвращает JASON
    List<Item> getAll (){
        return service.getAll();
    }
    @RequestMapping("/delete/{id}")

    Item deleteById(@PathVariable("id") String id) {
//
//        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
//                .findFirst().orElse(null);
//        service.getAll().remove(item);

        return service.delete(id);
    }

    @RequestMapping("/get/{id}")

    Item getById(@PathVariable("id") String id) {
//
//        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
//                .findFirst().orElse(null);
//        service.getAll().remove(item);

        return service.get(id);

    }
    @PostMapping("/create")
    Item create(@RequestBody Item item){
        return service.create(item);
    }

    @PutMapping("/update")
    Item update(@RequestBody Item item){
        return service.update(item);
    }



}
