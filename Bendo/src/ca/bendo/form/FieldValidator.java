/**
 * 
 */
package ca.bendo.form;

import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FormValidator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class FieldValidator
{
	/**
	 * 
	 */
	public static final String CAPTCHA_PUBLIC = "6LeI-N4SAAAAAD0IhxtwQlHIGV1FGmcEfkrW08RY";

	/**
	 * 
	 */
	public static final String CAPTCHA_PRIVATE = "6LeI-N4SAAAAAHQHiisQDI-Xxn0WyZswpObbisz3";

	/**
	 * 
	 */
	public static final String NAME_REGEX = "^[^0-9*/+&$£]+$";

	/**
	 * 
	 */
	public static final String CODE_REGEX = "^[a-zA-Z0-9]+$";

	/**
	 * 
	 */
	public static final String PASSWORD_REGEX = "((?=.*\\d)" + ".{6,})";
	/**
	 * 
	 */
	public static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*"
			+ "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * 
	 */
	public static final String ALPHANUMERIC_REGEX = "^[a-zA-Z0-9 _-]+$";

	/**
	 * 
	 */
	public static final int COMMENT_MIN_LEN = 0;

	/**
	 * 
	 */
	public static final int COMMENT_MAX_LEN = 500;

	/**
	 * Prevent instantiation.
	 */
	private FieldValidator()
	{

	}

	/**
	 * 
	 * @param str
	 *            String to test
	 * @return boolean if the given string contains some characters
	 */
	public static boolean isEmpty(final String str)
	{
		return !(str != null && str.length() > 0);
	}

	/**
	 * 
	 * @param str
	 *            String to test
	 * @param min
	 *            Minium size of the string
	 * @param max
	 *            Maximum size of the string
	 * @return Retrun if the given string lenght is between the min and maximum
	 */
	public static boolean between(final String str, final int min, final int max)
	{
		return str.length() >= min && str.length() <= max;
	}

	/**
	 * 
	 * @param name
	 *            Name
	 * @return boolean if the given string is in a name format
	 */
	public static boolean isName(final String name)
	{
		return !isEmpty(name) && name.matches(NAME_REGEX);
	}

	/**
	 * 
	 * @param name
	 *            Name
	 * @return boolean if the given string is in a name format
	 */
	public static boolean isInt(final String name)
	{
		try
		{
			int temp = Integer.parseInt(name);
			return true;
		} catch (NumberFormatException e)
		{
			return false;
		}
	}

	/**
	 * @param commentStr
	 *            Comment string to check
	 * @return if the given string match the comment regex
	 */
	public static boolean isComment(final String commentStr)
	{
		return !isEmpty(commentStr) && between(commentStr, COMMENT_MIN_LEN, COMMENT_MAX_LEN);
	}

	/**
	 * 
	 * @param password
	 *            Password input
	 * @param passwordCheck
	 *            Password verification input
	 * @return Boolean if the two password match the requirement and are the
	 *         same.
	 */
	public static boolean isPasswords(final String password, final String passwordCheck)
	{
		return isPassword(password) && password.equals(passwordCheck);
	}

	/**
	 * 
	 * @param password
	 *            Password string to test
	 * @return boolean if the given String match the password regex
	 */
	public static boolean isPassword(final String password)
	{
		return !isEmpty(password) && password.matches(PASSWORD_REGEX);
	}

	/**
	 * @param email
	 *            string to test
	 * @return boolean if the given string is an email address
	 */
	public static boolean isEmail(final String email)
	{
		return !isEmpty(email) && email.matches(EMAIL_REGEX);
	}

	/**
	 * @param value
	 *            Value to test
	 * @return boolean if the value contains the good format
	 */
	public static boolean isAlphaNumeric(final String value)
	{
		return !isEmpty(value) && value.matches(ALPHANUMERIC_REGEX);
	}

	/**
	 * @param code
	 *            string to test
	 * @return boolean if the given string is an code address
	 */
	public static boolean isCode(final String code)
	{
		return !isEmpty(code) && code.matches(CODE_REGEX);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return Captcha valid
	 */
	public static boolean checkCaptcha(final HttpServletRequest request)
	{
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey(CAPTCHA_PRIVATE);

		String challenge = request.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

		return reCaptchaResponse.isValid();

	}

}
