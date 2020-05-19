package spring.impl;

import spring.*;

public class TeacherImpl implements Teacher{
	private String course;
	private Student stu;
	
	public void print() {
		System.out.println("Teacher");
	}
	public String toString() {
		return "Teacher: course:" + course + " guide:" + this.stu.getName();
		
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCourse() {
		return this.course;
	}
	public void setGuide(Student stu) {
		this.stu = stu;
	}
}
