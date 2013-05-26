/**
 * 
 */
package ca.bendo.user;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Confirmation</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Confirmation
{

	/**
	 * Confirmation id.
	 */
	private int id;

	/**
	 * User id.
	 */
	private int userId;

	/**
	 * Confirmation key.
	 */
	private String key;

	/**
	 * Setter for id.
	 * 
	 * @return the id
	 */
	public final int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(final int id)
	{
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public final int getUserId()
	{
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public final void setUserId(final int userId)
	{
		this.userId = userId;
	}

	/**
	 * @return the key
	 */
	public final String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public final void setKey(final String key)
	{
		this.key = key;
	}
}
