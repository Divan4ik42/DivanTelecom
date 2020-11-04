package edu.project.rent.service.item.impls;


import edu.project.rent.repository.ItemRepository;
import edu.project.rent.data.FakeData;
import edu.project.rent.model.Item;
import edu.project.rent.service.item.interfaces.ICrudItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
//@Component
public class CrudItemMongoImpl implements ICrudItem {
    @Autowired
    FakeData bata;

    @Autowired
    ItemRepository itemRepository;

    private List<Item> list = new ArrayList<>();

    @PostConstruct
    //не будет загружать фейк дату в базу при отключином постконстракта
    void init() {
        list = bata.getItems();
        list.size();
        itemRepository.saveAll(list);
    }

    @Override
    public Item create(Item item) {
        item.setId(item.getId());
        item.setCreated_at(LocalDateTime.now());
        item.setModified_at(LocalDateTime.now());
        return itemRepository.save(item);
    }

    @Override
    public Item get(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item update(Item item) {
        item.setModified_at(LocalDateTime.now());
        return itemRepository.save(item);
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        itemRepository.deleteById(id);
        return item;
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

}
