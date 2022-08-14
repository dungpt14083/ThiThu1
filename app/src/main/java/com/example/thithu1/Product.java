package com.example.thithu1;

public class Product {
    private int pid;
    private String name;
    private float price;
    private String created_at;
    private String updated_at;

    public Product(int pid, String name, float price, String created_at, String updated_at) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
