package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.dao.database.DatabaseTaskDao;
import com.codecool.web.model.Task2;
import com.codecool.web.service.TaskService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleTaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task2")
public class Task2Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numberOfProducts = req.getParameter("numberOfProducts");
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDao taskDao = new DatabaseTaskDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);

            if (numberOfProducts == null || numberOfProducts.equals("0") || numberOfProducts.equals("")) {
                List<Task2> task2Result = taskService.getTask2results();
                req.setAttribute("task2", task2Result);
            } else {
                List<Task2> task2FilterResult = taskService.getCompanyByNumberOfProducts(Integer.parseInt(numberOfProducts));
                req.setAttribute("task2", task2FilterResult);
            }

            req.getRequestDispatcher("task2.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("error", e.getMessage());
        } catch (ServiceException e) {
            req.setAttribute("error", e.getMessage());
        }
    }
}
