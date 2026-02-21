package org.example.entity;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students;
	
	public Course() {
		
	}
	public Course(String cn) {
		this.courseName=cn;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
