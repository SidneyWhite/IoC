package tm.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tm.domain.Appointment;
import tm.domain.Reservation;
import tm.service.AppointmentService;
import tm.service.impl.UserService;

@Controller
@RequestMapping(value="/appointments")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = {"", "/"}, method=RequestMethod.GET)
	public String getAllAppointments(Model model) {
		
		model.addAttribute("currentUserId", userService.getCurrentUser().getId());
		
		List<Appointment> appointments = appointmentService.getAppointments();
		model.addAttribute("appointments", appointments);
		return "appointment";
	}
	
	
	
	@RequestMapping(value ="/{appId}", method=RequestMethod.GET)
	public String getAppointment(@PathVariable("appId") String appointmentId, Model model) {
		System.out.println(appointmentId);
		List<Appointment> appointments = new ArrayList<Appointment>();
		appointments.add(appointmentService.getAppointment(Integer.parseInt(appointmentId)));
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
		appointmentService.createAppointment(appointment);
		
		return "redirect:/appointments";
	}
	
//	@RequestMapping(value = "/getreservations/{appointmentId}")
//	public ResponseEntity<String> getReservation(@PathVariable("appointmentId") int appId, Model model){
//		
//		List<Reservation> reservationList= appointmentService.getReservations(appId);
//		
//		final HttpHeaders httpHeaders= new HttpHeaders();
//	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//	    return new ResponseEntity<String>("{\"status\":\"success\"}", httpHeaders, HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/getreservations/{appointmentId}")
	public ResponseEntity<String> getReservation(@PathVariable("appointmentId") int appId, Model model){
		List<Reservation> reservationList= appointmentService.getReservations(appId);
		
//		return reservationList;
		
		
		
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<String>("{\"status\":\"success\"}", httpHeaders, HttpStatus.OK);
	}
	
	
	
	
	
	
	 @InitBinder
	 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	     final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	 }
	
	
	

}
