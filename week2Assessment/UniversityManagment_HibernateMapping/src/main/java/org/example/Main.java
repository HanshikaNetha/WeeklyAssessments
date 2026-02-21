package org.example;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.example.entity.*;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	private static SessionFactory sessionfactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Exception e) {
			throw new RuntimeException("sessionfactory cannot be made", e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Session session=sessionfactory.openSession();
		Transaction t=session.beginTransaction();
		System.out.print("Enter Departemnt name: ");
		String dname=sc.nextLine();
		Department d=new Department(dname);
		System.out.println("enter student1 name: ");
		String s1name=sc.nextLine();
		Student s1=new Student(s1name);
		System.out.println("enter student 2 name: ");
		String s2name=sc.nextLine();
		Student s2=new Student(s2name);
		s1.setDepartment(d);
		s2.setDepartment(d);
		System.out.println("enetr id number for s1: ");
		int idnum1=sc.nextInt();
		IdCard i1=new IdCard(idnum1);
		System.out.println("Enter id number for s2: ");
		int idnum2=sc.nextInt();
		sc.nextLine();
		IdCard i2=new IdCard(idnum2);
		s1.setIdcard(i1);
		s2.setIdcard(i2);
		System.out.println("enter course1 name: ");
		String c1name=sc.nextLine();
		Course c1=new Course(c1name);
		System.out.println("enter course2 name: ");
		String c2name=sc.nextLine();
		Course c2=new Course(c2name);
		s1.setCourses(Arrays.asList(c1, c2));
		s2.setCourses(Arrays.asList(c2));
		session.save(d);
		session.save(s1);
		session.save(s2);
		session.save(c1);
		session.save(c2);
		t.commit();
		session.close();
		sessionfactory.close();
		System.out.println("we are odone");
		sc.close();
		
		
		
//		while(true) {
//			System.out.println("1.add student\n2.add course\n3.add department\n4.add idcard\n5.exit");
//			System.out.print("Enter choice: ");
//			int choice=sc.nextInt();
//			sc.nextLine();
//			Transaction t=session.beginTransaction();
//			switch(choice) {
//			case 1:
//				System.out.print("Enter student name: ");
//				String stname=sc.nextLine();
//				Student s=new Student(stname);
//				session.save(s);
//				System.out.println("student added");
//				break;
//			case 2:
//				System.out.println("enter course: ");
//				String cname=sc.nextLine();
//				Course c=new Course(cname);
//				session.save(c);
//				System.out.println("course added");
//				break;
//			case 3:
//				System.out.print("Enter departemnt:");
//				String dname=sc.nextLine();
//				Department d=new Department(dname);
//				session.save(d);
//				System.out.println("dpeartment added");
//				break;
//			case 4:
//				System.out.println("enter card number: ");
//				int idnum=sc.nextInt();
//				IdCard id=new IdCard(idnum);
//				session.save(id);
//				System.out.println("idcard  added");
//				break;
//			case 5:
//				t.commit();
//				session.close();
//				sessionfactory.close();
//				System.out.println("this is the end");
//				break;
//			default:
//				System.out.println("you entered wrong choice");
//			}
//		}
	}

}
