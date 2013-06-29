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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.controller.handler.geolocation.GeolocationReviewHandler;
import ca.bendo.form.entity.geolocation.GeolocationReviewForm;

/**
 * @author Timoth�e Gu�rin
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
	 * @return 1 if the username is available and 0 if not
	 */
	@RequestMapping(value = "/location/load", method = RequestMethod.GET)
	@ResponseBody
	public String checkEmailAvailable()
	{
		return "[new google.maps.LatLng(37.782, -122.447), new google.maps.LatLng(37.782, -122.445)]";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@RequestMapping(value = "/location/review", method = RequestMethod.GET)
	public String newQuestion(final HttpServletRequest request)
	{
		return newGeolocationReviewPage(request, new GeolocationReviewForm());
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
			for (ObjectError error : result.getAllErrors())
			{
				System.out.println("ERROR: " + error.getObjectName() + " | " + error.toString() + " | "
						+ error.getDefaultMessage());
			}
			System.out.println("Location Fail : " + reviewForm.getLocation());
			return newGeolocationReviewPage(request, reviewForm);
		} else
		{
			System.out.println("Location: " + reviewForm.getLocation().toPoint());
			handler.handleNewReview(request, reviewForm);
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
		handler.setupNewReviewPage(request, reviewForm);

		return "views/userLocationRatingMap";
	}
}
