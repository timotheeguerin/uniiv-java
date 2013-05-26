package ca.bendo.filters;

import java.io.IOException;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.bendo.db.dao.location.CountryDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.translation.RequestTranslator;
import ca.bendo.translation.translation.Translator;
import ca.bendo.translation.url.UrlTranslator;

/**
 * 
 * <b> MultiLanguageFilter. </b>
 * <p>
 * Redirect the language specific url to the real one (ex: /fr/inscription &
 * /en/signup --> /signup)
 * </p>
 * 
 * 
 * @author Timothée Guérin
 * @version 0.1
 */
@Service
public class MultiLanguageFilter extends IFilter
{

	/**
	 * 
	 */
	@Autowired
	private CountryDAO countryDAO;

	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(MultiLanguageFilter.class);

	/**
	 * 
	 */
	@Autowired
	private UrlTranslator urlTrans;

	/**
	 * 
	 */
	@Autowired
	private Translator trans;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.filters.BendoFilter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(final FilterConfig fc) throws ServletException
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.bendo.filters.BendoFilter#doFilter(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.ServletResponse, java.lang.String)
	 */
	@Override
	public final String doFilter(final HttpServletRequest request, final ServletResponse response,
			final String currentUrl) throws IOException, ServletException
	{

		String url = currentUrl;
		// Needed for getting URL from request
		if (excludeFromFilter(url))
		{
			return url;
		} else
		{
			// UrlTranslator urlTrans = new UrlTranslator(url);
			urlTrans.parseUrl(url);

			Language lang = urlTrans.getLang();
			request.setAttribute("lang", lang);

			String uri = urlTrans.getUri();
			// Load the translations and send the translator to the controller
			request.setAttribute("translator", this.trans);
			request.setAttribute("languageId", lang.getId());
			RequestTranslator requestTranslator = new RequestTranslator();
			requestTranslator.setTranslator(this.trans);
			requestTranslator.setLanguage(lang);
			request.setAttribute("requestTranslator", requestTranslator);
			return uri;
		}
	}

	@Override
	public void destroy()
	{
	}
}