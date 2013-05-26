/**
 * 
 */
package ca.bendo.db.entity.professor;

import java.util.List;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorRatingAverage</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ProfessorRatingAverage
{
	/**
	 * 
	 */
	private static final double ONE_DECIMAL = 10;
	/**
	 * 
	 */
	private List<ProfessorRating> ratings;

	/**
	 * 
	 * @param t
	 *            type of the rating to get
	 * @return return the rating with the given type
	 */
	public double getRating(final String t)
	{
		for (ProfessorRating rating : ratings)
		{
			if (t.equalsIgnoreCase(rating.getType().getName()))
			{
				return roundOneDecimal(rating.getValue());
			}
		}
		return 1D;
	}

	/**
	 * 
	 * @return return the average rating with the given type
	 */
	public double getAverage()
	{
		double sum = 0;

		for (ProfessorRating rating : ratings)
		{

			sum += rating.getValue();

		}
		if (ratings.size() > 0)
		{
			return roundOneDecimal(sum / ratings.size());
		} else
		{
			return 1D;
		}
	}

	/**
	 * 
	 * @param d
	 *            double to round
	 * @return the given double rounded with one decimal
	 */
	private double roundOneDecimal(final double d)
	{

		long tmp = Math.round(d * ONE_DECIMAL);
		return (double) tmp / ONE_DECIMAL;
	}

	/**
	 * @return the ratings
	 */
	public final List<ProfessorRating> getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public final void setRatings(final List<ProfessorRating> ratings)
	{
		this.ratings = ratings;
	}

}
