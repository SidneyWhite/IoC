package tm.service;

import java.util.List;

import tm.domain.Reservation;
import tm.domain.User;

public interface ReservationService {

	public Reservation findById(int reservationId);

	public Reservation accept(Reservation reservation);

	public void delete(int ReservationId);

	public void makeReservation(int appointmentId, User user);

	public List<Reservation> getReservations();

	public List<Reservation> getReservationsByUserId(Integer userId);

	public List<Reservation> getReservationsByAppointmentId(Integer appointmentId);
}
