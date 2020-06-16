package tm.service;

import java.util.List;

import tm.domain.Appointment;

public interface AppointmentService {
	
	
	public void createAppointment();
	
	public Appointment getAppointment(int id);
	
	public List<Appointment> getAppointments();
	
	

}
