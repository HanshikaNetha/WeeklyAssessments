package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
import org.example.entity.*;
public class EmployeeDAO {
	private static SessionFactory sessionfactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Exception e) {
			throw new RuntimeException("sessionfactory cannot be made", e);
		}
	}
	public static void main(String[] args) {

        Session session = sessionfactory.openSession();
        Transaction tx1 = session.beginTransaction();
        Employee emp = new Employee("Hanshika", "CSE", 50000);
        session.save(emp);
        tx1.commit();
        System.out.println("Employee Saved!");
        int empId = emp.getId();
        Employee gete = session.get(Employee.class, empId);

        if (gete != null) {
            System.out.println("Fetched Employee:");
            System.out.println("ID: " + gete.getId());
            System.out.println("Name: " + gete.getName());
            System.out.println("Department: " + gete.getDept());
            System.out.println("Salary: " + gete.getSalary());
        }
        Transaction tx2 = session.beginTransaction();
        gete.setSalary(60000);
        session.update(gete);
        tx2.commit();
        System.out.println("Salary Updated!");
        Transaction tx3 = session.beginTransaction();
        session.delete(gete);
        tx3.commit();
        System.out.println("Employee Deleted!");
        session.close();
        sessionfactory.close();
    }
}
