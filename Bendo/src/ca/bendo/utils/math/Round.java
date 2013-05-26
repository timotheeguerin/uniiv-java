/**
 * 
 */
package ca.bendo.utils.math;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Round</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class Round
{
	/**
	 * 
	 */
	private static final double ONE_DECIMAL = 10;

	/**
	 * 
	 */
	private Round()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param d
	 *            double to round
	 * @return the given double rounded with one decimal
	 */
	public static double roundOneDecimal(final double d)
	{

		long tmp = Math.round(d * ONE_DECIMAL);
		return (double) tmp / ONE_DECIMAL;
	}

	/**
	 * 
	 * @param d
	 *            double to round
	 * @param n
	 *            number of decimal
	 * @return the given double rounded with one decimal
	 */
	public static double roundNDecimal(final double d, final int n)
	{

		long tmp = Math.round(d * ONE_DECIMAL * n);
		return (double) tmp / (ONE_DECIMAL * n);
	}
}
