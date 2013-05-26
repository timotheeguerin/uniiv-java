/**
 * 
 */
package ca.bendo.controllers.university;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.alert.UserWarning;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.form.handler.university.UniversityReviewHandler;
import ca.bendo.session.UserSession;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityReview</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class UniversityReviewController
{
	/**
	 * 
	 */
	@Autowired
	private UniversityReviewHandler reviewHandler;

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @param universityId
	 *            University id
	 * @return Jsp page
	 */
	@RequestMapping(value = "/university/{uniId}/review/new", method = RequestMethod.GET)
	public final String universityReview(@PathVariable("uniId") final long universityId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		return newUniversityReviewPage(universityId, request, response);
	}

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @param universityId
	 *            University id
	 * 
	 * @return Jsp page
	 */
	@RequestMapping(value = "/university/{uniId}/review/new", method = RequestMethod.POST)
	public final String handleNewUniversityReview(@PathVariable("uniId") final long universityId,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		Translator translator = Translator.getTranslator(request);
		Long languageId = Language.load(request);
		if (UserSession.getSession(request).hasPermission("user"))
		{

			if (reviewHandler.handleNewUniversityReview(universityId, request))
			{
				String url = "/university/" + universityId;
				String param = "?alertmsg=alert_info_review_added";
				return "redirect:" + translator.translateUrl(url + param, languageId);
			} else
			{
				request.setAttribute("new_review_form_error", true);
			}
		}
		return newUniversityReviewPage(universityId, request, response);

	}

	/**
	 * Get the request after filling inputs and submit of login.
	 * 
	 * @param universityId
	 *            University id
	 * @param request
	 *            Request
	 * @param response
	 *            Response
	 * @return Jsp page
	 */
	public final String newUniversityReviewPage(final long universityId, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		UserWarning.needValidUser(request);
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);
		if (!reviewHandler.setupNewReviewPage(universityId, request))
		{
			return "redirect:" + translator.getLink("new_course", languageId) + "?err_no_university_with_id="
					+ universityId;
		} else
		{
			return "views/university/newUniversityReview";
		}
	}

}
