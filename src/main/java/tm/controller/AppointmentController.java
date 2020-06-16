package tm.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tm.domain.Appointment;
import tm.service.AppointmentService;

@Controller
@RequestMapping(value="/appointments")
public class AppointmentController {
	
	@Autowired
	AppointmentService service;
	
	@RequestMapping(value = {"", "/"}, method=RequestMethod.GET)
	public String getAllAppointments(Model model) {
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
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
	public String postAppointment() {
		service.createAppointment();
		return "appointment";
	}
	
	
	

}
