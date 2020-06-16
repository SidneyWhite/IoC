package tm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credentials {

	@Id
	@Column(nullable = false, unique = true)
	String username;
	@Column(nullable = false)
	String password;
	
	public Credentials() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
