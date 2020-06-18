package tm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tm.domain.Role;
import tm.domain.User;
import tm.dto.UserDto;
import tm.repository.RoleRepository;
import tm.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModelMapper modelMapper;

	public UserService() {
		modelMapper = new ModelMapper();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				authorities);
	}

	public UserDto createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		Role role = roleRepository.findOne(userDto.getRoleId());
		user.addRole(role);
		userRepository.save(user);

		return convertEntityToResponse(user);
	}

	public UserDto convertEntityToResponse(User entity) {
		if (null == entity) {
			return null;
		} else {
			return modelMapper.map(entity, UserDto.class);
		}
	}

	public Set<String> getCurrentUserRoles() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Set<String> roles = authentication.getAuthorities().stream().map(r -> r.getAuthority())
				.collect(Collectors.toSet());
		return roles;
	}

	public User getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		return userRepository.findByUserName(username);
	}
}
