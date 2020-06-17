package tm.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.domain.Appointment;
import tm.domain.Reservation;
import tm.repository.AppointmentRepository;
import tm.repository.ReservationRepository;
import tm.service.AppointmentService;


@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	

	@Override
	public void createAppointment(Appointment appointment) {
		appointmentRepo.save(appointment);
	}

	@Override
	public Appointment getAppointment(int id) {
		return appointmentRepo.findOne(id);
	}

	@Override
	public List<Appointment> getAppointments() {
		return (List<Appointment>) appointmentRepo.findAll();
	}

	@Override
	public List<Reservation> getReservations(int appintmentId) {
		return (List<Reservation>) reservationRepo.findReservationByAppointmentId(appintmentId);
	}

}
