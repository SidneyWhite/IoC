package tm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tm.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	@Query(value = "SELECT * FROM RESERVATION r WHERE r.status = 'ACCEPTED' AND (IS_REMINDER_SENT IS NULL OR IS_REMINDER_SENT = 0) AND R.RESERVATIONDATE < :reservationDate", nativeQuery = true)
	List<Reservation> findNewAcceptedReservations(@Param("reservationDate") Date reservationDate);
}
