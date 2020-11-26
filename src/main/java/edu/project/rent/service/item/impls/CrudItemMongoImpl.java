package edu.project.rent.service.item.impls;


import edu.project.rent.repository.ItemRepository;
import edu.project.rent.data.FakeData;
import edu.project.rent.model.Item;
import edu.project.rent.service.item.interfaces.ICrudItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudItemMongoImpl implements ICrudItem {
    @Autowired
    FakeData bata;

    @Autowired
    ItemRepository repository;

    private List<Item> list = new ArrayList<>();

//  @PostConstruct
    //не будет загружать фейк дату в базу при отключином постконстракта
    void init() {
        list = bata.getItems();
        list.size();
        repository.saveAll(list);
    }


    @Override
    public Item create(Item item) {
        item.setId(item.getId());
        item.setCreated_at(LocalDateTime.now());
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Item update(Item item) {
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        repository.deleteById(id);
        return item;
    }

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }

    public List<Item> getAllSorted() {
        List<Item> list = repository.findAll();
        List<Item> sorted = list.stream()
                .sorted(Comparator.comparing(Item::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        return sorted;
    }
    public List<Item> getAllSortedByDate() {
        List<Item> list = repository.findAll();
        List<Item> sortedByDateMod = list.stream()
                .sorted(Comparator.comparing(Item::getModified_at))
                .collect(Collectors.toList());
        return sortedByDateMod;
    }
    public List<Item> getAllSortedById() {
        List<Item> list = repository.findAll();
        List<Item> sortById = list.stream()
                .sorted(Comparator.comparing(Item::getId))
                .collect(Collectors.toList());
        return sortById;
    }

    public List<Item> getByName(String name) {
        if (name.equals(""))return this.getAll();
        return this.getAll().stream().filter(item -> item.getName().contains(name))
                .collect(Collectors.toList());
    }
}
