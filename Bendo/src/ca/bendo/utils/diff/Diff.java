/**
 * 
 */
package ca.bendo.utils.diff;

import ca.bendo.utils.diff.DiffUtils.Operation;

/**
 * @author Timothée Guérin
 * @version Bendo 

 * <b>Diff</b>
 * <p></p>
 *
 * 


 */
/**
 * Class representing one diff operation.
 */
public class Diff
{
	/**
	 * One of: INSERT, DELETE or EQUAL.
	 */
	public Operation operation;
	/**
	 * The text associated with this diff operation.
	 */
	public String text;

	/**
	 * Constructor. Initializes the diff with the provided values.
	 * 
	 * @param operation
	 *            One of INSERT, DELETE or EQUAL.
	 * @param text
	 *            The text being applied.
	 */
	public Diff(final Operation operation, final String text)
	{
		// Construct a diff with the specified operation and text.
		this.operation = operation;
		this.text = text;
	}

	/**
	 * Display a human-readable version of this Diff.
	 * 
	 * @return text version.
	 */
	public String toString()
	{
		String prettyText = this.text.replace('\n', '\u00b6');
		return "Diff(" + this.operation + ",\"" + prettyText + "\")";
	}

	/**
	 * Replace \n with "<br>
	 * ".
	 * 
	 * @return html version of the text
	 */
	public String textToHtml()
	{
		return this.text.replaceAll("\n", "<br/>");
	}

	/**
	 * Create a numeric hash value for a Diff. This function is not used by DMP.
	 * 
	 * @return Hash value.
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = (operation == null) ? 0 : operation.hashCode();
		result += prime * ((text == null) ? 0 : text.hashCode());
		return result;
	}

	/**
	 * Is this Diff equivalent to another Diff?
	 * 
	 * @param obj
	 *            Another Diff to compare against.
	 * @return true or false.
	 */
	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Diff other = (Diff) obj;
		if (operation != other.operation)
		{
			return false;
		}
		if (text == null)
		{
			if (other.text != null)
			{
				return false;
			}
		} else if (!text.equals(other.text))
		{
			return false;
		}
		return true;
	}
}
