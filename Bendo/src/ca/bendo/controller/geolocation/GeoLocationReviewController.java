/**
 * 
 */
package ca.bendo.controller.geolocation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.form.entity.RatingEntity;
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
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/location/review", method = RequestMethod.GET)
	public String newQuestion(final HttpServletRequest request)
	{
		GeolocationReviewForm form = new GeolocationReviewForm();
		form.getRatings().add(new RatingEntity());
		form.getRatings().add(new RatingEntity());
		return newGeolocationReviewPage(request, form);
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * 
	 * @param reviewForm
	 *            Question form entity
	 * @param result
	 *            contain error of the form
	 * @return jsp page
	 */
	@RequestMapping(value = "/location/review", method = RequestMethod.POST)
	public String handleNewQuestion(final HttpServletRequest request, @Valid final GeolocationReviewForm reviewForm,
			final BindingResult result)
	{
		if (result.hasErrors())
		{
			return newGeolocationReviewPage(request, reviewForm);
		} else
		{
			// /newGeolocationReview.handleNewQuestion(request, questionForm);
			return "redirect:";
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param reviewForm
	 *            review Form
	 * 
	 * @return jsp page
	 */
	public String newGeolocationReviewPage(final HttpServletRequest request, final GeolocationReviewForm reviewForm)
	{
		request.setAttribute("newGeolocationReviewForm", reviewForm);
		Integer[] array = { 1, 2, 3, 4, 5 };
		request.setAttribute("ratingItems", array);
		return "views/userLocationRatingMap";
	}
}
