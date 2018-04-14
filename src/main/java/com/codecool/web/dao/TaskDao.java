package com.codecool.web.dao;

import com.codecool.web.model.*;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {

    List<Task1> task1Result() throws SQLException;

    List<Task1> getProductsByCompanyName(String companyName) throws SQLException;

    List<Task2> task2Result() throws SQLException;

    List<Task2> getCompanyByNumberOfProducts(int numberOfProducts) throws SQLException;

    List<Task3> task3Result() throws SQLException;

    List<Task3> getCompanyByName(String companyName) throws SQLException;

    List<Task4> task4Result() throws SQLException;

    List<Task4> getOrderIdsByCompanyName(String companyName) throws SQLException;

    List<Task5> task5Result() throws SQLException;

    List<Task5> getProductsByMinUnitPrice(double minUnitPrice) throws SQLException;
}
