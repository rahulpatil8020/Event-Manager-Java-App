package com.rahul.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.rahul.connection.DBCon;
import com.rahul.dao.EventDao;
import com.rahul.model.Event;

/**
 * Servlet implementation class UpdateEventServlet
 */
public class UpdateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEventServlet() {
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
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			String parameter = request.getParameter("startDate");
			Date date = (Date) in.parse(parameter);
			String location = request.getParameter("location");
			String description = request.getParameter("description");
			int createdBy = Integer.parseInt(request.getSession().getAttribute("userId").toString());

			Event book = new Event(id, name, date, location, description, createdBy);
			eventDao.updateEvent(book);
			response.sendRedirect("index.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
