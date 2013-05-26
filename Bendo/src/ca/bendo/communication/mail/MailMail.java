/**
 * 
 */
package ca.bendo.communication.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>MailMail</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
public class MailMail
{
	/**
	 * 
	 */
	@Autowired
	private MailSender mailSender;

	/**
	 * 
	 * @param from
	 *            From
	 * @param to
	 *            To
	 * @param subject
	 *            Subject
	 * @param msg
	 *            Message
	 */
	public void sendMail(final String from, final String to, final String subject, final String msg)
	{

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}
}