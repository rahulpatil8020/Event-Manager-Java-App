package com.rahul.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.rahul.dao.EventDao;
import com.rahul.model.Event;

/**
 * Servlet implementation class EventServlet
 */
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EventDao eventDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
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
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEvent(request, response);
				break;
			case "/delete":
				deleteEvent(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEvent(request, response);
				break;
			default:
				listEvents(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listEvents(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Event> listUser = eventDao.getAllEvents();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("new_event.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Event existingUser = eventDao.selectEvent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update_event.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertEvent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		try {
			String name = request.getParameter("name");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			String parameter = request.getParameter("startDate");
			Date date = (Date) in.parse(parameter);
			String location = request.getParameter("location");
			String description = request.getParameter("description");
			if(request.getSession().getAttribute("auth") != null) {
				String temp = request.getSession().getAttribute("auth").toString();
				System.out.print(temp);
			}
			
			int createdBy = Integer.parseInt(request.getSession().getAttribute("userId").toString());

			Event book = new Event(name, date, location, description, createdBy);
			eventDao.createEvent(book);
			response.sendRedirect("index");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void updateEvent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		try {
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
			response.sendRedirect("index");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteEvent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		eventDao.deleteEvent(id);
		response.sendRedirect("index");

	}


}
