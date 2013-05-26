/**
 * 
 */
package ca.bendo.form.handler.professor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.language.UniversityLanguageDAO;
import ca.bendo.db.dao.professor.ProfessorDAO;
import ca.bendo.db.dao.professor.ProfessorRatingDAO;
import ca.bendo.db.dao.professor.ProfessorRatingTypeDAO;
import ca.bendo.db.dao.professor.ProfessorReviewDAO;
import ca.bendo.db.entity.comment.Comment;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.db.entity.language.UniversityLanguage;
import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.professor.ProfessorRating;
import ca.bendo.db.entity.professor.ProfessorRatingType;
import ca.bendo.db.entity.professor.ProfessorReview;
import ca.bendo.form.FieldValidator;
import ca.bendo.form.FormErrorHandler;
import ca.bendo.form.comment.CommentHandler;
import ca.bendo.form.entity.professor.NewProfessorReviewEntity;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>NewProfessorReviewHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class NewProfessorReviewHandler
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
	private ProfessorRatingTypeDAO ratingTypeDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorDAO professorDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorReviewDAO reviewDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorRatingDAO ratingDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityLanguageDAO languageDAO;

	/**
	 * Add a new review.
	 * 
	 * @param professorIdStr
	 *            Professor id string
	 * @param request
	 *            Request
	 * @return if the request was suceesful
	 */
	public boolean newProfessorReview(final String professorIdStr, final HttpServletRequest request)
	{

		NewProfessorReviewEntity entity = new NewProfessorReviewEntity();
		entity.setup(request);

		// Load the ratings
		List<ProfessorRatingType> types = ratingTypeDAO.listProfessorRatingType();
		Map<ProfessorRatingType, String> ratings = new HashMap<ProfessorRatingType, String>();
		for (ProfessorRatingType type : types)
		{
			String value = request.getParameter("rating_" + String.valueOf(type.getId()));
			ratings.put(type, value);
		}
		try
		{
			boolean result = newProfessorReview(professorIdStr, ratings, entity, request);
			return result;
		} catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * 
	 * @param professorIdStr
	 *            Id of the professor
	 * @param ratings
	 *            Rating map
	 * @param entity
	 *            entity Language of the comment
	 * @param request
	 *            request
	 * @return if adding the review was a success
	 * @throws Exception
	 *             excepetion if need to rollback
	 */
	public boolean newProfessorReview(final String professorIdStr, final Map<ProfessorRatingType, String> ratings,
			final NewProfessorReviewEntity entity, final HttpServletRequest request) throws Exception
	{
		if (!entity.isValid())
		{
			entity.setupErrorsDisplay(request);
			entity.setupForDisplay(request);
			request.setAttribute("newProfReviewEntity", entity);
			return false;
		}
		// Check the parameters are good
		if (!(FieldValidator.isInt(professorIdStr)))
		{
			FormErrorHandler.getFormErrorHandler(request).addError(NewProfessorReviewEntity.class,
					"form_err_rating_not_complete");
			return false;
		}
		for (Entry<ProfessorRatingType, String> entry : ratings.entrySet())
		{
			if (!FieldValidator.isInt(entry.getValue()))
			{
				entity.setupForDisplay(request);
				request.setAttribute("newProfReviewEntity", entity);
				FormErrorHandler.getFormErrorHandler(request).addError(entity.getClass().getSimpleName(),
						"err_form_rating");
				return false;
			}
		}
		professorDAO.setLanguageId(1L);
		Professor professor = professorDAO.getById(Long.parseLong(professorIdStr));
		if (professor == null) // Check if the professor exist
		{
			System.out.println("No professor with id");
			return false;
		}
		Comment comment = commentHandler.newComment(entity.getComment(), Long.parseLong(entity.getLanguageId()));
		// Check the comment was successfully created
		if (comment == null)
		{
			System.out.println("Comment error");
			return false;
		}
		ProfessorReview review = new ProfessorReview();
		review.setComment(comment);

		review.setProfessor(professor);
		review.setDate(new Date());
		reviewDAO.add(review);

		for (Entry<ProfessorRatingType, String> entry : ratings.entrySet())
		{
			int value = Integer.parseInt(entry.getValue());
			ProfessorRating rating = new ProfessorRating();
			rating.setType(entry.getKey());
			rating.setReview(review);
			rating.setValue(value);
			ratingDAO.add(rating);
		}

		return true;
	}

	/**
	 * @param professorId
	 *            professorId
	 * @param request
	 *            Request
	 * 
	 * @return boolean if the page was succesfuly setup
	 */
	public boolean setupNewReviewPage(final long professorId, final HttpServletRequest request)
	{
		Translator translator = (Translator) request.getAttribute("translator");
		Long languageId = Language.load(request);
		professorDAO.setLanguageId(languageId);
		reviewDAO.setLanguageId(languageId);
		ratingTypeDAO.setLanguageId(languageId);
		ratingDAO.setLanguageId(languageId);
		languageDAO.setLanguageId(languageId);

		Professor professor = professorDAO.getById(professorId);
		if (professor == null)
		{
			System.out.println("Professor doesn't exist");
			return false;
		}
		request.setAttribute("professor", professor);
		List<ProfessorRatingType> types = ratingTypeDAO.listProfessorRatingType();

		request.setAttribute("profRatingType", types);

		List<UniversityLanguage> languages = languageDAO.listUniversityLanguage();
		request.setAttribute("languages", languages);

		return true;
	}

}
