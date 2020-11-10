package edu.project.rent.controller.web;

import edu.project.rent.forms.ItemForm;
import edu.project.rent.forms.SubscriberForm;
import edu.project.rent.model.Item;
import edu.project.rent.model.Subscriber;
import edu.project.rent.service.subscriber.impls.CrudSubscriberFakeServiceImpl;
import edu.project.rent.service.subscriber.impls.CrudSubscriberMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/subscriber")
public class SubscriberWebController {
   @Autowired
//    FakeData data;
//           CrudSubscriberFakeServiceImpl service;
           CrudSubscriberMongoImpl service;

    @RequestMapping("/list")
    String getList(Model model) {
        model.addAttribute("subscribers", service.getAll());
        return "SubscribersTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/subscriber/list";
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        SubscriberForm subscriberForm = new SubscriberForm();
        model.addAttribute("form" , subscriberForm);

        return "SubscriberAddForm";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") SubscriberForm subscriberForm, Model model){
        Subscriber subscriber = new Subscriber();
        subscriber.setName(subscriberForm.getName());
        subscriber.setSureName(subscriberForm.getSureName());
        subscriber.setTel(subscriberForm.getTel());
        subscriber.setAddress(subscriberForm.getAddress());
        subscriber.setIdNumber(subscriberForm.getIdNumber());
        subscriber.setDescription(subscriberForm.getDescription());
        service.create(subscriber);

        return "redirect:/web/subscriber/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model,@PathVariable("id") String id ){
        Subscriber subscriber = service.get(id);
        SubscriberForm subscriberForm = new SubscriberForm();
        subscriberForm.setId(subscriber.getId());
        subscriberForm.setName(subscriber.getName());
        subscriberForm.setSureName(subscriber.getSureName());
        subscriberForm.setTel(subscriber.getTel());
        subscriberForm.setAddress(subscriber.getAddress());
        subscriberForm.setIdNumber(subscriber.getIdNumber());
        subscriberForm.setDescription(subscriber.getDescription());
//        itemForm.setCreated_at(item.getCreated_at().toString());
//        itemForm.setModified_at(item.getModified_at().toString());

        model.addAttribute("form" , subscriberForm);

        return "UpdateSubscriber";

    }   @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model,@PathVariable("id") String id,@ModelAttribute("form") SubscriberForm form ){
        Subscriber subscriber = service.get(id);
        subscriber.setName(form.getName());
        subscriber.setSureName(form.getSureName());
        subscriber.setTel(form.getTel());
        subscriber.setAddress(form.getAddress());
        subscriber.setIdNumber(form.getIdNumber());
        subscriber.setDescription(form.getDescription());


//        itemForm.setCreated_at(item.getCreated_at().toString());
//        itemForm.setModified_at(item.getModified_at().toString());


        service.update(subscriber);

        return "redirect:/web/subscriber/list";
    }
}

