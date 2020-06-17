package tm.service;

import java.util.List;

import tm.domain.Appointment;
import tm.domain.Reservation;

public interface AppointmentService {
	
	
	public void createAppointment(Appointment appointment);
	
	public Appointment getAppointment(int id);
	
	public List<Appointment> getAppointments();
	
	public List<Reservation> getReservations(int appintmentId);
	
	

}
