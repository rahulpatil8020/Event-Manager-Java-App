package com.rahul.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.rahul.connection.DBCon;
import com.rahul.dao.EventDao;
import com.rahul.model.Event;

/**
 * Servlet implementation class CreateEventServlet
 */
public class CreateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			EventDao eventDao = new EventDao(DBCon.getConnection());
			if(request.getSession().getAttribute("auth") != null) {
				
			System.out.println("Hello");
			String name = request.getParameter("name");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			String parameter = request.getParameter("date");
			Date date = (Date) in.parse(parameter);
			String location = request.getParameter("location");
			String description = request.getParameter("description");
			int createdBy = Integer.parseInt(request.getSession().getAttribute("userId").toString());
			
			Event book = new Event(name, date, location, description, createdBy);
			eventDao.createEvent(book);
			response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
