package tm.service;

import java.util.List;

import tm.domain.Appointment;
import tm.domain.Reservation;

public interface ReservationService {

	public void save(Reservation reservation);

	public List<Reservation> findAll();

	public Reservation findById(int reservationId);

	public Reservation update(Reservation reservation);

	public void delete(int ReservationId);

	public List<Reservation> getReservations();
}
