<%@ page import="com.rahul.connection.DBCon" %>
<%@ page import="com.rahul.model.*" %>
<%@ page import="com.rahul.dao.*" %>
<%@ page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int userId = 0;
User auth = (User) request.getSession().getAttribute("auth");
if(auth != null){
	userId = (int) request.getSession().getAttribute("userId");
	request.setAttribute("auth",auth);
}


EventDao pd = new EventDao(DBCon.getConnection());
List<Event> events = pd.getAllEvents();

%>
<!DOCTYPE html>
<html>
<head>
<title>List of Events</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
<%@ include file="/includes/header.jsp" %>
<!-- CSS only -->
<!-- JavaScript Bundle with Popper -->
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
	<div class="h-screen">
<div class="mt-5 ml-5 flex items-center justify-between">
  <h1 class="text-3xl">Event List</h1>
  <a href="new_event.jsp" class="mr-10 rounded-md bg-indigo-500 px-4 py-2 hover:bg-indigo-700">Create Event</a>
</div>
		<%
			if(!events.isEmpty()){
				for(Event e:events){ %>
					<div class="mx-10 mt-10 mb-5 rounded-md bg-slate-400 px-5 pt-2 pb-3 shadow-md shadow-gray-400">
  <div class="flex w-full items-center justify-between">
    <a href="event_details.jsp" class="truncate text-2xl text-indigo-600"> <%= e.getName() %> </a>
    <p class="pl-4 text-indigo-500">Created on: 10th Nov 2012</p>
  </div>
  <p class="truncate pr-5 text-justify"><%= e.getDescription() %></p>
  <div class="flex items-center justify-between mb-3">
    <p class="mr-5 inline truncate text-justify text-green-700">Location: <%= e.getLocation() %></p>
    <p class="ml-5 inline text-red-500">Event Date: <%= e.getDate() %></p>
  </div>
  <% if(userId != e.getCreatedBy()) {
	  %>
	<form method="post" action="attend-event?id=<%= e.getId()%>">
		<button type="submit" class="rounded-md bg-indigo-500 px-4 py-2 hover:bg-indigo-700">Attend</button>
	</form>
  <%}else{ %>
  	<form method="post" action="show-update-form?id=<%= e.getId()%>">
		<button type="submit" class="rounded-md bg-indigo-500 px-4 py-2 hover:bg-indigo-700">Update</button>
	</form>
	<%} %>
</div>
	<%			}
			}
		%>
	</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>