package edu.project.rent.controller.web;

import edu.project.rent.forms.ItemForm;
import edu.project.rent.model.Item;
import edu.project.rent.service.item.impls.CrudItemMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/item")
public class ItemWebController {

    @Autowired
    CrudItemMongoImpl service;

    @RequestMapping("/list")
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

        return "redirect:/web/item/list";
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

        return "redirect:/web/item/list";
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

        return "redirect:/web/item/list";
    }
    @RequestMapping(value = "/list/sort",method = RequestMethod.GET)
    public String sortByName (Model model){
        model.addAttribute("Items", service.getAllSorted()); //Item v ItemsTable used
        return "ItemsTable";
    }

 @RequestMapping(value = "/list/sortbydate",method = RequestMethod.GET)
    public String sortByDateMod (Model model){
        model.addAttribute("Items", service.getAllSortedByDate()); //Item v ItemsTable used
        return "ItemsTable";
    }
    @RequestMapping(value = "/list/sortbyid",method = RequestMethod.GET)
    public String sortById (Model model){
        model.addAttribute("Items", service.getAllSortedById()); //Item v ItemsTable used
        return "ItemsTable";
    }



}
