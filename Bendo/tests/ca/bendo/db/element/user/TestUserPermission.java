/**
 * 
 */
package ca.bendo.db.element.user;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.bendo.db.entity.user.UserPermission;

/**
 * @author Timothée Guérin
 * @version Bendo 

 * <b>TestUserPermission</b>
 * <p></p>
 *
 * 

S
 */
public class TestUserPermission
{
	/**
	 * Test the HasPermission from the UserPermission class.
	 * Check if the permission  give the permission.
	 * @see UserPermission#HasPermission
	 */
	@Test
	public final void testHasPermission()
	{

		UserPermission perm = new UserPermission();
		perm.setId(1);
		perm.setPermission("admin.xxx.yyy");
		
		//HAVE PERMISSION
		assertTrue(perm.hasPermission("*"));
		assertTrue(perm.hasPermission("admin.*"));
		assertTrue(perm.hasPermission("admin.xxx.*"));
		assertTrue(perm.hasPermission("admin.xxx.yyy"));
		
		//DONT HAVE PERMISSION
		assertTrue(!perm.hasPermission("admin.yyy.xxx"));
		assertTrue(!perm.hasPermission("admin.yyy.*"));
		assertTrue(!perm.hasPermission("admin"));
		
	}
	/**
	 * Test the HasPermission from the UserPermission class.
	 * Check if the permission don't give the permission.
	 * @see UserPermission#HasPermission
	 */
	@Test
	public final void testDontHavePermission()
	{

		UserPermission perm = new UserPermission();
		perm.setId(1);
		perm.setPermission("admin.xxx.yyy");

		
		//DONT HAVE PERMISSION
		assertTrue(!perm.hasPermission("admin.yyy.xxx"));
		assertTrue(!perm.hasPermission("admin.yyy.*"));
		assertTrue(!perm.hasPermission("admin"));
		
	}
}
