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
	 * @param nextDiff
	 *            next difference to be
	 * @return html version of the text
	 */
	public String textToHtml(final Diff nextDiff)
	{
		if (nextDiff != null && operation == Operation.DELETE && nextDiff.operation == Operation.INSERT)
		{
			if (text.endsWith("\n") && nextDiff.text.endsWith("\n"))
			{
				text = text.substring(0, text.length() - 1);
			}
		}
		StringBuilder result = new StringBuilder();
		switch (operation)
		{
		case INSERT:
			result.append("<span class='new'>");
			break;
		case DELETE:
			result.append("<span class='old'>");
			break;
		case EQUAL:
			result.append("<span>").append("");
			break;
		default:
			break;
		}
		result.append(this.text.replaceAll("\n", "<br/>"));
		result.append("</span>");
		return result.toString();

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

	/**
	 * @return the operation
	 */
	public Operation getOperation()
	{
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(final Operation operation)
	{
		this.operation = operation;
	}

	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(final String text)
	{
		this.text = text;
	}

}
