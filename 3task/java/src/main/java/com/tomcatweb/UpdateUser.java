package com.tomcatweb;

import JDBC.JDBCRepository;
import JDBC.JDBCRepositoryImpl;
import Models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UpdateUser", value = "/updateUsers")
public class UpdateUser extends HttpServlet {

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
                out.println("<h1>" + id + ") " + name + " " + age +"</h1>");
            }
            out.println("<form action='updateUsers' method='get'>" +
                    "Id: " +
                    "<input type='number' name='id'/>" +
                    "Name: " +
                    "<input type='text' name='name'/>" +
                    "Age: " +
                    "<input type='text' name='age'/>" +
                    "<input type='submit' name='Update'/>" +
                    "</form>");
            out.println("</body></html>");
            if(request.getParameter("id") !=null && request.getParameter("name") != null && request.getParameter("age") != null){
                jdbcRepository.updateUser(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), Integer.parseInt(request.getParameter("age")));
                response.sendRedirect("/updateUsers");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void destroy () {
    }
}
