/**
 * 
 */
package ca.bendo.db.entity.wiki;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ContentDifference</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ContentDifference
{
	/**
	 * 
	 */
	private long addition;

	/**
	 * 
	 */
	private long deletion;

	/**
	 * @return the addition
	 */
	public long getAddition()
	{
		return addition;
	}

	/**
	 * @param addition
	 *            the addition to set
	 */
	public void setAddition(final long addition)
	{
		this.addition = addition;
	}

	/**
	 * @return the deletion
	 */
	public long getDeletion()
	{
		return deletion;
	}

	/**
	 * @param deletion
	 *            the deletion to set
	 */
	public void setDeletion(final long deletion)
	{
		this.deletion = deletion;
	}

}
