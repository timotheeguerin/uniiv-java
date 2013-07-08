/**
 * 
 */
package ca.bendo.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.controller.handler.user.EmailService;
import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.entity.user.EmailForm;
import ca.bendo.json.JsonQuery;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>EmailController</b> Handle all the request related to user -add
 *          -delete -set as default
 * 
 */
@Controller
public class EmailController
{
	/**
	 * 
	 */
	@Autowired
	private Translator translator;

	/**
	 * 
	 */
	@Autowired
	private EmailService service;

	/**
	 * 
	 * @param request
	 *            request
	 * @return jsp page
	 */
	@Secured("user")
	@RequestMapping(value = "/emails", method = RequestMethod.GET)
	public String listEmails(final HttpServletRequest request)
	{
		UserSession session = UserSession.getSession(request);
		request.setAttribute("emails", service.getUserEmails(session.getUser()));
		return "views/user/email/listemails";
	}

	/**
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return jsp page
	 */
	@Secured("user")
	@RequestMapping(value = "/email/add", method = RequestMethod.GET)
	public String addEmail(final HttpServletRequest request)
	{
		System.out.println("EMAIL ADD");
		request.setAttribute("emailForm", new EmailForm());
		return "views/user/email/inputemail";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param emailForm
	 *            Email form
	 * @param result
	 *            Result
	 * @return value
	 */
	@ResponseBody
	@RequestMapping(value = "/email/add/handle", method = RequestMethod.POST)
	public JsonQuery handleAddEmail(final HttpServletRequest request, @Valid final EmailForm emailForm,
			final BindingResult result)
	{
		long languageId = Language.loadId(request);
		UserSession session = UserSession.getSession(request);
		if (session.getUser() == null)
		{
			JsonQuery json = new JsonQuery();
			json.getErrors().add(translator.translate("error.login", languageId));
			return json;
		}

		if (result.hasErrors())
		{
			List<ObjectError> errors = result.getAllErrors();
			return new JsonQuery(errors);
		}
		service.addEmail(session.getUser(), emailForm);

		return new JsonQuery(translator.translate("email.added", languageId));
	}
}
