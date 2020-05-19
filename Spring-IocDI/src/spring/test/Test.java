package spring.test;

import spring.Student;
import spring.Teacher;
import spring.core.IoCApplicationContex;

public class Test {
	public static void main(String[] args) throws Exception{
		IoCApplicationContex appCon = new IoCApplicationContex("spring/conf/beans.xml");
		Student stu = (Student) appCon.getBean("stu1");
		Teacher tch = (Teacher) appCon.getBean("tch1");
		System.out.println(stu.toString());
		System.out.println(tch.toString());
		
	}
}
