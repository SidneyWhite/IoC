package tm.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tm.domain.EmailNotification;
import tm.domain.Reservation;
import tm.enums.ENotificationStatus;
import tm.repository.NotificationRepository;
import tm.repository.ReservationRepository;

public class Notification {

//	@Value("${schedule.notification.reminder.minutes}")
	private long reminderMinutesBeforeAppointment;

//	@Autowired
//	private JavaMailSender mailSender;

	@Autowired
	private NotificationRepository repository;

	@Autowired
	private ReservationRepository reservRepo;

//	@Scheduled(fixedDelayString = "${sync-job.delay.milliseconds.fixed}", initialDelayString = "${sync-job.delay.milliseconds.initial}")
	public void schSendEmail() {

		List<EmailNotification> lstEmail = repository.findByStatus(ENotificationStatus.NEW);

		for (EmailNotification email : lstEmail) {
			System.out.println(email.toString());
			sendMail(email);
		}

		System.out.println("working schedule schSendEmail: " + LocalDateTime.now());
	}

//	@Scheduled(fixedDelayString = "${sync-job.delay.milliseconds.fixed}", initialDelayString = "${sync-job.delay.milliseconds.initial}")
	public void schReminder() {

		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date filterDate = new Date(t + (reminderMinutesBeforeAppointment * 60000));

		List<Reservation> lstReservation = reservRepo.findNewAcceptedReservations(filterDate);

		for (Reservation reserv : lstReservation) {
			System.out.println(reserv.toString());
			insertReminderNotification(reserv);
			reserv.setIsReminderSent(1);
			reservRepo.save(reserv);
		}

		System.out.println("working schedule schReminder: " + LocalDateTime.now());
	}

	@Async
	public void sendMail(EmailNotification email) {
		SimpleMailMessage message = new SimpleMailMessage();
		try {

			System.out.println("sending email to " + email.getContent());
			message.setFrom("tm_life@miu.edu");
			message.setTo(email.getRecipientEmail());
			message.setSubject(email.getSubject());
			message.setText(email.getContent());
//			mailSender.send(message);

			email.setStatus(ENotificationStatus.SUCCEED);
			updateNotification(email);

		} catch (MailException me) {
			System.out.println("email exception: " + me);

			email.setStatus(ENotificationStatus.FAILED);
			email.setErrorDesc(me.getMessage());
			updateNotification(email);
		}
	}

	private void insertReminderNotification(Reservation reservation) {
		// For student
//		EmailNotification emailNotif = new EmailNotification();
//		emailNotif.setReservation(reservation);
//		emailNotif.setAppointmentDatetime(reservation.getAppointment().getAppointmentDate());
//		emailNotif.setContent(String.format("Dear %s, Your appointment will start at %s",
//				reservation.getConsumer().getFirstName(), reservation.getReservationDate()));
//		emailNotif.setCreatedDatetime(new Date());
//		emailNotif.setRecipientEmail(reservation.getConsumer().getEmail());
//		emailNotif.setSentDatetime(null);
//		emailNotif.setStatus(ENotificationStatus.NEW);
//		emailNotif.setSubject(String.format("Appointment id: %s", reservation.getAppointment().getId()));
//		emailNotif.setReservation(reservation);
//		repository.save(emailNotif);
//
//		// For TA Checker
//		emailNotif = new EmailNotification();
//		emailNotif.setReservation(reservation);
//		emailNotif.setAppointmentDatetime(reservation.getAppointment().getAppointmentDate());
//		emailNotif.setContent(String.format("Dear %s, Your appointment will start at %s",
//				reservation.getAppointment().getProvider().getFirstName(), reservation.getReservationDate()));
//		emailNotif.setCreatedDatetime(new Date());
//		emailNotif.setRecipientEmail(reservation.getAppointment().getProvider().getEmail());
//		emailNotif.setSentDatetime(null);
//		emailNotif.setStatus(ENotificationStatus.NEW);
//		emailNotif.setSubject(String.format("Appointment id: %s", reservation.getAppointment().getId()));
//		emailNotif.setReservation(reservation);
//		repository.save(emailNotif);
	}

	@Async
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insertNotification(Reservation reservation) {
		try {
			EmailNotification emailNotif = new EmailNotification();
//			emailNotif.setReservation(reservation);
//			emailNotif.setAppointmentDatetime(reservation.getAppointment().getAppointmentDate());
//			emailNotif.setContent(String.format("Dear %s, Your reservation number %s is %s",
//					reservation.getConsumer().getFirstName(), reservation.getId(), reservation.getStatus()));
//			emailNotif.setCreatedDatetime(new Date());
//			emailNotif.setRecipientEmail(reservation.getConsumer().getEmail());
//			emailNotif.setSentDatetime(null);
//			emailNotif.setStatus(ENotificationStatus.NEW);
//			emailNotif.setSubject(String.format("Decision about reservation id: %s", reservation.getId()));
//			emailNotif.setReservation(reservation);
			repository.save(emailNotif);
		} catch (Exception e) {
			System.out.println("exception on Notification.insertNotification: " + e.getMessage());
		}
	}

	public void updateNotification(EmailNotification emailNotif) {
		repository.save(emailNotif);
	}
}
