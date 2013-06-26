/**
 * 
 */
package ca.bendo.form;

import java.util.Locale;

import javax.validation.MessageInterpolator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import ca.bendo.db.dao.lang.LanguageDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TranslateMessageInterpolator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TranslateMessageInterpolator extends ResourceBundleMessageInterpolator implements MessageInterpolator,
		MessageSourceAware, InitializingBean
{
	/**
 * 
 */
	private MessageSource messageSource;

	/**
	 * 
	 */
	@Autowired
	private LanguageDAO languageDAO;

	/**
	 * 
	 */
	@Autowired
	private Translator translator;

	@Override
	public String interpolate(final String messageTemplate, final Context context)
	{
		return interpolate(messageTemplate, context, Locale.ENGLISH);
	}

	@Override
	public String interpolate(final String messageTemplate, final Context context, final Locale locale)
	{

		Language language = languageDAO.getByLocal(locale);
		String message = translator.translate(messageTemplate, language.getId());
		return super.interpolate(message, context, locale);
	}

	@Override
	public void setMessageSource(final MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		if (messageSource == null)
		{
			throw new IllegalStateException("MessageSource was not injected, could not initialize "
					+ this.getClass().getSimpleName());
		}
	}

}
