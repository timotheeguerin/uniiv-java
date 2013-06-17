/**
 * 
 */
package ca.bendo.user;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Visitor</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Visitor extends UserT
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.user.User#hasPermisson(int)
	 */
	@Override
	public boolean hasPermisson(final int id)
	{
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.user.User#hasPermisson(java.lang.String)
	 */
	@Override
	public boolean hasPermisson(final String str)
	{
		return false;
	}

}
