package com.codecool.web.dao.database;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTaskDao extends AbstractDao implements TaskDao {

    public DatabaseTaskDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task1> task1Result() throws SQLException {
        List<Task1> records = new ArrayList<>();
        String sql = "SELECT products.ProductName AS product, suppliers.CompanyName AS company " +
                "FROM products, suppliers " +
                "WHERE products.SupplierID = suppliers.SupplierID " +
                "ORDER BY product ASC, company ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                records.add(fetchTask1(resultSet));
            }
        }
        return records;
    }

    @Override
    public List<Task1> getProductsByCompanyName(String companyName) throws SQLException {
        List<Task1> records = new ArrayList<>();
        String sql = "SELECT products.ProductName AS product, suppliers.CompanyName AS company " +
                "FROM products, suppliers " +
                "WHERE products.SupplierID = suppliers.SupplierID AND suppliers.CompanyName=? " +
                "ORDER BY product ASC, company ASC;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    records.add(fetchTask1(resultSet));
                }
            }
        }
        return records;
    }

    @Override
    public List<Task2> task2Result() throws SQLException {
        List<Task2> records = new ArrayList<>();
        String sql = "SELECT suppliers.companyname AS Company, COUNT(products.supplierid) AS NumberOfProducts " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "GROUP BY companyname " +
                "ORDER BY NumberOfProducts DESC, Company ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                records.add(fetchTask2(resultSet));
            }
        }
        return records;
    }

    @Override
    public List<Task2> getCompanyByNumberOfProducts(int numberOfProducts) throws SQLException {
        List<Task2> records = new ArrayList<>();
        String sql = "SELECT suppliers.companyname AS Company, COUNT(products.supplierid) AS NumberOfProducts " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "GROUP BY companyname " +
                "HAVING COUNT(products.supplierid)=? " +
                "ORDER BY NumberOfProducts DESC, Company ASC;";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, numberOfProducts);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    records.add(fetchTask2(resultSet));
                }
            }
        }
        return records;
    }

    @Override
    public List<Task3> task3Result() throws SQLException {
        List<Task3> records = new ArrayList<>();
        String sql = "SELECT suppliers.companyname AS Company " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "GROUP BY companyname " +
                "HAVING COUNT(products.supplierid) = 5 " +
                "ORDER BY Company ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                records.add(fetchTask3(resultSet));
            }
        }
        return records;
    }

    @Override
    public List<Task3> getCompanyByName(String companyName) throws SQLException {
        List<Task3> records = new ArrayList<>();
        String sql = "SELECT suppliers.companyname AS Company " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "GROUP BY companyname " +
                "HAVING COUNT(products.supplierid)=5 AND suppliers.companyname=? " +
                "ORDER BY Company ASC;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    records.add(fetchTask3(resultSet));
                }
            }
        }
        return records;
    }

    @Override
    public List<Task4> task4Result() throws SQLException {
        List<Task4> records = new ArrayList<>();
        String sql = "SELECT customers.companyname AS CompanyName, ARRAY_TO_STRING(ARRAY_AGG(orders.orderid), ',') AS Orders " +
                "FROM orders " +
                "RIGHT JOIN customers ON orders.customerid = customers.customerid " +
                "GROUP BY CompanyName " +
                "ORDER BY CompanyName;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                records.add(fetchTask4(resultSet));
            }
        }
        return records;
    }

    @Override
    public List<Task4> getOrderIdsByCompanyName(String companyName) throws SQLException {
        List<Task4> records = new ArrayList<>();
        String sql = "SELECT customers.companyname AS CompanyName, ARRAY_TO_STRING(ARRAY_AGG(orders.orderid), ',') AS Orders " +
                "FROM orders " +
                "RIGHT JOIN customers ON orders.customerid = customers.customerid " +
                "GROUP BY CompanyName " +
                "HAVING customers.companyname=? " +
                "ORDER BY CompanyName;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    records.add(fetchTask4(resultSet));
                }
            }
        }
        return records;
    }

    @Override
    public List<Task5> task5Result() throws SQLException {
        List<Task5> records = new ArrayList<>();
        String sql = "SELECT suppliers.companyname, products.productname, products.unitprice " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "WHERE products.unitprice = (SELECT MAX(products.unitprice) FROM products WHERE products.supplierid = suppliers.supplierid) " +
                "ORDER BY products.unitprice DESC, suppliers.companyname ASC, products.productname ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                records.add(fetchTask5(resultSet));
            }
        }
        return records;
    }

    @Override
    public List<Task5> getProductsByMinUnitPrice(double minUnitPrice) throws SQLException {
        List<Task5> records = new ArrayList<>();
        String sql = "SELECT suppliers.companyname, products.productname, products.unitprice " +
                "FROM suppliers " +
                "JOIN products ON suppliers.supplierid = products.supplierid " +
                "WHERE products.unitprice = (SELECT MAX(products.unitprice) FROM products WHERE products.supplierid = suppliers.supplierid) " +
                "AND products.unitprice >=? " +
                "ORDER BY products.unitprice DESC, suppliers.companyname ASC, products.productname ASC;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, minUnitPrice);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    records.add(fetchTask5(resultSet));
                }
            }
        }
        return records;
    }

    private Task1 fetchTask1(ResultSet resultSet) throws SQLException {
        String product = resultSet.getString("product");
        String company = resultSet.getString("company");
        return new Task1(company, product);
    }

    private Task2 fetchTask2(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        int products = resultSet.getInt("numberofproducts");
        return new Task2(company, products);
    }

    private Task3 fetchTask3(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        return new Task3(company);
    }

    private Task4 fetchTask4(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("companyname");
        String ids = resultSet.getString("orders");
        return new Task4(company, ids);
    }

    private Task5 fetchTask5(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("companyname");
        String product = resultSet.getString("productname");
        double price = resultSet.getDouble("unitprice");
        return new Task5(company, product, price);
    }
}
