/**
 * 
 */
package ca.bendo.form.entity.admin.users;

import java.util.ArrayList;
import java.util.List;

/**
 * @author toby
 * @version Bendo 

 * <b>PermissionsForm</b>
 * <p></p>
 *
 * 


 */
public class PermissionsForm
{
	private List<Long> permissions = new ArrayList<Long>();

	/**
	 * @return the permissions
	 */
	public List<Long> getPermissions()
	{
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<Long> permissions)
	{
		this.permissions = permissions;
	}
}
