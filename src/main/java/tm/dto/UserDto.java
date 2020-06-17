package tm.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDto {

	private Long id;

	@NotEmpty(message = "{NotEmpty}")
	private String firstName;
	@NotEmpty(message = "{NotEmpty}")
	private String lastName;
	@Email
	private String email;
	@NotEmpty(message = "{NotEmpty}")
	private String userName;

	@NotEmpty(message = "{NotEmpty}")
	private String password;
	@NotEmpty(message = "{NotEmpty}")
	private String verifyPassword;
	@NotNull(message = "{NotNull}")
	private long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

}
