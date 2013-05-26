/**
 * 
 */
package ca.bendo.user;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>User</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public abstract class UserT
{
	/**
	 * Return if the user has permission to do.
	 * 
	 * @param id
	 *            Permisson Id
	 * @return boolean
	 */
	public abstract boolean hasPermisson(int id);

	/**
	 * Return if the user has permission to do.
	 * 
	 * @param str
	 *            Permisson
	 * @return boolean
	 */
	public abstract boolean hasPermisson(String str);
}
