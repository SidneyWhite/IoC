package tm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tm.domain.Appointment;


@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{

}