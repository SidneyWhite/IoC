package tm.service;

import java.util.List;
import java.util.Optional;

import javax.management.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.domain.Reservation;
import tm.repository.AppointmentRepository;
import tm.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	Notification notif;

	@Autowired
	AppointmentRepository appointmentRepository;

	public void save(Reservation reservation) {

		reservationRepository.save(reservation);
	}

	public List<Reservation> findAll() {

		return reservationRepository.findAll();
	}

	public Reservation findById(int reservationId) {
		Optional<Reservation> reservation = null;// reservationRepository.find(reservationId);
		return reservation.isPresent() ? reservation.get() : null;
	}

	public Reservation update(Reservation reservation) {

		return reservationRepository.save(reservation);

	}

	public void delete(int ReservationId) {
		Reservation oldReservation = findById(ReservationId);
		if (oldReservation == null) {
			return;
		}
		reservationRepository.delete(ReservationId);
	}

}
