package tm.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tm.domain.Appointment;
import tm.service.AppointmentService;
import tm.service.impl.UserService;

@Controller
@RequestMapping(value="/appointments")
public class AppointmentController {
	
	@Autowired
	AppointmentService service;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = {"", "/"}, method=RequestMethod.GET)
	public String getAllAppointments(Model model) {
		
		model.addAttribute("currentUserId", userService.getCurrentUser().getId());
		
		List<Appointment> appointments = service.getAppointments();
		model.addAttribute("appointments", appointments);
		return "appointment";
	}
	
	
	
	@RequestMapping(value ="/{appId}", method=RequestMethod.GET)
	public String getAppointment(@PathVariable("appId") String appointmentId, Model model) {
		System.out.println(appointmentId);
		List<Appointment> appointments = new ArrayList<Appointment>();
		appointments.add(service.getAppointment(Integer.parseInt(appointmentId)));
		model.addAttribute("appointments", appointments);
		return "appointment";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAppointment(@ModelAttribute("newAppointment") Appointment appointment) {
		return "addAppointment";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAppointment(@Valid @ModelAttribute("newAppointment") Appointment appointment, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addAppointment";
		}
		service.createAppointment(appointment);
		
		return "redirect:/appointments";
	}
	
	
	
	
	 @InitBinder
	 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	     final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	 }
	
	
	

}
