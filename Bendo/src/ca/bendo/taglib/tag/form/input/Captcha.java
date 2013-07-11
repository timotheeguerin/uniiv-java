/**
 * 
 */
package ca.bendo.taglib.tag.form.input;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;
import ca.bendo.form.FieldValidator;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Captcha</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Captcha extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1458371679419232712L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException
	{

		// Get the writer object for output.
		JspWriter out = pageContext.getOut();

		Translator translator = (Translator) pageContext.getRequest().getAttribute("translator");
		Long languageId = (Long) pageContext.getRequest().getAttribute("languageId");

		ReCaptcha captcha = ReCaptchaFactory.newReCaptcha(FieldValidator.CAPTCHA_PUBLIC,
				FieldValidator.CAPTCHA_PRIVATE, false);

		StringBuilder result = new StringBuilder();
		result.append("<div class='recaptcha'>");
		result.append("<label>" + translator.translate("captcha", languageId) + "</label>");
		Properties options = new Properties();
		options.setProperty("theme", "white");
		result.append("<div class='recaptcha_box'>");
		result.append(captcha.createRecaptchaHtml("You did not type the captcha correctly", options));
		result.append("</div></div>");
		try
		{
			out.println(result);
		} catch (IOException e)
		{
			//
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
