package tm.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class RoleDto {

	@NotEmpty
	private String name;
	private long id;

	public RoleDto() {
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
