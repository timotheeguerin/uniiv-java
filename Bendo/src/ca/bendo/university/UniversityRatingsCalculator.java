/**
 * 
 */
package ca.bendo.university;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.course.CourseDAO;
import ca.bendo.db.dao.course.CourseRatingDAO;
import ca.bendo.db.dao.professor.ProfessorRatingDAO;
import ca.bendo.db.dao.professor.ProfessorUniversityDAO;
import ca.bendo.db.dao.rating.SoftRatingDAO;
import ca.bendo.db.dao.university.UniversityDAO;
import ca.bendo.db.dao.university.UniversityGradeDAO;
import ca.bendo.db.dao.university.UniversityReviewRatingDAO;
import ca.bendo.db.entity.course.Course;
import ca.bendo.db.entity.professor.ProfessorUniversity;
import ca.bendo.db.entity.rating.UniversityGrade;
import ca.bendo.db.entity.rating.UniversityRating;
import ca.bendo.db.entity.university.University;
import ca.bendo.utils.math.Round;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityRatingsCalculator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class UniversityRatingsCalculator
{
	/**
	 * 
	 */
	@Autowired
	private UniversityDAO universityDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityReviewRatingDAO universityReviewRatingDAO;

	/**
	 * 
	 */
	@Autowired
	private UniversityGradeDAO universityGradeDAO;
	/**
	 * 
	 */
	@Autowired
	private SoftRatingDAO ratingsDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorUniversityDAO professorUniversityDAO;

	/**
	 * 
	 */
	@Autowired
	private ProfessorRatingDAO professorRatingDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseDAO courseDAO;

	/**
	 * 
	 */
	@Autowired
	private CourseRatingDAO courseRatingDAO;

	/**
	 * 
	 */
	public void updateAllRatings()
	{
		List<University> universities = universityDAO.list();
		for (University university : universities)
		{
			updateRatings(university);
		}
	}

	/**
	 * @param universityId
	 *            Id of the university given
	 */
	public void updateRatings(final long universityId)
	{
		University university = universityDAO.getById(universityId);
		updateRatings(university);
	}

	/**
	 * @param university
	 *            University
	 * 
	 */
	public void updateRatings(final University university)
	{
		List<UniversityGrade> grades = university.getSoftRatings();
		setupGrades(university);
		for (UniversityGrade grade : grades)
		{
			UniversityRating rating = grade.getSoftRating();
			if (rating.getForm().getName().equals("university"))
			{

				double value = universityReviewRatingDAO
						.getUniversityRatingAverage(university.getId(), rating.getId());

				if (!rating.getType().getName().equals("standard"))
				{
					value = Math.round(value);
				}
				grade.setValue(value);
			} else if (rating.getForm().getName().equals("professor"))
			{
				double value = calculateProfessorAverage(university.getId());
				grade.setValue(value);
			} else if (rating.getForm().getName().equals("course"))
			{
				double value = calculateCourseAverage(university.getId());
				grade.setValue(value);
			}
			universityGradeDAO.add(grade);

		}
		universityDAO.update(university);

	}

	/**
	 * 
	 * @param universityId
	 *            University id
	 * @return the professor average for the given university
	 */
	public double calculateProfessorAverage(final long universityId)
	{
		List<ProfessorUniversity> professors = professorUniversityDAO.listProfessorAtUniversity(universityId);
		double average = 0;
		for (ProfessorUniversity professor : professors)
		{
			average += professorRatingDAO.getProfessorAverage(professor.getProfessor().getId());
		}
		return Round.roundOneDecimal(average / professors.size());
	}

	/**
	 * 
	 * @param universityId
	 *            University id
	 * @return the professor average for the given university
	 */
	public double calculateCourseAverage(final long universityId)
	{
		List<Course> courses = courseDAO.listCourseInUniversity(universityId);
		double average = 0;
		for (Course course : courses)
		{
			average += courseRatingDAO.getCourseAverage(course.getId());
		}
		return Round.roundOneDecimal(average / courses.size());
	}

	/**
	 * 
	 * @param university
	 *            University
	 * */
	public void setupGrades(final University university)
	{
		List<UniversityGrade> grades = university.getSoftRatings();
		List<UniversityRating> ratings = ratingsDAO.list();
		if (ratings.size() != grades.size())
		{
			for (UniversityRating rating : ratings)
			{
				// If no grade as the current rating add a new grade
				if (!isRatingInGrades(grades, rating))
				{
					UniversityGrade grade = new UniversityGrade();
					grade.setSoftRating(rating);
					grade.setValue(1);
					grade.setUniversity(university);
					grades.add(grade);

					universityGradeDAO.add(grade);
				}
			}
		}
		universityDAO.add(university);
	}

	/**
	 * 
	 * @param grades
	 *            grades
	 * @param rating
	 *            ratings
	 * @return boolean if any of the given grades as the given rating type
	 */
	public boolean isRatingInGrades(final List<UniversityGrade> grades, final UniversityRating rating)
	{
		for (UniversityGrade grade : grades)
		{
			if (grade.getSoftRating().getId() == rating.getId())
			{
				return true;
			}
		}
		return false;
	}

}
