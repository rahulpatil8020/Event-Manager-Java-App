package com.rahul.model;

import java.util.Date;

public class Event {
	private int id;
	private String name;
	private Date date;
	private String location;
	private String description;
	private int createdBy;
	
	public Event() {

	}

	public Event(int id, String name, Date date, String location, String description, int createdBy) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.location = location;
		this.description = description;
		this.createdBy = createdBy;
	}

	public int getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", date=" + date + ", location=" + location + ", description="
				+ description + ", createdBy=" + createdBy + "]";
	}

	public Event(String name, Date date, String location, String description, int createdBy) {
		super();
		this.name = name;
		this.date = date;
		this.location = location;
		this.description = description;
		this.createdBy = createdBy;
	}


	
	
}
