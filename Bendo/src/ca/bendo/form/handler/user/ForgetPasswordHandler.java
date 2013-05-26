/**
 * 
 */
package ca.bendo.form.handler.user;

import java.io.StringWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.communication.mail.MailHelper;
import ca.bendo.config.BendoConfig;
import ca.bendo.db.dao.user.UserDAO;
import ca.bendo.db.dao.user.UserResetPasswordDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.user.User;
import ca.bendo.db.entity.user.UserResetPassword;
import ca.bendo.form.FormErrorHandler;
import ca.bendo.form.entity.user.InputEmailEntity;
import ca.bendo.form.entity.user.ResetPasswordNew;
import ca.bendo.translation.translation.Translator;
import ca.bendo.user.element.HashedPassword;
import ca.bendo.utils.url.UrlFactory;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForgetPasswordHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class ForgetPasswordHandler
{
	/**
	 * 
	 */
	private static final int RESET_PASSWORD_KEY_LENGHT = 128;
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;
	/**
	 * 
	 */
	@Autowired
	private UserResetPasswordDAO userResetPasswordDAO;

	/**
	 * Resend an email to reset the password.
	 * 
	 * @param request
	 *            Request
	 * @return if the form was succesfuly handle
	 */
	public boolean handleSendEmail(final HttpServletRequest request)
	{
		InputEmailEntity entity = new InputEmailEntity();
		entity.setup(request);

		if (!entity.isValid())
		{
			entity.setupErrorsDisplay(request);
			entity.setupForDisplay(request);
			request.setAttribute("inputEmailEntity", entity);
			return false;
		}

		User user = userDAO.getByEmail(entity.getEmail());
		if (user == null)
		{
			FormErrorHandler.getFormErrorHandler(request).addError(InputEmailEntity.class,
					"form_err_no_user_with_email");
			return false;
		}
		UserResetPassword userResetPassword = new UserResetPassword();
		userResetPassword.setUser(user);
		String key = RandomStringUtils.randomAlphanumeric(RESET_PASSWORD_KEY_LENGHT);
		userResetPassword.setKey(key);
		userResetPassword.setDateExpired(DateUtils.addDays(new Date(), 1));
		userResetPasswordDAO.add(userResetPassword);

		sendEmail(request, userResetPassword);
		return true;

	}

	/**
	 * @param request
	 *            Request
	 * 
	 * @param userResetPassword
	 *            UserResetPassword
	 */
	public void sendEmail(final HttpServletRequest request, final UserResetPassword userResetPassword)
	{
		long languageId = Language.load(request);
		Translator translator = Translator.getTranslator(request);
		/* next, get the Template */
		Template t = Velocity.getTemplate("email/reset_password.vm");

		/* create a context and add data */
		VelocityContext context = new VelocityContext();

		context.put("key", userResetPassword.getKey());
		context.put("user", userResetPassword.getUser());

		String param = "?id=" + userResetPassword.getId() + "&key=" + userResetPassword.getKey();

		String url = BendoConfig.getBaseUrl(request)
				+ UrlFactory.getUrl(translator.translateUrl("/resetpassword", languageId), request);
		context.put("url", url + param);

		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		String subject = translator.translate("signup_email_subject", languageId);
		MailHelper mail = new MailHelper();
		mail.send(userResetPassword.getUser().getEmail(), subject, writer.toString());
	}

	/**
	 * @param request
	 *            Request
	 * @return boolean if the new password reset was succesful
	 */
	public boolean handleNewPassword(final HttpServletRequest request)
	{
		ResetPasswordNew entity = new ResetPasswordNew();
		entity.setup(request);

		if (!entity.isValid())
		{
			entity.setupErrorsDisplay(request);
			entity.setupForDisplay(request);
			request.setAttribute("resetPasswordNew", entity);
			return false;
		}

		UserResetPassword resetEntity = userResetPasswordDAO.isValid(Long.parseLong(entity.getId()), entity.getKey());
		if (resetEntity == null)
		{
			FormErrorHandler.getFormErrorHandler(request).addError(ResetPasswordNew.class,
					"form_err_reset_password_invalid");
			return false;
		}

		resetEntity.getUser().setPassword(new HashedPassword(entity.getPassword()));
		userResetPasswordDAO.delete(resetEntity.getId());
		return true;
	}
}
