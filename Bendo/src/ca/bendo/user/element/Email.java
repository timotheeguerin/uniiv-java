/**
 * 
 */
package ca.bendo.user.element;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Email</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Email
{

	/**
	 * String containg the Email.
	 */
	private String email;

	/**
	 * Default contructor.
	 */
	public Email()
	{
		// 
	}

	/**
	 * Initialise Email with email string.
	 * 
	 * @param email
	 *            Email to set
	 */
	public Email(final String email)
	{
		this.email = email;
	}

	/**
	 * @return the Email
	 */
	public final String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the Email to set
	 */
	public final void setEmail(final String email)
	{
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString()
	{
		return email;
	}

}
