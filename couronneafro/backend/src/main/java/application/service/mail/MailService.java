package application.service.mail;

import application.service.connection.PersistenceServiceException;
import application.service.observer.ClientServiceObserver;
import application.service.observer.MailServiceObservable;
import domain.mail.MailSender;
import domain.mail.MailSenderException;
import domain.user.client.Client;
import infrastructure.client.PersistenceInternalException;
import utility.ApplicationConfiguration;
import utility.datamanager.MailDataManager;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailService extends MailServiceObservable implements ClientServiceObserver,Runnable {

	private static final String SUBJECT = "Validation";
	private static final String BODY = "Merci d'avoir choisi AfroCare donnez moi tout votre argent" +
			" bon Patrice cherie tu me diras ce que tu veux avoir ecris ici";
	private static boolean mailToCheck;
	private int sendAttempts;
	private long timeToWaitBetweenValidation;
	private MailSender mailSender;
	private Map<Client, Integer> invalidMails;


	public MailService() {
		mailSender = new MailSender(ApplicationConfiguration.mailAddress, ApplicationConfiguration.mailPassword);
		timeToWaitBetweenValidation = Long.parseLong(ApplicationConfiguration.sendInterval);
		sendAttempts = Integer.parseInt(ApplicationConfiguration.sendAttempt);
		invalidMails = new LinkedHashMap<>();
		mailToCheck = false;
	}

	public MailService(MailSender mailSender, long timeToWaitBetweenValidation, int sendAttempts) {
		this.mailSender = mailSender;
		this.timeToWaitBetweenValidation = timeToWaitBetweenValidation;
		this.sendAttempts = sendAttempts;
		invalidMails = new LinkedHashMap<>();
		mailToCheck = false;
	}

	public Map<Client, Integer> getInvalidMails() {
		return invalidMails;
	}

	public synchronized void setMailToCheck(boolean mailToCheck) {
		MailService.mailToCheck = mailToCheck;
	}

	@Override
	public void listenClientCreated(Client client) {
		sendValidationMail(client);
	}

	@Override
	public void listenAppointmentMadeByClient(Client client) {
		sendAppointmentValidationMail(client);
	}

	@Override
	public void listenHairAppointmentMadeByClient(Client client) {
		sendHairAppointmentValidationMail(client);
	}

	private void sendHairAppointmentValidationMail(Client client) {
		try{
			mailSender.send(client.getEmail(), MailDataManager.SUBJECT,MailDataManager.HAIR_APPOINTMENT_VALIDATION_BODY);
			if (invalidMails.containsKey(client)){
				invalidMails.remove(client);
			}
		}catch (MailSenderException e){
			invalidMails.putIfAbsent(client,1);
			mailToCheck=true;
			synchronized (invalidMails){
				invalidMails.notify();
			}
		}
	}

	public void sendValidationMail(Client client) {
		try {
			mailSender.send(client.getEmail(), SUBJECT, BODY);
			if (invalidMails.containsKey(client)) {
				invalidMails.remove(client);
			}
		} catch (MailSenderException e) {
			invalidMails.putIfAbsent(client, 1);
			setMailToCheck(true);
			synchronized (invalidMails) {
				invalidMails.notify();
			}
		}
	}

	public void sendAppointmentValidationMail(Client client){
		try{
			mailSender.send(client.getEmail(), MailDataManager.SUBJECT,MailDataManager.BODY);
			if (invalidMails.containsKey(client)){
				invalidMails.remove(client);
			}
		}catch (MailSenderException e){
			invalidMails.putIfAbsent(client,1);
			mailToCheck=true;
			synchronized (invalidMails){
				invalidMails.notify();
			}
		}
	}

	public void checkInvalidMails() throws InterruptedException, PersistenceServiceException, PersistenceInternalException {
		while (!invalidMails.isEmpty()) {
			for (Map.Entry<Client, Integer> entry : invalidMails.entrySet()) {
				Client client = entry.getKey();
				int count = entry.getValue();
				if (count < sendAttempts) {
					sendValidationMail(client);
					invalidMails.put(client, count + 1);
				} else {
					invalidMails.remove(client);
					notifyInvalidMail(client);
				}
				Thread.sleep(timeToWaitBetweenValidation);
			}
		}
		setMailToCheck(false);
	}

	@Override
	public void run() {
		while (true) {
			if (mailToCheck) {
				try {
					checkInvalidMails();
				} catch (InterruptedException | PersistenceServiceException | PersistenceInternalException exception) {
					Logger.getGlobal().log(Level.WARNING, exception.getMessage());
				}
			} else {
				synchronized (invalidMails) {
					try {
						invalidMails.wait();
					} catch (InterruptedException exception) {
						Logger.getGlobal().log(Level.WARNING, exception.getMessage());
					}
				}
			}
		}
	}
}
