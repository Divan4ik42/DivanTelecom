package edu.project.rent.forms;

import java.time.LocalDateTime;

public class SubscriberForm {
    private String id = "";
    private String name = "";
    private String sureName = "";
    private String tel = "";
    private String address = "";
    private String idNumber = "";
    private String description = "";
    private String created_at = "";

    public SubscriberForm() {
    }

    public SubscriberForm(String name, String sureName, String tel, String address, String idNumber, String description) {
        this.name = name;
        this.sureName = sureName;
        this.tel = tel;
        this.address = address;
        this.idNumber = idNumber;
        this.description = description;
    }

    public SubscriberForm(String id, String name, String sureName, String tel, String address, String idNumber, String description) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
        this.tel = tel;
        this.address = address;
        this.idNumber = idNumber;
        this.description = description;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "SubscriberForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
