package tm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.domain.Appointment;
import tm.domain.Reservation;
import tm.domain.User;
import tm.enums.ReservationStatus;
import tm.repository.AppointmentRepository;
import tm.repository.ReservationRepository;
import tm.service.ReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public Reservation findById(int reservationId) {
		return reservationRepository.findOne(reservationId);
	}

	@Override
	public Reservation accept(Reservation reservation) {

		List<Reservation> lstReservation = getReservationsByAppointmentId(reservation.getAppointmentId());

		for (Reservation reser : lstReservation) {
			if (reser.getId() != reservation.getId()) {
				reser.setStatus(ReservationStatus.DECLINED);
				reservationRepository.save(reser);
			}
		}
		reservation.setStatus(ReservationStatus.ACCEPTED);

		return reservationRepository.save(reservation);

	}

	@Override
	public void delete(int ReservationId) {
		Reservation oldReservation = findById(ReservationId);
		if (oldReservation == null) {
			return;
		}
		reservationRepository.delete(ReservationId);
	}

	@Override
	public List<Reservation> getReservations() {
		return (List<Reservation>) reservationRepository.findAll();
	}

	@Override
	public void makeReservation(int appointmentId, User user) {

		Appointment appointment = appointmentRepository.findOne(appointmentId);

		Reservation reservation = new Reservation();
		reservation.setAppointment(appointment);
		reservation.setIsReminderSent(0);
		reservation.setStatus(ReservationStatus.PENDING);
		reservation.setConsumer(user);

		reservationRepository.save(reservation);
		appointmentRepository.save(appointment);
		System.out.println("saved");

	}

	@Override
	public List<Reservation> getReservationsByUserId(Integer userId) {
		return (List<Reservation>) reservationRepository.findByUserId(userId);
	}

	@Override
	public List<Reservation> getReservationsByAppointmentId(Integer appointmentId) {
		return (List<Reservation>) reservationRepository.findByAppointmentId(appointmentId);
	}

}
