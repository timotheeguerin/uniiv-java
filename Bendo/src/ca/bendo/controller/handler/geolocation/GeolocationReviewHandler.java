/**
 * 
 */
package ca.bendo.controller.handler.geolocation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.geolocation.GeolocationRatingCriteriaDAO;
import ca.bendo.db.entity.geolocation.GeolocationRatingCriteria;
import ca.bendo.form.entity.RatingEntity;
import ca.bendo.form.entity.geolocation.GeolocationReviewForm;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>GeolocationReviewHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class GeolocationReviewHandler
{

	/**
	 * 
	 */
	@Autowired
	private GeolocationRatingCriteriaDAO criteriaDAO;

	/**
	 * 
	 * @param request
	 *            Request
	 * @param reviewForm
	 *            Form
	 */
	public void setupNewReviewPage(final HttpServletRequest request, final GeolocationReviewForm reviewForm)
	{
		List<GeolocationRatingCriteria> criterias = criteriaDAO.list();
		request.setAttribute("geolocationReviewCriteria", criterias);

		if (reviewForm.getRatings() == null)
		{
			reviewForm.setRatings(new ArrayList<RatingEntity>());
		}

		for (int i = reviewForm.getRatings().size(); i < criterias.size(); i++)
		{
			reviewForm.getRatings().add(new RatingEntity());
		}
		request.setAttribute("geolocationReviewForm", reviewForm);
	}
}
