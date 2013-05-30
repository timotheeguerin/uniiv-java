/**
 * 
 */
package ca.bendo.form.handler.university;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.language.UniversityLanguageDAO;
import ca.bendo.db.dao.rating.SoftRatingDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.dao.university.UniversityReviewDAO;
import ca.bendo.db.dao.university.UniversityReviewRatingDAO;
import ca.bendo.db.entity.comment.Comment;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.language.UniversityLanguage;
import ca.bendo.db.entity.rating.UniversityRating;
import ca.bendo.db.entity.university.University;
import ca.bendo.db.entity.university.UniversityReview;
import ca.bendo.db.entity.university.UniversityReviewRating;
import ca.bendo.form.FieldValidator;
import ca.bendo.form.comment.CommentHandler;
import ca.bendo.form.entity.university.NewUniversityReviewEntity;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityReviewHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class UniversityReviewHandler
{
	/**
 * 
 */
	@Autowired
	private SoftRatingDAO ratingTypeDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private CommentHandler commentHandler;

	/**
	 * 
	 */
	@Autowired
	private UniversityReviewDAO reviewDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityReviewRatingDAO ratingDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityLanguageDAO languageDAO;

	/**
	 * @param universityId
	 *            university id
	 * @param request
	 *            request
	 * @return form was succesfull
	 */
	public boolean handleNewUniversityReview(final long universityId, final HttpServletRequest request)
	{
		NewUniversityReviewEntity entity = new NewUniversityReviewEntity();
		entity.setup(request);

		// Load the ratings
		List<UniversityRating> types = ratingTypeDAO.listForReview();
		Map<UniversityRating, String> ratings = new HashMap<UniversityRating, String>();
		for (UniversityRating type : types)
		{
			String value = request.getParameter("rating_" + type.getId());
			ratings.put(type, value);

		}
		try
		{
			boolean result = newUniversityReview(universityId, ratings, entity, request);
			return result;
		} catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * @param entity
	 *            entity
	 * @param ratings
	 *            ratings
	 * @param universityId
	 *            university id
	 * @param request
	 *            request
	 * @return form was succesful
	 */
	private boolean newUniversityReview(final long universityId, final Map<UniversityRating, String> ratings,
			final NewUniversityReviewEntity entity, final HttpServletRequest request)
	{
		if (!entity.isValid())
		{
			entity.setupErrorsDisplay(request);
			entity.setupForDisplay(request);
			request.setAttribute("newUniversityReviewEntity", entity);
			System.out.println("INVALID ENTITY UNIVERSITY");
			return false;
		}

		for (Entry<UniversityRating, String> entry : ratings.entrySet())
		{
			if (!FieldValidator.isInt(entry.getValue()))
			{
				entity.setupForDisplay(request);
				request.setAttribute("newUniversityReviewEntity", entity);
			}
		}

		University university = universityDAO.getById(universityId);
		if (university == null) // Check if the professor exist
		{
			System.out.println("INVALID UNIVERSITY");
			return false;
		}

		Comment comment = commentHandler.newComment(entity.getComment(), Long.parseLong(entity.getLanguageId()));
		// Check the comment was successfully created
		if (comment == null)
		{
			System.out.println("COMMENT");
			return false;
		}
		System.out.println("WORK UNIVERSITY");

		UniversityReview review = new UniversityReview();
		review.setComment(comment);

		review.setUniversity(university);
		reviewDAO.add(review);

		for (Entry<UniversityRating, String> entry : ratings.entrySet())
		{
			if (FieldValidator.isInt(entry.getValue()))
			{
				int value = Integer.parseInt(entry.getValue());
				UniversityReviewRating rating = new UniversityReviewRating();
				rating.setType(entry.getKey());
				rating.setReview(review);
				rating.setValue(value);
				ratingDAO.add(rating);
			}
		}
		return true;
	}

	/**
	 * @param universityId
	 *            University id
	 * @param request
	 *            Request
	 * @return if the review was succesfully created
	 */
	public boolean setupNewReviewPage(final long universityId, final HttpServletRequest request)
	{

		request.getAttribute("translator");
		Long languageId = Language.loadId(request);
		universityDAO.setLanguageId(languageId);
		// reviewDAO.setLanguageId(languageId);
		// ratingTypeDAO.setLanguageId(languageId);
		// ratingDAO.setLanguageId(languageId);
		// languageDAO.setLanguageId(languageId);

		University university = universityDAO.getById(universityId);
		if (university == null)
		{
			System.out.println("Course doesn't exist");
			return false;
		}
		request.setAttribute("university", university);
		List<UniversityRating> types = ratingTypeDAO.listForReview();
		request.setAttribute("universityRatingType", types);

		List<UniversityLanguage> languages = languageDAO.list();
		request.setAttribute("languages", languages);

		return true;
	}

}
