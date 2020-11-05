package edu.project.rent.controller.web;

import edu.project.rent.service.subscriber.impls.CrudSubscriberFakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/subscriber")
public class SubscriberWebController {
   @Autowired
//    FakeData data;
           CrudSubscriberFakeServiceImpl service;

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
    @RequestMapping("/edit/{id}")
    String editById(@PathVariable("id") String id){
        return "hello";
    }
}

