<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.rahul.model.*"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Event</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
<%@ include file="/includes/header.jsp"%>
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>

	<div class="h-screen px-20">
		<form action="create-event" method="post">
			<div class="mt-5 mb-6 w-full px-3 md:mb-0 md:w-1/2">
				<label
					class="mb-2 block text-xs font-bold uppercase tracking-wide text-gray-700"
					for="name"> Event Name </label> <input
					class="mb-3 block w-full appearance-none rounded border border-red-500 bg-gray-200 py-3 px-4 leading-tight text-gray-700 focus:bg-white focus:outline-none"
					id="name" name="name"
					type="text" placeholder="Enter Event Name" required />
			</div>
			<div class="mb-6 w-full px-3 md:w-1/2">
				<label
					class="mb-2 block text-xs font-bold uppercase tracking-wide text-gray-700"
					for="location"> Event Location </label> <input
					class="block w-full appearance-none rounded border border-gray-200 bg-gray-200 py-3 px-4 leading-tight text-gray-700 focus:border-gray-500 focus:bg-white focus:outline-none"
					id="location" type="text" name="location" placeholder="Enter Event Location"
					required />
			</div>
			<div class="w-full px-3 md:w-1/2 mb-6">
				<label
					class="mb-2 block text-xs font-bold uppercase tracking-wide text-gray-700"
					for="description"> Event Description </label>
				<textarea
					class="block w-full appearance-none rounded border border-gray-200 bg-gray-200 py-3 px-4 leading-tight text-gray-700 focus:border-gray-500 focus:bg-white focus:outline-none"
					id="description" name="description" placeholder="Enter the Description of the event"></textarea>
			</div>
			<div class="mx-3 w-max mb-6">
				<label
					class="mb-2 block text-xs font-bold uppercase tracking-wide text-gray-700"
					for="date"> Event Date </label> <input
					class="block w-full appearance-none rounded border border-gray-200 bg-gray-200 py-3 px-4 leading-tight text-gray-700 focus:border-gray-500 focus:bg-white focus:outline-none"
					id="date" name="date" type="datetime-local" required />
			</div>
			<div class="mx-3">
				<input type="submit" value="submit"
					class="bg-indigo-500 px-10 py-2 rounded-md" />
			</div>
		</form>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>