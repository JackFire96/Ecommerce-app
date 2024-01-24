package edu.esiea.ecommerceapp.model;

import java.util.List;

public class Cart {

    private double total;
    private List<Product> productList;

    public Cart(List<Product> productList) {
        this.productList = productList;
        this.total = 0;
    }

    public double getTotal() {
        return this.total;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
