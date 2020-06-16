package tm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tm.dto.UserDto;

@Controller
public class LoginController {

	@RequestMapping(value = { "", "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}

//	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
//	public String loginDo() {
//		return "appointmentList";
//	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "redirect:/welcome";
	}
}
