package tm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tm.domain.Reservation;
import tm.service.AppointmentService;
import tm.service.ReservationService;
import tm.service.impl.UserService;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	UserService userService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String getReservations(Model model) {
//		List<Reservation> reservations = reservationService.getReservations();
		List<Reservation> reservations = reservationService
				.getReservationsByUserId((int) userService.getCurrentUser().getId());
		model.addAttribute("reservations", reservations);
		return "reservation";
	}

	@RequestMapping(value = "/makereservation/{appointmentId}", produces = "application/json")
	public ResponseEntity<String> makeReservation(@PathVariable("appointmentId") int appointmentId, Model model) {

		reservationService.makeReservation(appointmentId, userService.getCurrentUser());

		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return new ResponseEntity<String>("{\"status\":\"success\"}", httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/acceptreservation/{reservationId}")
	public void acceptReservation(@PathVariable("reservationId") int reservationId, Model model) {

		Reservation res = reservationService.findById(reservationId);
		reservationService.accept(res);
	}

	@RequestMapping(value = "/deletereservation/{reservationId}")
	public void deleteReservation(@PathVariable("reservationId") int reservationId, Model model) {
		reservationService.delete(reservationId);
	}

}
