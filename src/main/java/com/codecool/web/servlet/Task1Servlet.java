package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.dao.database.DatabaseTaskDao;
import com.codecool.web.model.Task1;
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

@WebServlet("/task1")
public class Task1Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyName = req.getParameter("companyName");
        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDao taskDao = new DatabaseTaskDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);

            if (companyName == null || companyName.equals("")) {
                List<Task1> task1Result = taskService.getTask1results();
                req.setAttribute("task1", task1Result);
            } else {
                List<Task1> task1FilterResult = taskService.getProductsByCompanyName(companyName);
                req.setAttribute("task1", task1FilterResult);
            }

            req.getRequestDispatcher("task1.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("error", e.getMessage());
        } catch (ServiceException e) {
            req.setAttribute("error", e.getMessage());
        }
    }
}
