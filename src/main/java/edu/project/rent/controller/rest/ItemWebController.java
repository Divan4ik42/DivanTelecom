package edu.project.rent.controller.rest;

import edu.project.rent.data.FakeData;
import edu.project.rent.forms.ItemForm;
import edu.project.rent.model.Item;
import edu.project.rent.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        ItemForm itemForm = new ItemForm();
        model.addAttribute("form" , itemForm);

        return "ItemAddForm";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ItemForm form,Model model){
        Item item = new Item();
//        item.getName() = form.setName(form.getName());
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.create(item);

        return "redirect:/web/item/all";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model,@PathVariable("id") String id ){
        Item item = service.get(id);
        ItemForm itemForm = new ItemForm();
        itemForm.setId(item.getId());
        itemForm.setName(item.getName());
        itemForm.setDescription(item.getDescription());
//        itemForm.setCreated_at(item.getCreated_at().toString());
//        itemForm.setModified_at(item.getModified_at().toString());

        model.addAttribute("form" , itemForm);

        return "UpdateItem";

    }   @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model,@PathVariable("id") String id,@ModelAttribute("form") ItemForm form ){
        Item item = service.get(id);
     item.setName(form.getName());
     item.setDescription(form.getDescription());


//        itemForm.setCreated_at(item.getCreated_at().toString());
//        itemForm.setModified_at(item.getModified_at().toString());


        service.update(item);

        return "redirect:/web/item/all";
    }



}
