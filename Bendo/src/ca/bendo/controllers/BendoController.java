/**
 * 
 */
package ca.bendo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;

import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>BendoController</b>
 *          <p>
 *          Load
 *          </p>
 * 
 * 
 */
public class BendoController
{

	/**
	 * UserSession.
	 */
	private UserSession userSession;

	/**
	 * Translator.
	 */
	private Translator translator;

	/**
	 * Initialise object from the request.
	 * 
	 * @param request
	 *            Request
	 */
	@ModelAttribute
	public final void init(final HttpServletRequest request)
	{
		this.translator = (Translator) request.getAttribute("translator");
		this.userSession = (UserSession) request.getAttribute("userSession");
	}

	/**
	 * Getter.
	 * 
	 * @return Usersession
	 */
	public final UserSession getUserSession()
	{
		return userSession;
	}

	/**
	 * Setter.
	 * 
	 * @param userSession
	 *            UserSession
	 */
	public final void setUserSession(final UserSession userSession)
	{
		this.userSession = userSession;
	}

	/**
	 * Getter.
	 * 
	 * @return Translator object
	 */
	public final Translator getTranslator()
	{
		return translator;
	}

	/**
	 * Setter.
	 * 
	 * @param translator
	 *            Translator oject
	 */
	public final void setTranslator(final Translator translator)
	{
		this.translator = translator;
	}
}
