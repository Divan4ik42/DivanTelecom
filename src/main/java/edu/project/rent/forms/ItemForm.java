package edu.project.rent.forms;

public class ItemForm {
    private String id = "";
    private String name= "";
    private String description= "";
    private String modified_at = "";
    private String created_at = "";


    public ItemForm() {
    }

    public ItemForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ItemForm(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
