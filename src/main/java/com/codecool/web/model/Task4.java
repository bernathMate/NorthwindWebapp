package com.codecool.web.model;

import java.util.Objects;

public class Task4 extends AbstractModel {

    private String ids;

    public Task4(String company, String ids) {
        super(company);
        this.ids = ids;
    }

    public String getIds() {
        return ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Task4 task4 = (Task4) o;
        return Objects.equals(ids, task4.ids);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), ids);
    }
}
