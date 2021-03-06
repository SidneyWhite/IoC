package tm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
	
	@Autowired
	UserService userService;
	

	@Override
	public void createAppointment(Appointment appointment) {
		appointment.setUser(userService.getCurrentUser());
		appointmentRepo.save(appointment);
	}

	@Override
	public Appointment getAppointment(int id) {
		return appointmentRepo.findOne(id);
	}

	@Override
	public List<Appointment> getAppointments() {
		
		Set<String> userRoles = userService.getCurrentUserRoles();
		for(String role: userRoles) {
			System.out.print(role+" ");
		}
		if(userRoles.contains("ROLE_STUDENT")) {
			return (List<Appointment>) appointmentRepo.findAll();
		}
		
		int userId = (int)userService.getCurrentUser().getId();
		return (List<Appointment>) appointmentRepo.findAllByUserId(userId);
		
	}

	@Override
	public List<Reservation> getReservations(int appintmentId) {
		return (List<Reservation>) reservationRepo.findReservationByAppointmentId(appintmentId);
	}

}
