package org.example.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deptid;
	private String deptname;
	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)
	private List<Student> students;
	public Department() {
		
	}
	public Department(String name) {
		this.deptname=name;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
