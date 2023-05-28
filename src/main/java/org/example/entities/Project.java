package org.example.entities;

public class Project {
    private String id;
    private int price;

    public Project(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
