/**
 * 
 */
package ca.bendo.controller.admin.lang;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.dao.lang.LanguageDAO;
import ca.bendo.db.dao.lang.TranslationsDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.lang.Translation;
import ca.bendo.form.entity.TableForm;

/**
 * @author TLWR
 * @version Bendo
 * 
 *          <b>HandleGroupTypeController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class HandlerViewTranslationController
{
	/**
	 * 
	 */
	@Autowired
	private TranslationsDAO translationDAO;
	/**
	 * 
	 */
	@Autowired
	private LanguageDAO languageDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@RequestMapping(value = "/admin/translation/viewTranslation", method = RequestMethod.GET)
	public String displayGroupTypeList(final HttpServletRequest request)
	{
		TableForm form = new TableForm();
		form.load(request);
		
		request.setAttribute("key", form.getQuery());
		
		Map<Long, Translation> translations = translationDAO.getTranslationsWithKey(form.getQuery());
		request.setAttribute("translations", translations);
		
		List<Language> languages = languageDAO.listLanguages();
		request.setAttribute("languages", languages);
		
		return "views/admin/translation/show";
	}
}
