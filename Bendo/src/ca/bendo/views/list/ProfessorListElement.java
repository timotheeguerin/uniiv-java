/**
 * 
 */
package ca.bendo.views.list;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.db.entity.professor.Professor;
import ca.bendo.db.entity.professor.ProfessorRatingAverage;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorListElement</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ProfessorListElement
{
	/**
	 * 
	 */
	private Professor professor;

	/**
	 * 
	 */
	private ProfessorRatingAverage ratings;
	/**
	 * 
	 */
	private String link;

	/**
	 * 
	 */
	private List<String> values = new ArrayList<String>();

	/**
	 * @return the professor
	 */
	public final Professor getProfessor()
	{
		return professor;
	}

	/**
	 * @param professor
	 *            the professor to set
	 */
	public final void setProfessor(final Professor professor)
	{
		this.professor = professor;
	}

	/**
	 * @return the values
	 */
	public final List<String> getValues()
	{
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public final void setValues(final List<String> values)
	{
		this.values = values;
	}

	/**
	 * @return the link
	 */
	public String getLink()
	{
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public void setLink(final String link)
	{
		this.link = link;
	}

	/**
	 * @return the ratings
	 */
	public final ProfessorRatingAverage getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public final void setRatings(final ProfessorRatingAverage ratings)
	{
		this.ratings = ratings;
	}

}
