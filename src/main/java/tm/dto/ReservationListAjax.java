package tm.dto;

import java.util.List;

import tm.domain.Reservation;

public class ReservationListAjax {
	
	List<Reservation> reservations;

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	

}
