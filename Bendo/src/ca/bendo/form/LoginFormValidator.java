/**
 * 
 */
package ca.bendo.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LoginFormValidator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
public class LoginFormValidator extends FormValidator
{

	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(LoginFormValidator.class);

	/**
	 * DAO to connect to the user table.
	 */


	/**
	 * 
	 */
	public LoginFormValidator()
	{
		// 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.bendo.form.FormValidator#validate(javax.servlet.http.HttpServletRequest
	 * )
	 */
	@Override
	public boolean validate(final HttpServletRequest request)
	{

		setRequest(request);
		if (getRequest().getParameter("submit_login_check") != null
				&& getRequest().getParameter("submit_login_check") != "null")
		{

			String username = getRequest().getParameter("username");
			String password = getRequest().getParameter("password");
			boolean validate = checkLogin(username, password);

			return validate;
		} else
		{
			return false;
		}
	}

	/**
	 * Check to login information send by user.
	 * 
	 * @param username
	 *            Username sent by user
	 * @param password
	 *            Password sent by user
	 * @return Boolean if the login information are valid
	 */
	private boolean checkLogin(final String username, final String password)
	{

//		Member tmpUser = getUserDao().authentificate(username, password);
//		if (tmpUser == null)
//		{
//			return false;
//		} else
//		{
//			setUser(tmpUser);
//			return true;
//		}
		
		return false;
	}


}
