package com.example.thithu1;

public class ListProduct {
    private Product[] products;

    public ListProduct(Product[] products) {
        this.products = products;
    }

    public ListProduct() {
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
