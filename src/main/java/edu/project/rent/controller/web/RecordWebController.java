package edu.project.rent.controller.web;

import edu.project.rent.forms.RecordForm;
import edu.project.rent.forms.SearchForm;
import edu.project.rent.forms.SubscriberForm;
import edu.project.rent.model.Build;
import edu.project.rent.model.Gender;
import edu.project.rent.model.Record;
import edu.project.rent.model.Subscriber;
import edu.project.rent.service.record.impls.ICrudRecordServiceMongoImpl;
import edu.project.rent.service.subscriber.impls.CrudSubscriberMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/record")
public class RecordWebController {
    @Autowired
//    FakeData data;
//           CrudSubscriberFakeServiceImpl service;
            CrudSubscriberMongoImpl subService;
    @Autowired
    ICrudRecordServiceMongoImpl recordService;

    Build standart = new Build("1","build1","FUCKING SHIT",LocalDateTime.now(),LocalDateTime.now());

    @RequestMapping("/list")
    String getList(Model model) {
        model.addAttribute("records", recordService.getAll());
//        SearchForm search = new SearchForm();
//        model.addAttribute("search" ,search);
        return "RecordTable";
    }
//    @PostMapping("/list")
//        //rest возвращает JASON
//    String getAll(@ModelAttribute("search") SearchForm form , Model model) {
//        String name = form.getName();
//        model.addAttribute("Items", service.getByName(name));
//        SearchForm search = new SearchForm();
//        model.addAttribute("search" ,search);
//        return "SubscribersTable";
//
//    }
//
//
//    @RequestMapping("/delete/{id}")
//    String deleteById(@PathVariable("id") String id) {
//        service.delete(id);
//        return "redirect:/web/subscriber/list";
//    }
//
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        List<String> subscribers = subService.getAll()
                .stream().map(subscriber -> subscriber.getName())
                .collect(Collectors.toList());
        RecordForm recordForm = new RecordForm();
        model.addAttribute("form", recordForm);
        model.addAttribute("subscribers", subscribers);

        return "RecordAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") RecordForm recordForm, Model model) {
        Record record = new Record();
        record. setName(recordForm.getName());
        record. setDescription(recordForm.getDescription());

        String startAsString = recordForm.getStart();
        LocalDate startAsDate = LocalDate. parse (startAsString);
        LocalDateTime startAsDateTime = startAsDate. atTime ( 0 ,0, 0) ;
        record. setStart(startAsDateTime);

        record.setFinish(LocalDate.parse(recordForm.getFinish()).atTime(0,0,0));

        String clientName = recordForm.getSubscriber();
        Subscriber subscriber = subService.getByName(clientName).get(0);
        record.setSubscriber(subscriber);
        record. setBuild(standart);
        record. setSubscriber(record.getSubscriber());
        record. setBuild (record. getBuild());
        recordService. create (record);

        return "redirect:/web/record/list";
    }

//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//    public String update(Model model, @PathVariable("id") String id) {
//        Subscriber subscriber = service.get(id);
//        List<String> genders = Stream.of(Gender.values())
//                .map(Gender::name)
//                .collect(Collectors.toList());
//        SubscriberForm subscriberForm = new SubscriberForm();
//        subscriberForm.setId(subscriber.getId());
//        subscriberForm.setName(subscriber.getName());
//        subscriberForm.setGender(subscriber.getGender());
//        subscriberForm.setSureName(subscriber.getSureName());
//        subscriberForm.setTel(subscriber.getTel());
//        subscriberForm.setAddress(subscriber.getAddress());
//        subscriberForm.setIdNumber(subscriber.getIdNumber());
//        subscriberForm.setDescription(subscriber.getDescription());
////        itemForm.setCreated_at(item.getCreated_at().toString());
////        itemForm.setModified_at(item.getModified_at().toString());
//
//        model.addAttribute("form", subscriberForm);
//        model.addAttribute("genders", genders);
//
//        return "UpdateSubscriber";
//
//    }
//
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    public String update(Model model, @PathVariable("id") String id, @ModelAttribute("form") SubscriberForm form) {
//        Subscriber subscriber = service.get(id);
//        subscriber.setName(form.getName());
//        subscriber.setGender(form.getGender());
//        subscriber.setSureName(form.getSureName());
//        subscriber.setTel(form.getTel());
//        subscriber.setAddress(form.getAddress());
//        subscriber.setIdNumber(form.getIdNumber());
//        subscriber.setDescription(form.getDescription());
//
//
////        itemForm.setCreated_at(item.getCreated_at().toString());
////        itemForm.setModified_at(item.getModified_at().toString());
//
//
//        service.update(subscriber);
//
//        return "redirect:/web/subscriber/list";
//    }
//
//
//    @RequestMapping(value = "/list/sort", method = RequestMethod.GET)
//    public String sortByName(Model model) {
//        model.addAttribute("subscribers", service.getAllSorted()); //Item v ItemsTable used
//        SearchForm search = new SearchForm();
//        model.addAttribute("search" ,search);
//        return "SubscribersTable";
//    }
//
//    @RequestMapping(value = "/list/sortbydate", method = RequestMethod.GET)
//    public String sortByDateMod(Model model) {
//        model.addAttribute("subscribers", service.getAllSortedByDate()); //Item v ItemsTable used
//        SearchForm search = new SearchForm();
//        model.addAttribute("search" ,search);
//        return "SubscribersTable";
//    }
//
//    @RequestMapping(value = "/list/sortbyid", method = RequestMethod.GET)
//    public String sortById(Model model) {
//        model.addAttribute("subscribers", service.getAllSortedById()); //Item v ItemsTable used
//        SearchForm search = new SearchForm();
//        model.addAttribute("search" ,search);
//        return "SubscribersTable";
//    }
}

