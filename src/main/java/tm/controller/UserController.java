package tm.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tm.domain.Role;
import tm.domain.User;
import tm.dto.RoleDto;
import tm.dto.UserDto;
import tm.service.RoleService;
import tm.service.impl.UserService;

@Controller
//@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String signUp(@ModelAttribute("newUser") UserDto userDto, Model model) {

		model.addAttribute("roles", getRoles());
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String processSignup(@Valid @ModelAttribute("newUser") UserDto userDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {

		if (!userDto.getPassword().equals(userDto.getVerifyPassword())) {
			bindingResult.reject("foo", "Passwords do not match!");
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("roles", getRoles());
			return "signup";
		}

		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userService.createUser(userDto);
		return "redirect:/login";
	}

	public Map<Long, String> getRoles() {
		List<RoleDto> roles = roleService.findAllRoles();
		Map<Long, String> roleList = new LinkedHashMap<Long, String>();
		for (RoleDto roleDto : roles) {
			roleList.put(roleDto.getId(), roleDto.getName().split("_")[1]);
		}
		return roleList;
	}

}
