package com.codecool.web.dao.database;

import java.sql.Connection;

public abstract class AbstractDao {

    final Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }
}
