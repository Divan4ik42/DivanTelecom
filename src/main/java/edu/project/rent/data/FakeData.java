package edu.project.rent.data;

import edu.project.rent.model.Item;
import edu.project.rent.model.Subscriber;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class FakeData {
    List<Subscriber> subscriber = Stream.of(

            new Subscriber ("1","Alex","Sofiychuk","+380997160000","Golovna str.","3532s535743474940","all good", LocalDateTime.now(),LocalDateTime.now()),
            new Subscriber ("2","Kate","Drapak","+380997162222","Prospect str.","37374746362246842","all good", LocalDateTime.now(),LocalDateTime.now()),
            new Subscriber ("3","Sca","Sofiychuk","+380997163333","Golovna str.","45135438156233746","best of ALL", LocalDateTime.now(),LocalDateTime.now()),
            new Subscriber ("4","Irene","Bogachuk","+380997161111","Golovna str.","31535353135453649","all good", LocalDateTime.now(),LocalDateTime.now())

    ).collect(Collectors.toList());

    List<Item> items = Stream.of(new Item("1","Coca-cola","drink", LocalDateTime.now(), LocalDateTime.now()),
            new Item("2","Pepsi","drink",LocalDateTime.now(),LocalDateTime.now()),
            new Item("3","Jagermaister"," Alco-drink",LocalDateTime.now(),LocalDateTime.now())

    ).collect(Collectors.toList());

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Subscriber> getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(List<Subscriber> subscriber) {
        this.subscriber = subscriber;
    }


}

