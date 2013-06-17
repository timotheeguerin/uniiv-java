/**
 * 
 */
package ca.bendo.math;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Range</b>
 *          <p>
 *          </p>
 * @param <T>
 *            Type of the minimum and maximum
 * 
 */
public class Range<T>
{
	/**
	 * 
	 */
	private T minimum;

	/**
	 * 
	 */
	private T maximum;

	/**
	 * 
	 */
	public Range()
	{

	}

	/**
	 * 
	 * @param minimum
	 *            Minimum to set
	 * @param maximum
	 *            Maximum to set
	 */
	public Range(final T minimum, final T maximum)
	{
		this.minimum = minimum;
		this.maximum = maximum;
	}

	/**
	 * @param range
	 *            to initiliase from
	 */
	public Range(final Range<T> range)
	{
		this.minimum = range.minimum;
		this.maximum = range.maximum;
	}

	/**
	 * @return the minimum
	 */
	public T getMinimum()
	{
		return minimum;
	}

	/**
	 * @param minimum
	 *            the minimum to set
	 */
	public void setMinimum(final T minimum)
	{
		this.minimum = minimum;
	}

	/**
	 * @return the maximum
	 */
	public T getMaximum()
	{
		return maximum;
	}

	/**
	 * @param maximum
	 *            the maximum to set
	 */
	public void setMaximum(final T maximum)
	{
		this.maximum = maximum;
	}

}
