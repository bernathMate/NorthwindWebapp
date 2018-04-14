package com.codecool.web.service;

import com.codecool.web.model.*;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface TaskService {

    List<Task1> getTask1results() throws SQLException, ServiceException;

    List<Task1> getProductsByCompanyName(String companyName) throws SQLException, ServiceException;

    List<Task2> getTask2results() throws SQLException, ServiceException;

    List<Task2> getCompanyByNumberOfProducts(int numberOfProducts) throws SQLException, ServiceException;

    List<Task3> getTask3results() throws SQLException, ServiceException;

    List<Task3> getCompanyByName(String companyName) throws SQLException, ServiceException;

    List<Task4> getTask4results() throws SQLException, ServiceException;

    List<Task4> getOrderIdsByCompanyName(String companyName) throws SQLException, ServiceException;

    List<Task5> getTask5results() throws SQLException, ServiceException;

    List<Task5> getProductsByMinUnitPrice(double minUnitPrice) throws SQLException, ServiceException;
}
