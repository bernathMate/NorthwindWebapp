package com.codecool.web.model;

import java.util.Objects;

public class Task5 extends AbstractModel {

    private String product;
    private double price;

    public Task5(String company, String product, double price) {
        super(company);
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Task5 task5 = (Task5) o;
        return Double.compare(task5.price, price) == 0 &&
                Objects.equals(product, task5.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), product, price);
    }
}
