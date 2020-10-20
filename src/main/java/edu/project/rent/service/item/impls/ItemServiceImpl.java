package edu.project.rent.service.item.impls;

import edu.project.rent.data.FakeData;
import edu.project.rent.model.Item;
import edu.project.rent.service.item.interfaces.ICrudItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ICrudItem {

    @Autowired
    FakeData data;

    @Override

    public Item create(Item item) {
        return null;
    }

    @Override
    public Item get(String id) {
        return this.getAll().stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        this.getAll().remove(item);
        return item;
    }

    @Override
    public List<Item> getAll() {
        return data.getItems();
    }
}
