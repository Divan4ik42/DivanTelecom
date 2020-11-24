package edu.project.rent.forms;

import edu.project.rent.model.Build;
import edu.project.rent.model.Subscriber;

import java.time.LocalDateTime;

public class RecordForm {
    private String id = "";
    private String name = "";
    private String description = "";
    private String start = "";
    private String finish = "";
    private String subscriber = "";
    private String build = "";
    private String created_at = "";
    private String modified_at = "";

    public RecordForm() {
    }

    public RecordForm(String name, String description, String start, String finish, String subscriber, String build) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.subscriber = subscriber;
        this.build = build;
    }

    public RecordForm(String id, String name, String description, String start, String finish, String subscriber, String build) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.subscriber = subscriber;
        this.build = build;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public String toString() {
        return "RecordForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", subscriber='" + subscriber + '\'' +
                ", build='" + build + '\'' +
                ", created_at='" + created_at + '\'' +
                ", modified_at='" + modified_at + '\'' +
                '}';
    }
}
