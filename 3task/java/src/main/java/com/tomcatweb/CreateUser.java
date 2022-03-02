package com.tomcatweb;

import JDBC.JDBCRepository;
import JDBC.JDBCRepositoryImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "createUser", value = "/createUser")
public class CreateUser extends HttpServlet {
    JDBCRepository jdbcRepository = new JDBCRepositoryImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().write("<html>" +
                "<head></head>" +
                "<body>" +
                "<form action='createUser' method='get'>" +
                "<input type='text' name='name'/>" +
                "<input type='text' name='age'/>" +
                "<input type='submit' name='submit'/>" +
                "</form>" +
                "</body>" +
                "</html>");
        if (request.getParameter("name") != null && request.getParameter("age") != null) {
            try {
                jdbcRepository.addUser(request.getParameter("name"), Integer.parseInt(request.getParameter("age")));
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
    }
}

