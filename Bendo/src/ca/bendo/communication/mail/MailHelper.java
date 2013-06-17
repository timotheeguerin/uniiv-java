package ca.bendo.communication.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

/**
 * 
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>MailHelper</b>
 *          <p>
 *          Helper function to send email
 *          </p>
 * 
 * 
 */
public class MailHelper
{

	/**
	 * Properties for the message.
	 */
	private Properties props;

	/**
	 * Logger.
	 */
	private Logger log = Logger.getLogger(MailHelper.class);

	/**
	 * Sender email.
	 */
	private String senderEmail = "contact@uniiv.com";

	/**
	 * Default constructor.
	 */
	public MailHelper()
	{
		this(null);
	}

	/**
	 * Constructor allowing overriding default properties with given ones.
	 * 
	 * @param props
	 *            a Properties object with values to override. Property
	 *            currently taken into account: mail.smtp.host (default:
	 *            smtp.fr.devoteam.com)
	 * @param log
	 */
	public MailHelper(final Properties props)
	{
		// setSenderEmail(BendoConfig.getConfig().getDefaultEmail());
		if (props == null)
		{
			this.props = new Properties();
			this.props.put("mail.smtp.host", "smtpout.secureserver.net");
			this.props.put("mail.transport.protocol", "smtp");
			this.props.put("mail.smtp.auth", "true");
			this.props.put("mail.smtp.port", "25");
		} else
		{
			this.props = props;
		}
	}

	/**
	 * Sends an email to given recipients with the given subject and message.
	 * 
	 * @param recipients
	 *            a semicolon-separated list of mail addresses
	 * @param subject
	 *            the subject of the mail
	 * @param message
	 *            the message to send
	 */
	public void send(final String recipients, final String subject, final String message)
	{
		if (recipients == null || subject == null || message == null)
		{
			log.warn("recipients: " + recipients + ", subject: " + subject);
			String warn = "Missing recipients (" + recipients + "), subject (" + subject
					+ ") or message - email not sent";
			log.warn(warn);
			throw new IllegalArgumentException(warn);
		}
		try
		{
			// Session session = Session.getDefaultInstance(props);

			Session session = Session.getInstance(props, new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication("contact@uniiv.com", "pr9pHuyeheVabRamaCEc");
				}
			});

			// session.setDebug(true);
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(getSenderEmail()));
			String[] ia = recipients.replaceAll("\\s", "").split(";");
			List<InternetAddress> addressTo = new ArrayList<InternetAddress>();
			for (String s : ia)
			{
				addressTo.add(new InternetAddress(s));
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo.toArray(new InternetAddress[addressTo.size()]));
			msg.setSubject(subject);
			msg.setContent(new String(message.getBytes(), "UTF-8"), "text/html ");
			msg.saveChanges();
			Transport.send(msg);
			log.info("message \"" + subject + "\" sent to " + recipients);
		} catch (Exception e)
		{
			log.warn("Exception while sending message: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Sends an email to given recipients with the given subject and message and
	 * the joined file.
	 * 
	 * @param recipients
	 *            a semicolon-separated list of mail addresses
	 * @param subject
	 *            the subject of the mail
	 * @param message
	 *            the message to send
	 * @param filename
	 *            the name of the file to be joined
	 */
	public void send(final String recipients, final String subject, final String message, final String filename)
	{
		if (recipients == null || subject == null || message == null)
		{
			log.warn("recipients: " + recipients + ", subject: " + subject);
			String warn = "Missing recipients (" + recipients + "), subject (" + subject
					+ ") or message - email not sent";
			log.warn(warn);
			throw new IllegalArgumentException(warn);
		}
		try
		{
			Session session = Session.getInstance(props, new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication("contact.bendo", "madremia350");
				}
			});
			// session.setDebug(true);
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(getSenderEmail()));
			String[] ia = recipients.replaceAll("\\s", "").split(";");
			List<InternetAddress> addressTo = new ArrayList<InternetAddress>();
			for (String s : ia)
			{
				addressTo.add(new InternetAddress(s));
			}

			msg.setRecipients(Message.RecipientType.TO, addressTo.toArray(new InternetAddress[addressTo.size()]));
			msg.setSubject(subject);

			MimeBodyPart mainBody = new MimeBodyPart();
			mainBody.setContent(new String(message.getBytes(), "UTF-8"), "text/html");

			final Multipart mp = new MimeMultipart();
			mp.addBodyPart(mainBody);
			msg.setContent(mp);
			MimeBodyPart mbp2 = new MimeBodyPart();

			if (!filename.trim().equals(""))
			{
				// attach the file to the message
				FileDataSource fds = new FileDataSource(filename);
				mbp2.setDataHandler(new DataHandler(fds));
				mbp2.setFileName(fds.getName());
				mp.addBodyPart(mbp2);
			}

			msg.saveChanges();
			Transport.send(msg);

			log.info("message \"" + subject + "\" sent to " + recipients + "\" attached file  " + filename);
		} catch (Exception e)
		{
			e.printStackTrace();
			log.warn("Exception while sending message: " + e.getMessage());
		}
	}

	/**
	 * Sends an email to given recipients with the given subject, message and
	 * joined files.
	 * 
	 * @param recipients
	 *            a semicolon-separated list of mail addresses
	 * @param subject
	 *            the subject of the mail
	 * @param message
	 *            the message to send
	 * @param filesnames
	 *            names of the file to be joined
	 */
	public void send(final String recipients, final String subject, final String message,
			final List<String> filesnames)
	{
		if (recipients == null || subject == null || message == null)
		{
			log.warn("recipients: " + recipients + ", subject: " + subject);
			String warn = "Missing recipients (" + recipients + "), subject (" + subject
					+ ") or message - email not sent";
			log.warn(warn);
			throw new IllegalArgumentException(warn);
		}
		try
		{
			Session session = Session.getInstance(props, new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication("contact.bendo", "madremia350");
				}
			});
			// session.setDebug(true);
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(getSenderEmail()));
			String[] ia = recipients.replaceAll("\\s", "").split(";");
			List<InternetAddress> addressTo = new ArrayList<InternetAddress>();
			for (String s : ia)
			{
				addressTo.add(new InternetAddress(s));
			}

			msg.setRecipients(Message.RecipientType.TO, addressTo.toArray(new InternetAddress[addressTo.size()]));
			msg.setSubject(subject);

			MimeBodyPart mainBody = new MimeBodyPart();
			mainBody.setContent(new String(message.getBytes(), "UTF-8"), "text/html");

			final Multipart mp = new MimeMultipart();
			mp.addBodyPart(mainBody);
			msg.setContent(mp);

			StringBuffer lisetFile = new StringBuffer();

			for (String fileName : filesnames)
			{
				// attach the file to the message
				MimeBodyPart mbp2 = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(fileName);
				mbp2.setDataHandler(new DataHandler(fds));
				mbp2.setFileName(fds.getName());
				mp.addBodyPart(mbp2);
				lisetFile.append(fileName + "-");
			}

			msg.saveChanges();
			Transport.send(msg);

			log.info("message \"" + subject + "\" sent to " + recipients + "\" attached file  " + lisetFile.toString());
		} catch (Exception e)
		{
			e.printStackTrace();
			log.warn("Exception while sending message: " + e.getMessage());
		}
	}

	/**
	 * @return the senderEmail
	 * 
	 */
	public String getSenderEmail()
	{
		return senderEmail;
	}

	/**
	 * @param senderEmail
	 *            the senderEmail to set
	 * 
	 */
	public void setSenderEmail(final String senderEmail)
	{
		this.senderEmail = senderEmail;
	}
}
