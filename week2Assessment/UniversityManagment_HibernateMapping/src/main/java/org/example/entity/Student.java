package org.example.entity;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stuId;
	
	private String stuName;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idcard_id")
	private IdCard idcard;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;
	
	public Student() {
		
	}
	public Student(String name) {
		this.stuName=name;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public IdCard getIdcard() {
		return idcard;
	}
	public void setIdcard(IdCard idcard) {
		this.idcard = idcard;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
