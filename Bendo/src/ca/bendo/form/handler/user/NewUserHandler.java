/**
 * 
 */
package ca.bendo.form.handler.user;

import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.communication.mail.MailHelper;
import ca.bendo.config.BendoConfig;
import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.UserEmailDAO;
import ca.bendo.db.dao.user.UserPermissionDAO;
import ca.bendo.db.dao.user.UserStateDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserEmail;
import ca.bendo.db.entity.user.UserEmailConfirmation;
import ca.bendo.db.entity.user.UserPermission;
import ca.bendo.db.entity.user.UserState;
import ca.bendo.form.entity.user.SignupForm;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;
import ca.bendo.user.ConfirmationHandler;
import ca.bendo.utils.url.UrlFactory;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>NewUserHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class NewUserHandler
{
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 */
	@Autowired
	private UserStateDAO userStateDAO;

	/**
	 * 
	 */
	@Autowired
	private ConfirmationHandler confirmationHandler;

	/**
	 * 
	 */
	@Autowired
	private UserPermissionDAO permissionDAO;

	/**
	 * 
	 */
	@Autowired
	private UserEmailDAO userEmailDAO;

	/**
	 * 
	 */
	@Autowired
	private Translator translator;

	/**
	 * 
	 * @param request
	 *            request
	 * 
	 * @param signupForm
	 *            Signup Form
	 * @return boolean
	 */
	public boolean handle(final HttpServletRequest request, final SignupForm signupForm)
	{

		UserState state = userStateDAO.getByState("wait_email_confirmation");
		User user = new User(signupForm, state);

		UserPermission waitEmailPermission = permissionDAO.getByName("wait_email_confirmation");
		user.addPermission(waitEmailPermission);
		userDAO.add(user);

		UserEmail userEmail = new UserEmail();
		userEmail.setUser(user);
		userEmail.setValidated(false);
		userEmail.setEmail(signupForm.getEmail());
		userEmail.setDefaultEmail(true);
		userEmailDAO.add(userEmail);

		UserEmailConfirmation confirmation = confirmationHandler.createEmailConfirmation(userEmail);
		sendConfirmationEmail(request, confirmation);
		UserSession.getSession(request).login(user);
		return true;
	}

	/**
	 * @param request
	 *            request
	 * 
	 * 
	 * @param confirmation
	 *            Confirmation
	 */
	private void sendConfirmationEmail(final HttpServletRequest request, final UserEmailConfirmation confirmation)
	{
		Long languageId = Language.loadId(request);
		/* next, get the Template */
		Template t = Velocity.getTemplate("email/signup_confirmation.vm");

		/* create a context and add data */
		VelocityContext context = new VelocityContext();
		context.put("id", confirmation.getId());
		context.put("key", confirmation.getKey());
		context.put("user", confirmation.getUserEmail().getEmail());

		String param = "?confirmationId=" + confirmation.getId() + "&key=" + confirmation.getKey();
		String url = BendoConfig.getBaseUrl(request)
				+ UrlFactory.getUrl(translator.getLink("wait_confirmation", languageId), request);
		context.put("url", url + param);

		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		String subject = translator.translate("signup_email_subject", languageId);
		MailHelper mail = new MailHelper();
		mail.send(confirmation.getUserEmail().getEmail(), subject, writer.toString());

	}

	/**
	 * @param email
	 *            Email to check
	 * @return email
	 */
	public boolean isEmailAvailable(final String email)
	{
		return userDAO.isEmailAvailable(email);
	}
}
