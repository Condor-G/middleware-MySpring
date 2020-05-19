package spring.impl;

import spring.Student;

public class StudentImpl implements Student {
	private String name;
	private String age;
	public void print() {
		System.out.println("Student");
	}
	public String toString() {
		return "Student: Name:" + this.name + " Age:" + this.age;
	}
	public void setName(String name) {
		this.name = new String(name);
	}
	public void setAge(String age) {
		this.age = new String(age);
	}
	public String getName() {
		return this.name;
	}
	public String getAge() {
		return this.age;
	}
}
