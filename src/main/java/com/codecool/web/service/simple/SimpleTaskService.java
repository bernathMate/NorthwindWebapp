package com.codecool.web.service.simple;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.*;
import com.codecool.web.service.TaskService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleTaskService implements TaskService {

    private final TaskDao taskDao;

    public SimpleTaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<Task1> getTask1results() throws ServiceException {
        try {
            List<Task1> result = taskDao.task1Result();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("invalid SQL query!");
        }
    }

    @Override
    public List<Task1> getProductsByCompanyName(String companyName) throws ServiceException {
        try {
            List<Task1> result = taskDao.getProductsByCompanyName(companyName);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("invalid SQL query!");
        }
    }

    @Override
    public List<Task2> getTask2results() throws ServiceException {
        try {
            List<Task2> result = taskDao.task2Result();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("invalid SQL query!");
        }
    }

    @Override
    public List<Task2> getCompanyByNumberOfProducts(int numberOfProducts) throws SQLException, ServiceException {
        try {
            List<Task2> result = taskDao.getCompanyByNumberOfProducts(numberOfProducts);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("invalid SQL query!");
        }
    }

    @Override
    public List<Task3> getTask3results() throws ServiceException {
        try {
            List<Task3> result = taskDao.task3Result();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("invalid SQL query!");
        }
    }

    @Override
    public List<Task3> getCompanyByName(String companyName) throws SQLException, ServiceException {
        try {
            List<Task3> result = taskDao.getCompanyByName(companyName);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("invalid SQL query!");
        }
    }

    @Override
    public List<Task4> getTask4results() throws ServiceException {
        try {
            List<Task4> result = taskDao.task4Result();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL query!");
        }
    }

    @Override
    public List<Task4> getOrderIdsByCompanyName(String companyName) throws SQLException, ServiceException {
        try {
            List<Task4> result = taskDao.getOrderIdsByCompanyName(companyName);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL query!");
        }
    }

    @Override
    public List<Task5> getTask5results() throws ServiceException {
        try {
            List<Task5> result = taskDao.task5Result();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("invalid SQL query!");
        }
    }

    @Override
    public List<Task5> getProductsByMinUnitPrice(double minUnitPrice) throws SQLException, ServiceException {
        try {
            List<Task5> result = taskDao.getProductsByMinUnitPrice(minUnitPrice);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("invalid SQL query!");
        }
    }
}
