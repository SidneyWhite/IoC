package tm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tm.domain.Reservation;
import tm.service.ReservationService;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String getReservations(Model model) {
		List<Reservation> reservations = reservationService.getReservations();
		model.addAttribute("reservations", reservations);
		return "reservation";
	}

//	@PostMapping()
//	public void createResevation(@RequestBody Reservation reservation) {
//		reservationService.save(reservation);
//	}
//
//	@GetMapping()
//	public List<Reservation> getReservations() {
//		return reservationService.findAll();
//	}
//
//	@GetMapping("/{reservationId}")
//	public Reservation getReservationById(@PathVariable int reservationId) {
//		return reservationService.findById(reservationId);
//	}
//
//	@PutMapping("/{reservationId}")
//	public Reservation updateById(@PathVariable int reservationId, @RequestBody Reservation reservation) {
//
//		Reservation reservation1 = reservationService.findById(reservationId);
//
//		if (reservation1 == null)
//
//			return null;
//
//		reservation.setId(reservationId);
//
//		return reservationService.update(reservation);
//
//	}
//
//	@DeleteMapping("/{reservationId}")
//	public void deleteReservation(@PathVariable int reservationId) {
//		reservationService.delete(reservationId);
//	}

}
