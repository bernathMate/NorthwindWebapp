package com.codecool.web.model;

import java.util.Objects;

public abstract class AbstractModel {

    private String company;

    public AbstractModel(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractModel that = (AbstractModel) o;
        return Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {

        return Objects.hash(company);
    }
}
