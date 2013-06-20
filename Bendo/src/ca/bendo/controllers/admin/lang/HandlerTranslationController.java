/**
 * 
 */
package ca.bendo.controllers.admin.lang;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.db.dao.lang.TranslationsDAO;
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
public class HandlerTranslationController
{
	/**
	 * 
	 */
	@Autowired
	private TranslationsDAO translationDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @return Jsp page
	 */
	@RequestMapping(value = "/admin/translation/list", method = RequestMethod.GET)
	@Transactional
	public String displayGroupTypeList(final HttpServletRequest request)
	{
		TableForm form = new TableForm();
		form.load(request);
		
		
		//List<Translation> translations = translationDAO.search(form.getQuery(), form.getFirstResult(), form.getResultPerPage());
		List<Translation> translations = translationDAO.search(form.getQuery(), 0, Integer.MAX_VALUE);
		request.setAttribute("translations", translations);
		int pageNum = (int) translationDAO.searchCount(form.getQuery()) / form.getResultPerPage() + 1;
		
		request.setAttribute("tableUtils", new FilterForm(form.getPage(), pageNum, form.getQuery()));
		
		return "views/admin/translation/list";
	}
}
