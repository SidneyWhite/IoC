package tm.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Date is required")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@NotEmpty(message = "Room number is required")
	private String room_no;
	
	
	@ManyToOne
	User user;
	
	Appointment(){}
	
	public Appointment(Date date, String room_no) {
		this.date = date;
		this.room_no = room_no;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	

}
