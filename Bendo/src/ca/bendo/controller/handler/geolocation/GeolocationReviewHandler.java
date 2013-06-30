package ca.bendo.controller.handler.geolocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.geolocation.GeolocationRatingCriteriaDAO;
import ca.bendo.db.dao.geolocation.UserGeolocationRatingDAO;
import ca.bendo.db.dao.geolocation.UserGeolocationReviewDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.entity.geolocation.GeolocationRatingCriteria;
import ca.bendo.db.entity.geolocation.UserGeolocationRating;
import ca.bendo.db.entity.geolocation.UserGeolocationReview;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.university.University;
import ca.bendo.db.entity.user.User;
import ca.bendo.form.entity.FormItem;
import ca.bendo.form.entity.RatingEntity;
import ca.bendo.form.entity.geolocation.GeolocationReviewForm;
import ca.bendo.session.UserSession;

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
	private static final int STAR_RATING_5 = 5;

	/**
	 * 
	 */
	@Autowired
	private GeolocationRatingCriteriaDAO criteriaDAO;

	/**
	 * 
	 */
	@Autowired
	private UserGeolocationRatingDAO ratingDAO;

	/**
	 * 
	 */
	@Autowired
	private UserGeolocationReviewDAO reviewDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * @param request
	 *            Request
	 * @param reviewForm
	 *            Review Form
	 * @param universityId
	 *            {@link University}
	 */
	public void handleNewReview(final HttpServletRequest request, final GeolocationReviewForm reviewForm,
			final long universityId)
	{
		long languageId = Language.loadId(request);
		User user = UserSession.getSession(request).getUser();
		if (user == null)
		{
			return;
		}
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			System.out.println("UNIVERSITY NULL");
			return;
		}
		UserGeolocationReview review = new UserGeolocationReview();
		review.setLocation(reviewForm.getLocation().toPoint());
		review.setUser(user);
		reviewDAO.enableTranslation(languageId);
		reviewDAO.add(review);
		review.setUniversityId(universityId);
		for (Entry<String, RatingEntity> entry : reviewForm.getRatings().entrySet())
		{
			UserGeolocationRating rating = new UserGeolocationRating();
			rating.setReview(review);
			rating.setCriteria(criteriaDAO.getByName(entry.getKey()));
			rating.setValue(entry.getValue().getValue());
			ratingDAO.add(rating);
		}
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param reviewForm
	 *            Form
	 * @param universityId
	 *            universityId
	 * @return if the request was successful
	 */
	public boolean setupNewReviewPage(final HttpServletRequest request, final GeolocationReviewForm reviewForm,
			final long universityId)
	{
		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			return false;
		}
		List<GeolocationRatingCriteria> criterias = criteriaDAO.list();
		request.setAttribute("geolocationReviewCriteria", criterias);

		for (int i = reviewForm.getRatings().size(); i < criterias.size(); i++)
		{
			reviewForm.init(criterias.get(i).getName());
		}
		request.setAttribute("geolocationReviewForm", reviewForm);

		List<FormItem> items = new ArrayList<FormItem>();
		for (int i = 1; i <= STAR_RATING_5; i++)
		{
			items.add(new FormItem(String.valueOf(i), ""));
		}
		request.setAttribute("ratingItems", items);
		return true;
	}
}
