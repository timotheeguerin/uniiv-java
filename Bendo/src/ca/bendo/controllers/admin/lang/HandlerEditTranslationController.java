/**
 * 
 */
package ca.bendo.controllers.admin.lang;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
public class HandlerEditTranslationController
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
	//@Secured("admin")
	@RequestMapping(value = "/admin/translation/editTranslation", method = RequestMethod.GET)
	public String displayGroupTypeList(final HttpServletRequest request)
	{
		TableForm form = new TableForm();
		form.load(request);

		for(Language language: languageDAO.listLanguages())
		{
			Translation t = translationDAO.getTranslation(request.getParameter("key"),language.getId());
			if(t == null)
			{
				t = new Translation();
				t.setKey(request.getParameter("key"));
				t.setLanguage(language);
			}
			
			t.setTranslation(request.getParameter(Long.toString(language.getId())));
			
			translationDAO.saveOrUpdate(t);
		}
		
		return "views/admin/translation/edit";
	}
}
