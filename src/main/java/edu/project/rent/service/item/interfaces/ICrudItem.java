package edu.project.rent.service.item.interfaces;

import edu.project.rent.model.Item;

import java.util.List;

public interface ICrudItem {

    Item create(Item item);
    Item get(String id);
    Item update(Item item);
    Item delete(String id);

    List<Item> getAll();

}
