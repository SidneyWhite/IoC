package tm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tm.enums.ENotificationStatus;
import tm.enums.ENotificationType;

@Entity
@Table(name = "EMAIL_NOTIFICATION")
public class EmailNotification {

	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	@Column(name = "recipient_email")
	private String recipientEmail;

	private String subject;

	private String content;

	@Enumerated(EnumType.STRING)
	private ENotificationType type;

	@Enumerated(EnumType.STRING)
	private ENotificationStatus status;

	@Column(name = "error_desc")
	private String errorDesc;

	@Temporal(TemporalType.DATE)
	@Column(name = "created_datetime")
	private Date createdDatetime;

	@Temporal(TemporalType.DATE)
	@Column(name = "appointment_datetime")
	private Date appointmentDatetime;

	@Temporal(TemporalType.DATE)
	@Column(name = "sent_datetime")
	private Date sentDatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ENotificationType getType() {
		return type;
	}

	public void setType(ENotificationType type) {
		this.type = type;
	}

	public ENotificationStatus getStatus() {
		return status;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public void setStatus(ENotificationStatus status) {
		this.status = status;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Date getAppointmentDatetime() {
		return appointmentDatetime;
	}

	public void setAppointmentDatetime(Date appointmentDatetime) {
		this.appointmentDatetime = appointmentDatetime;
	}

	public Date getSentDatetime() {
		return sentDatetime;
	}

	public void setSentDatetime(Date sentDatetime) {
		this.sentDatetime = sentDatetime;
	}

	@Override
	public String toString() {
		return "id: " + id + " subject: " + subject + " content: " + content + " status: " + status;
	}
}
