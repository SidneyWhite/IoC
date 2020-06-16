package tm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String signUp() {

		return "signup";
	}

}
