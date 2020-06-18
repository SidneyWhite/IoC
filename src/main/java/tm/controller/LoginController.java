package tm.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import tm.dto.UserDto;

@Controller
//@SessionAttributes("user")
public class LoginController {

	@RequestMapping(value = { "", "/login" }, method = RequestMethod.GET)
	public String login() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			if(((UserDetails) principal).isCredentialsNonExpired()) {
				return "redirect:/appointments";
			}
		}
		return "login";
	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "redirect:/login";
	}
}
