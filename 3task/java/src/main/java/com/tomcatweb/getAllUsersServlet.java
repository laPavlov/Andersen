package com.tomcatweb;

import JDBC.JDBCRepository;
import JDBC.JDBCRepositoryImpl;
import Models.User;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "getAllUsersServlet", value = "/getAllUsers")
public class getAllUsersServlet extends HttpServlet {

    JDBCRepository jdbcRepository = new JDBCRepositoryImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            List<User> users = jdbcRepository.getAllUsers();
            for (User user : users) {
                int id = user.getId();
                String name = user.getName();
                Integer age = user.getAge();

                out.println("<html><body>");
                out.println("<h1>" + id + " " + name + " " + age +"</h1>");
            }
            out.println("</body></html>");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void destroy () {
    }
}