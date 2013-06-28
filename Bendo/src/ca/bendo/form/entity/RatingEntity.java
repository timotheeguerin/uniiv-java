/**
 * 
 */
package ca.bendo.form.entity;

import javax.validation.constraints.NotNull;

import ca.bendo.form.FieldValidator;

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
	private int value;

	/**
	 * 
	 */
	public RatingEntity()
	{

	}

	/**
	 * @param string
	 *            init the value
	 */
	public RatingEntity(final String string)
	{
		if (FieldValidator.isInt(string))
		{
			value = Integer.parseInt(string);
		}

	}

	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final int value)
	{
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return String.valueOf(value);
	}

}
