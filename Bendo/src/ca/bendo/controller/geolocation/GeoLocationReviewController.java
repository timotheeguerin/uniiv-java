/**
 * 
 */
package ca.bendo.controller.geolocation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.controller.handler.geolocation.GeolocationReviewHandler;
import ca.bendo.form.entity.geolocation.GeolocationReviewForm;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>GeoLocationReviewController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class GeoLocationReviewController
{
	/**
	 * 
	 */
	@Autowired
	private GeolocationReviewHandler handler;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param univeristyId
	 *            UniversityId
	 * @return jsp page
	 */
	@RequestMapping(value = "/university/{universityId}/location/stats", method = RequestMethod.GET)
	public String displayUniversityLocationStats(final HttpServletRequest request, @PathVariable(
			value = "universityId") final long univeristyId)
	{
		if (handler.setupStatPage(request, univeristyId))
		{
			return "views/university/location/displayLivingStats";
		} else
		{
			return "views/errors/error404";
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param univeristyId
	 *            UniversityId
	 * @return jsp page
	 */
	@RequestMapping(value = "/university/{universityId}/location/review", method = RequestMethod.GET)
	public String newQuestion(final HttpServletRequest request,
			@PathVariable(value = "universityId") final long univeristyId)
	{
		return newGeolocationReviewPage(request, new GeolocationReviewForm(), univeristyId);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * 
	 * @param reviewForm
	 *            Question form entity
	 * @param univeristyId
	 *            UniversityId
	 * @param result
	 *            contain error of the form
	 * @return jsp page
	 */

	@RequestMapping(value = "/university/{universityId}/location/review", method = RequestMethod.POST)
	public String handleNewQuestion(final HttpServletRequest request, @Valid final GeolocationReviewForm reviewForm,
			final BindingResult result, @PathVariable(value = "universityId") final long univeristyId)
	{
		if (result.hasErrors())
		{
			return newGeolocationReviewPage(request, reviewForm, univeristyId);
		} else
		{
			System.out.println("Location: " + reviewForm.getLocation().toPoint());
			handler.handleNewReview(request, reviewForm, univeristyId);
			return "redirect:";
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param reviewForm
	 *            review Form
	 * @param univeristyId
	 *            UniversityId
	 * @return jsp page
	 */
	public String newGeolocationReviewPage(final HttpServletRequest request, final GeolocationReviewForm reviewForm,
			final long univeristyId)
	{
		if (handler.setupNewReviewPage(request, reviewForm, univeristyId))
		{
			return "views/userLocationRatingMap";
		} else
		{
			return "views/errors/error404";
		}
	}
}
