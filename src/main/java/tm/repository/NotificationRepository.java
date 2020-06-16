package tm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tm.domain.EmailNotification;
import tm.enums.ENotificationStatus;

@Repository
public interface NotificationRepository extends JpaRepository<EmailNotification, Integer> {

	List<EmailNotification> findByStatus(ENotificationStatus status);

}
