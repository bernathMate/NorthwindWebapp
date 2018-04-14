package com.codecool.web.model;

import java.util.Objects;

public class Task1 extends AbstractModel {

    private String product;

    public Task1(String company,  String product) {
        super(company);
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Task1 task1 = (Task1) o;
        return Objects.equals(product, task1.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), product);
    }
}
