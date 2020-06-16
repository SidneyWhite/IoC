package tm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.domain.Reservation;
import tm.enums.ReservationStatus;
import tm.repository.AppointmentRepository;
import tm.repository.ReservationRepository;
import tm.service.ReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	

//	@Autowired
//	Notification notif;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public void save(Reservation reservation) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation findById(int reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation update(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int ReservationId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reservation> getReservations() {
		return (List<Reservation>) reservationRepository.findAll();
	}

	@Override
	public void makeReservation(int appointmentId) {
		
		Appointment appointment = appointmentRepository.findOne(appointmentId);
		
		Reservation reservation = new Reservation();
		reservation.setAppointment(appointment);
		reservation.setIsReminderSent(0);
		reservation.setStatus(ReservationStatus.PENDING);
		reservation.setUserId(1);
		reservation.setReservationDate(appointment.getDate());
		
		reservationRepository.save(reservation);
		appointmentRepository.save(appointment);
		System.out.println("saved");
		
	}
	
	

}
