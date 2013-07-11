/**
 * 
 */
package ca.bendo.form.handler.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.course.CourseDAO;
import ca.bendo.db.dao.course.CourseRatingDAO;
import ca.bendo.db.dao.course.CourseRatingTypeDAO;
import ca.bendo.db.dao.course.CourseReviewDAO;
import ca.bendo.db.dao.language.UniversityLanguageDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.entity.comment.Comment;
import ca.bendo.db.entity.course.Course;
import ca.bendo.db.entity.course.CourseRating;
import ca.bendo.db.entity.course.CourseRatingType;
import ca.bendo.db.entity.course.CourseReview;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.language.UniversityLanguage;
import ca.bendo.db.entity.university.University;
import ca.bendo.form.FieldValidator;
import ca.bendo.form.FormErrorHandler;
import ca.bendo.form.comment.CommentHandler;
import ca.bendo.form.entity.course.NewCourseReviewEntity;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseReviewHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class CourseReviewHandler
{
	/**
	 * 
	 */
	@Autowired
	private CommentHandler commentHandler;

	/**
	 * 
	 */
	@Autowired
	private CourseRatingTypeDAO ratingTypeDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseDAO courseDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseReviewDAO reviewDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseRatingDAO ratingDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityLanguageDAO languageDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * Add a new review.
	 * 
	 * @param universityId
	 *            University id
	 * @param courseId
	 *            course id
	 * @param request
	 *            Request
	 * @return if the request was suceesful
	 */
	public boolean handleNewCourseReview(final long universityId, final long courseId, final HttpServletRequest request)
	{

		NewCourseReviewEntity entity = new NewCourseReviewEntity();
		entity.setup(request);

		// Load the ratings
		List<CourseRatingType> types = ratingTypeDAO.list();
		Map<CourseRatingType, String> ratings = new HashMap<CourseRatingType, String>();
		for (CourseRatingType type : types)
		{
			String value = request.getParameter(String.valueOf(type.getId()));
			ratings.put(type, value);

		}
		try
		{
			boolean result = newCourseReview(universityId, courseId, ratings, entity, request);
			return result;
		} catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * 
	 * @param universityId
	 *            University id
	 * @param courseId
	 *            course id
	 * @param ratings
	 *            Rating map
	 * @param entity
	 *            entity Language of the comment
	 * @return if adding the review was a success
	 * @param request
	 *            request
	 * @throws Exception
	 *             excepetion if need to rollback
	 */
	public boolean newCourseReview(final long universityId, final long courseId,
			final Map<CourseRatingType, String> ratings, final NewCourseReviewEntity entity,
			final HttpServletRequest request) throws Exception
	{
		if (!entity.isValid())
		{
			entity.setupErrorsDisplay(request);
			entity.setupForDisplay(request);
			request.setAttribute("newCourseReviewEntity", entity);
			return false;
		}

		for (Entry<CourseRatingType, String> entry : ratings.entrySet())
		{
			if (!FieldValidator.isInt(entry.getValue()))
			{
				FormErrorHandler.getFormErrorHandler(request).addError(NewCourseReviewEntity.class,
						"form_err_rating_not_complete");
				return false;
			}
		}

		University university = universityDAO.getById(universityId);
		if (university == null) // Check if the professor exist
		{
			return false;
		}

		Course course = courseDAO.getById(courseId);
		if (course == null) // Check if the professor exist
		{
			return false;
		}
		Comment comment = commentHandler.newComment(entity.getComment(), Long.parseLong(entity.getLanguageId()));
		// Check the comment was successfully created
		if (comment == null)
		{
			return false;
		}

		CourseReview review = new CourseReview();
		review.setComment(comment);

		review.setCourse(course);
		reviewDAO.add(review);

		for (Entry<CourseRatingType, String> entry : ratings.entrySet())
		{
			int value = Integer.parseInt(entry.getValue());
			CourseRating rating = new CourseRating();
			rating.setType(entry.getKey());
			rating.setReview(review);
			rating.setValue(value);
			ratingDAO.add(rating);
		}

		return true;
	}

	/**
	 * @param universityId
	 *            University id
	 * @param courseId
	 *            course id
	 * @param request
	 *            Request
	 * 
	 * @return boolean if the page was succesfuly setup
	 */
	public boolean setupNewReviewPage(final long universityId, final long courseId, final HttpServletRequest request)
	{
		request.getAttribute("translator");
		Language.loadId(request);

		Course course = courseDAO.getById(courseId);
		if (course == null)
		{
			System.out.println("Course doesn't exist");
			return false;
		}
		request.setAttribute("course", course);
		List<CourseRatingType> types = ratingTypeDAO.list();
		request.setAttribute("courseRatingType", types);

		List<UniversityLanguage> languages = languageDAO.listUniversityLanguage();
		request.setAttribute("languages", languages);

		return true;
	}
}
