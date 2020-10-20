package edu.project.rent.controller.rest;

import edu.project.rent.data.FakeData;
import edu.project.rent.model.Item;
import edu.project.rent.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/item")
public class ItemWebController {

    @Autowired
//    FakeData data;
            ItemServiceImpl service;

    @RequestMapping("/all")
        //rest возвращает JASON
    String getAll(Model model) {
        model.addAttribute("Items", service.getAll());
        return "ItemsTable";

    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {

        service.delete(id);

//        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
//                .findFirst().orElse(null);
//        service.getAll().remove(item);

        return "redirect:/web/item/all";
    }


}
