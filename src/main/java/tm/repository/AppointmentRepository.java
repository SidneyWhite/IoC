package tm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tm.domain.Appointment;


@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{
	
	@Query(value = "FROM Appointment WHERE user_id = :userid")
	public List<Appointment> findAllByUserId(@Param("userid") int id);
	
	

}
