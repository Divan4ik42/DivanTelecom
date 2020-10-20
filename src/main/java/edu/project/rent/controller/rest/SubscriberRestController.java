package edu.project.rent.controller.rest;

import edu.project.rent.data.FakeData;
import edu.project.rent.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("/api/subscriber")
@RestController
public class SubscriberRestController {
  @Autowired
    FakeData data;
    @RequestMapping("/sublist")
    List<Subscriber> getSubscriber(){

        return data.getSubscriber();
    }
}
