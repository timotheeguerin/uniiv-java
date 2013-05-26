/**
 * 
 */
package ca.bendo.db.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Permission</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user_permission")
public class UserPermission
{

	/**
	 * State id.
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_permission")
	private long id;

	/**
	 * State name.
	 */
	@Column(name = "permission")
	private String permission;

	/**
	 * Check if the permission given is contain in this object. ex: permission:
	 * admin.xxx.yyy then *, admin.*, admin.xxx.* as well as admin.xxx.yyy have
	 * access
	 * 
	 * @param p
	 *            to check
	 * @return boolean
	 */
	public final boolean hasPermission(final String p)
	{

		String[] realNodes = permission.split("\\.");
		String[] nodes = p.split("\\.");

		for (int i = 0; i < realNodes.length; i++)
		{
			if (i >= nodes.length)
			{
				return false;
			}
			if (nodes[i].equals("*"))
			{
				return true;
			} else if (!realNodes[i].equalsIgnoreCase(nodes[i]))
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * If the permission id send match the id of the object.
	 * 
	 * @param permissionId
	 *            to check
	 * @return boolean
	 */
	public final boolean hasPermission(final int permissionId)
	{

		return getId() == permissionId;
	}

	/**
	 * @return the id
	 */
	public final long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(final long id)
	{
		this.id = id;
	}

	/**
	 * @return the permission
	 */
	public final String getPermission()
	{
		return permission;
	}

	/**
	 * @param permission
	 *            the permission to set
	 */
	public final void setPermission(final String permission)
	{
		this.permission = permission;
	}

}
