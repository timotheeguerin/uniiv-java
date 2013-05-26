/**
 * 
 */
package ca.bendo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import ca.bendo.db.entity.user.UserPermission;
import ca.bendo.db.entity.user.UserState;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>PermissionFactory</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class UserFactory
{

	/**
	 * Prevent instantiation.
	 */
	private UserFactory()
	{

	}

	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(UserFactory.class);

	/**
	 * Contain all the sate a user can have(waiting email confirmation, valid,
	 * ...).
	 */
	private static List<UserState> states = new ArrayList<UserState>();

	/**
	 * Contain all the permission a user can have(admin.db, member, ...).
	 */
	private static List<UserPermission> permissions = new ArrayList<UserPermission>();

	/**
	 * Get the state by the id. Throw NoSuchElementException If it does not
	 * contains a state having the id given.
	 * 
	 * @param id
	 *            Id to match
	 * @return The state macthing the given id
	 * 
	 */
	public static UserState getStateById(final int id)
	{
		for (UserState state : getStates())
		{
			if (state.getId() == id)
			{
				return state;
			}
		}
		throw new NoSuchElementException("No such state with given id");
	}

	/**
	 * Get the state by the name. Throw NoSuchElementException If it does not
	 * contains a state having the name given.
	 * 
	 * @param name
	 *            Name to match
	 * @return The state macthing the given id
	 */
	public static UserState getStateByName(final String name)
	{

		for (UserState state : getStates())
		{
			if (state.getState().equalsIgnoreCase(name))
			{
				return state;
			}
		}
		throw new NoSuchElementException("No such state with given name");
	}

	/**
	 * Get the state by the id. Throw NoSuchElementException If it does not
	 * contains a state having the id given.
	 * 
	 * @param id
	 *            Id to match
	 * @return The state macthing the given id
	 * 
	 */
	public static UserPermission getPermissionById(final int id)
	{
		for (UserPermission permission : getPermissions())
		{
			if (permission.getId() == id)
			{
				return permission;
			}
		}
		throw new NoSuchElementException("No such permission with given id");
	}

	/**
	 * Get the state by the name. Throw NoSuchElementException If it does not
	 * contains a state having the name given.
	 * 
	 * @param name
	 *            Name to match
	 * @return The state macthing the given id
	 */
	public static UserPermission getPermissionByName(final String name)
	{

		for (UserPermission permission : getPermissions())
		{
			if (permission.getPermission().equalsIgnoreCase(name))
			{
				return permission;
			}
		}
		throw new NoSuchElementException("No such permission with given name");
	}

	/**
	 * @return the categories
	 */
	public static List<UserState> getStates()
	{
		return states;
	}

	/**
	 * @param statestmp
	 *            the states to set
	 */
	public static void setStates(final List<UserState> statestmp)
	{
		UserFactory.states = statestmp;
	}

	/**
	 * @return the permissions
	 */
	public static List<UserPermission> getPermissions()
	{
		return permissions;
	}

	/**
	 * @param permissions
	 *            the permissions to set
	 */
	public static void setPermissions(final List<UserPermission> permissions)
	{
		UserFactory.permissions = permissions;
	}

}
