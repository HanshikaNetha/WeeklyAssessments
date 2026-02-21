package org.example.entity;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="dept")
	private String dept;
	@Column(name="sal")
	private double salary;
	public Employee() {
		
	}
	public Employee( String name, String dept, double salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
