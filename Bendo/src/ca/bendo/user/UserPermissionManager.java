/**
 * 
 */
package ca.bendo.user;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.db.entity.user.UserPermission;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserPermissionManager</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class UserPermissionManager
{
	/**
	 * Permission list.
	 */
	private List<UserPermission> permissions = new ArrayList<UserPermission>();

	/**
	 * @param permissions
	 *            Permission to set
	 */
	public UserPermissionManager(final List<UserPermission> permissions)
	{
		this.permissions = permissions;
	}

	/**
	 * Return if the user has the permission asked.
	 * 
	 * @param permission
	 *            to check
	 * @return boolean
	 */
	public boolean hasPermission(final String permission)
	{
		for (UserPermission p : getPermissions())
		{
			if (p.hasPermission(permission))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Return if the user has the permission asked.
	 * 
	 * @param permission
	 *            to check
	 * @return boolean
	 */
	public boolean hasPermission(final int permission)
	{
		for (UserPermission p : getPermissions())
		{
			if (p.hasPermission(permission))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param permissions
	 *            permissions to set.
	 * @return
	 */
	public void setPermissions(final List<UserPermission> permissions)
	{
		this.permissions = permissions;
	}

	/**
	 * @return the permissions
	 */
	public List<UserPermission> getPermissions()
	{
		return permissions;
	}

}
