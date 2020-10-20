package edu.project.rent.controller.rest;

import edu.project.rent.data.FakeData;
import edu.project.rent.model.Item;
import edu.project.rent.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/subscriber")
public class SubscriberWebController {
   @Autowired
    FakeData data;

    @RequestMapping("/sublist")
    String getList(Model model) {
        model.addAttribute("subscribers", data.getSubscriber());
        return "SubscribersTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {

        Subscriber subscriber = data.getSubscriber().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        data.getSubscriber().remove(subscriber);
        return "redirect:/web/subscriber/sublist";

    }
    @RequestMapping("/edit/{id}")
    String editById(@PathVariable("id") String id){
        return "hello";
    }
}
