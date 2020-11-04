package edu.project.rent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
@Document
public class Subscriber {
    @Id
    private String id;
    private String name;
    private String sureName;
    private String tel;
    private String address;
    private String idNumber;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

    public Subscriber() {
    }

    public Subscriber(String name, String sureName, String tel, String address, String idNumber, String description) {
        this.name = name;
        this.sureName = sureName;
        this.tel = tel;
        this.address = address;
        this.idNumber = idNumber;
        this.description = description;
    }

    public Subscriber(String id, String name, String sureName, String tel, String address, String idNumber, String description, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
        this.tel = tel;
        this.address = address;
        this.idNumber = idNumber;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
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

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }
}
