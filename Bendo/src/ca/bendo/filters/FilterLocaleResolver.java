/**
 * 
 */
package ca.bendo.filters;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

import ca.bendo.db.entity.lang.Language;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FilterLocaleResolver</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FilterLocaleResolver implements LocaleResolver
{

	/**
	 * 
	 */
	private static final Locale DEFAULT_LOCALE = new Locale("en");

	@Override
	public Locale resolveLocale(final HttpServletRequest request)
	{

		Locale locale = (Locale) Language.getLocale(request);
		System.out.println("Resolve locale: " + Language.load(request).getKey() + " " + locale);
		if (locale != null)
		{
			return locale;
		} else
		{
			return DEFAULT_LOCALE;
		}

	}

	@Override
	public void setLocale(final HttpServletRequest request, final HttpServletResponse response, final Locale locale)
	{
		request.setAttribute("language.LOCALE", locale);
	}
}