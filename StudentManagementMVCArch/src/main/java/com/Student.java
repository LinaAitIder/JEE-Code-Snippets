package com;

public class Student {
	int id;
	String name;
	String mail;
	String course;
	int year;
	
	public Student() {}
	//SETTERS
	
	public void setName(String name) {this.name=name;}
	public void setMail(String mail) {this.mail=mail;}
	public void setId(int id) {this.id=id;}
	public void setCourse(String course) {this.course=course;}
	public void setYear(int year) {this.year=year;}
	
	//GETTERS
	public String getName()
	{
		return this.name;
	}
	public int getId() {
		return this.id;
	}
	public String getMail() {
		return this.mail;
	}
	
	public String getCourse() {
		return this.course;
	}
	
	public int getYear() {
		return this.year;
	}
}
