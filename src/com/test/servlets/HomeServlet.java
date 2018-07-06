package com.test.servlets;

import com.test.dao.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class HomeServlet extends HttpServlet {

	public Connection connection = null;
	//lifecycle method  - init, service, destroy
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println ("in doGET method");

		//forward to control to de index.html
		req.getRequestDispatcher("/html/index.html").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {

		//initialization activity - set up DB connection object
        System.out.println ("in init method");
		connection = DBConnection.getConnectionToDatabase ();
	}

	@Override
	public void destroy() {
        System.out.println ("in destroy method");

		//clean up activity - close DB Connection object
		try {
			connection.close ();
		} catch (SQLException e) {
			e.printStackTrace ( );
		}
	}
}
