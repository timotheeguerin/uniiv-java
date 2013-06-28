/**
 * 
 */
package ca.bendo.form.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Timothée Guérin
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
	@NotNull
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
