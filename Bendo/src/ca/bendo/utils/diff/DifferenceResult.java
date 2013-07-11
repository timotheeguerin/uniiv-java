/**
 * 
 */
package ca.bendo.utils.diff;

import java.util.LinkedList;

import ca.bendo.utils.diff.DiffUtils.Operation;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DifferenceResult</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DifferenceResult
{
	/**
	 * 
	 */
	private LinkedList<Diff> differences = new LinkedList<Diff>();

	/**
	 * 
	 */
	public DifferenceResult()
	{

	}

	/**
	 * @param differences
	 *            the differences to set
	 */
	public DifferenceResult(final LinkedList<Diff> differences)
	{
		this.differences = differences;
	}

	/**
	 * Compute and return the source text (all equalities and deletions).
	 * 
	 * @return Source text.
	 */
	public String getOriginal()
	{
		StringBuilder text = new StringBuilder();
		for (Diff aDiff : differences)
		{
			if (aDiff.operation != Operation.INSERT)
			{
				text.append(aDiff.text);
			}
		}
		return text.toString();
	}

	/**
	 * Compute and return the destination text (all equalities and insertions).
	 * 
	 * @return Destination text.
	 */
	public String getRevision()
	{
		StringBuilder text = new StringBuilder();
		for (Diff aDiff : differences)
		{
			if (aDiff.operation != Operation.DELETE)
			{
				text.append(aDiff.text);
			}
		}
		return text.toString();
	}

	/**
	 * @return the differences
	 */
	public LinkedList<Diff> getDifferences()
	{
		return differences;
	}

	/**
	 * @param differences
	 *            the differences to set
	 */
	public void setDifferences(final LinkedList<Diff> differences)
	{
		this.differences = differences;
	}

}
