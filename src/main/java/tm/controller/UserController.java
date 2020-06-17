package tm.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String signUp(@ModelAttribute("newUser") UserDto userDto, Model model) {
		List<RoleDto> roles = roleService.findAllRoles();

		Map<Long, String> roleList = new LinkedHashMap<Long, String>();
		for (RoleDto roleDto : roles) {
			roleList.put(roleDto.getId(), roleDto.getName());
		}

		model.addAttribute("roles", roleList);
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String processSignup(@ModelAttribute("newUser") UserDto userDto, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		UserDto savedUser = userService.createUser(userDto);
//		redirectAttributes.addFlashAttribute("user", userDto);
		return "redirect:/login";
	}
	

}
