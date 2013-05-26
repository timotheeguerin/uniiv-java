/**
 * 
 */
package ca.bendo.taglib.tag.card.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.course.CourseDAO;
import ca.bendo.db.entity.course.Course;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseCardHandler</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class CourseCardHandler implements CardHandler
{
	/**
 * 
 */
	@Autowired
	private CourseDAO courseDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.bendo.taglib.tag.card.handler.CardHandler#setup(javax.servlet.http
	 * .HttpServletRequest, long)
	 */
	@Override
	public void setup(final HttpServletRequest request, final long value)
	{
		Course course = courseDAO.getById(value);
		request.setAttribute("coursecard_course", course);
	}

}
