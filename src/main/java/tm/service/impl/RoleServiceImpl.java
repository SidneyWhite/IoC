package tm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.domain.Role;
import tm.dto.RoleDto;
import tm.repository.RoleRepository;
import tm.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public List<RoleDto> findAllRoles() {
		// TODO Auto-generated method stub
		return convertEntityListToResponseList(roleRepository.findAll());
	}

	@Override
	public List<RoleDto> convertEntityListToResponseList(List<Role> entityList) {
		// TODO Auto-generated method stub
		if (null == entityList)
			return null;
		else {
			return entityList.stream().map(entity -> modelMapper.map(entity, RoleDto.class))
					.collect(Collectors.toList());
		}
	}
}
