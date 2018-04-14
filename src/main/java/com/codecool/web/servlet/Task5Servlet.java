package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.dao.database.DatabaseTaskDao;
import com.codecool.web.model.Task5;
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

@WebServlet("/task5")
public class Task5Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String minUnitPrice = req.getParameter("minUnitPrice");
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDao taskDao = new DatabaseTaskDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);

            if (minUnitPrice == null || minUnitPrice.equals("0") || minUnitPrice.equals("")) {
                List<Task5> task5Result = taskService.getTask5results();
                req.setAttribute("task5", task5Result);
            } else {
                List<Task5> task5FilterResult = taskService.getProductsByMinUnitPrice(Double.parseDouble(minUnitPrice));
                req.setAttribute("task5", task5FilterResult);
            }

            req.getRequestDispatcher("task5.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("error", e.getMessage());
        } catch (ServiceException e) {
            req.setAttribute("error", e.getMessage());
        }
    }
}
