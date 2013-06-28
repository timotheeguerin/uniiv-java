/**
 * 
 */
package ca.bendo.form.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>RatingEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class RatingEntity
{
	/**
	 * 
	 */
	@NotEmpty
	private long value;

	/**
	 * @return the value
	 */
	public long getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final long value)
	{
		this.value = value;
	}

}
