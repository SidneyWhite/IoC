package tm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tm.domain.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
	@Query(value = "SELECT * FROM RESERVATION r WHERE r.status = 'ACCEPTED' AND (IS_REMINDER_SENT IS NULL OR IS_REMINDER_SENT = 0) AND R.RESERVATIONDATE < :reservationDate", nativeQuery = true)
	List<Reservation> findNewAcceptedReservations(@Param("reservationDate") Date reservationDate);
	
	@Query(value = "FROM Reservation r WHERE appointment_id = :appointmentId")
	List<Reservation> findReservationByAppointmentId(@Param("appointmentId") int id);
}

//
//public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
//	@Query(value = "SELECT * FROM RESERVATION r WHERE r.status = 'ACCEPTED' AND (IS_REMINDER_SENT IS NULL OR IS_REMINDER_SENT = 0) AND R.RESERVATIONDATE < :reservationDate", nativeQuery = true)
//	List<Reservation> findNewAcceptedReservations(@Param("reservationDate") Date reservationDate);
//}
