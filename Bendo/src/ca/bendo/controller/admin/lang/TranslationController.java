/**
 * 
 */
package ca.bendo.controller.admin.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.db.dao.lang.LanguageDAO;
import ca.bendo.db.dao.lang.TranslationsDAO;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.lang.Translation;
import ca.bendo.form.entity.TableForm;
import ca.bendo.views.table.FilterForm;

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
public class TranslationController
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
	@Secured("admin")
	@RequestMapping(value = "/admin/translation/list", method = RequestMethod.GET)
	@Transactional
	public String list(final HttpServletRequest request)
	{
		TableForm form = new TableForm();
		form.load(request);

		// List<Translation> translations =
		// translationDAO.search(form.getQuery(), form.getFirstResult(),
		// form.getResultPerPage());
		List<String> translations = translationDAO.search(form.getQuery(), 0, Integer.MAX_VALUE);
		List<Integer> transints = new ArrayList<Integer>();
		Map<String, Integer> trans = new HashMap<String,Integer>();
		for(String s: translations)
		{
			transints.add(translationDAO.getNonNullTranslationsWithKey(s).size());
		}
		for(int i = 0; i < translations.size(); i++)
		{
			trans.put(translations.get(i), transints.get(i));
		}
		request.setAttribute("transmap", trans);
		request.setAttribute("translations", translations);
		int pageNum = (int) translationDAO.searchCount(form.getQuery()) / form.getResultPerPage() + 1;

		request.setAttribute("tableUtils", new FilterForm(form.getPage(), pageNum, form.getQuery()));

		return "views/admin/translation/list";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@RequestMapping(value = "/admin/translation/view", method = RequestMethod.GET)
	public String view(final HttpServletRequest request)
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

	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@Transactional
	@RequestMapping(value = "/admin/translation/edit", method = RequestMethod.GET)
	public String edit(final HttpServletRequest request)
	{
		TableForm form = new TableForm();
		form.load(request);

		for (Language language : languageDAO.listLanguages())
		{
			Translation t = translationDAO.getTranslation(request.getParameter("key"), language.getId());
			if (t == null)
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

	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@RequestMapping(value = "/admin/translation/", method = RequestMethod.GET)
	public String index(final HttpServletRequest request)
	{
		return "views/admin/translation/index";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@RequestMapping(value = "/admin/translation/add", method = RequestMethod.GET)
	public String add(final HttpServletRequest request)
	{
		return "views/admin/translation/add";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@Secured("admin")
	@Transactional
	@RequestMapping(value = "/admin/translation/insert", method = RequestMethod.GET)
	public String insert(final HttpServletRequest request)
	{
		String key = request.getParameter("key");
		for (Language l : languageDAO.listLanguages())
		{
			Translation t = new Translation();
			t.setKey(key);
			t.setLanguage(l);
			t.setTranslation("");
			translationDAO.add(t);
		}
		return "redirect:view?query=" + key;
	}
}