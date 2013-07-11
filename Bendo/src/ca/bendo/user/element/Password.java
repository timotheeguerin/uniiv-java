/**
 * 
 */
package ca.bendo.user.element;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Password</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Password
{

	/**
	 * String containg the password.
	 */
	private String password;

	/**
	 * Default contructor.
	 */
	public Password()
	{
		//
	}

	/**
	 * Create a password from another.
	 * 
	 * @param password
	 *            password to copy
	 */
	public Password(final Password password)
	{
		this.password = password.getPassword();
	}

	/**
	 * Create a Password from a string.
	 * 
	 * @param password
	 *            Password to set
	 */
	public Password(final String password)
	{
		this.password = password;
	}

	/**
	 * @return the hashed password
	 */
	public HashedPassword hashPassword()
	{
		return new HashedPassword(password);
	}

	/**
	 * @param salt
	 *            hashedPassword salt
	 * @return the hashed password depending on the given salt
	 */
	public HashedPassword hashPassword(final String salt)
	{
		return new HashedPassword(password, salt);
	}

	/**
	 * Check if the password match the hashedPassword.
	 * 
	 * @param hashPassword
	 *            Password to compare
	 * @return If the two password match
	 */
	public boolean match(final HashedPassword hashPassword)
	{
		String salt = hashPassword.getHashedPassword();
		HashedPassword hashPassword2 = hashPassword(salt);
		return hashPassword.equals(hashPassword2);
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password)
	{
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return password;
	}

}
