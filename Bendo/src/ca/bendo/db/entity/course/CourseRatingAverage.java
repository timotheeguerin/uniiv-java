/**
 * 
 */
package ca.bendo.db.entity.course;

import java.util.List;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CourseRatingAverage</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class CourseRatingAverage
{
	/**
	 * 
	 */
	private static final double ONE_DECIMAL = 10;
	/**
	 * 
	 */
	private List<CourseRating> ratings;

	/**
	 * 
	 * @param t
	 *            type of the rating to get
	 * @return return the rating with the given type
	 */
	public double getRating(final String t)
	{
		for (CourseRating rating : ratings)
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

		for (CourseRating rating : ratings)
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
	public List<CourseRating> getRatings()
	{
		return ratings;
	}

	/**
	 * @param ratings
	 *            the ratings to set
	 */
	public void setRatings(final List<CourseRating> ratings)
	{
		this.ratings = ratings;
	}

}
