package org.example.entity;
import javax.persistence.*;

@Entity
@Table(name="idcard")
public class IdCard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int cardNumber;
	
	@OneToOne(mappedBy="idcard")
	private Student student;
	
	public IdCard() {
		
	}
	public IdCard(int cardNumber) {
		this.cardNumber=cardNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
