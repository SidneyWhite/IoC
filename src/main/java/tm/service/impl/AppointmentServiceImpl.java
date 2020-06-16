package tm.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tm.domain.Appointment;
import tm.repository.AppointmentRepository;
import tm.service.AppointmentService;


@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepository appointmentRepo;
	
	

	@Override
	public void createAppointment() {
		appointmentRepo.save(new Appointment(new Date(), "111"));
	}

	@Override
	public Appointment getAppointment(int id) {
		return appointmentRepo.findOne(id);
	}

	@Override
	public List<Appointment> getAppointments() {
		return (List<Appointment>) appointmentRepo.findAll();
	}

}
