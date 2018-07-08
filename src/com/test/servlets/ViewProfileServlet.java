package com.test.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getProfileDetails")
public class ViewProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get the username from the session
        System.out.println ( "User name in profile servlet: " + req.getSession ().getAttribute ("username"));

        //forward to control to profile jsp
        req.getRequestDispatcher ("html/login.jsp").forward (req, resp);
    }
}
