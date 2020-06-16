package tm.service;

import java.util.List;

import tm.domain.Role;
import tm.dto.RoleDto;

public interface RoleService {

	public List<RoleDto> findAllRoles();

	List<RoleDto> convertEntityListToResponseList(List<Role> entityList);

}
