package com.codecool.web.model;

import java.util.Objects;

public class Task2 extends AbstractModel {

    private int products;

    public Task2(String company, int products) {
        super(company);
        this.products = products;
    }

    public int getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Task2 task2 = (Task2) o;
        return products == task2.products;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), products);
    }
}
