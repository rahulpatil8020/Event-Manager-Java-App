package com.rahul.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.rahul.connection.DBCon;
import com.rahul.dao.EventDao;
import com.rahul.model.Event;
import com.rahul.model.User;

/**
 * Servlet implementation class EventAttendServlet
 */
public class EventAttendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventAttendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		EventDao eventDao = new EventDao(DBCon.getConnection());
		User user = (User) request.getSession().getAttribute("auth");
		if(user == null) {
			response.sendRedirect("login.jsp");
		}else {
			int userId = (int) request.getSession().getAttribute("userId");
			int id = Integer.parseInt(request.getParameter("id"));
			Event event = eventDao.selectEvent(id);
			
			eventDao.attendEvent(userId, event.getName(), event.getCreatedBy());
			response.sendRedirect("index.jsp");
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
