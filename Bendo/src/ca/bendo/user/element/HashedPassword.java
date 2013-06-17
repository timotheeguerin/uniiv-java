/**
 * 
 */
package ca.bendo.user.element;

import org.apache.commons.lang.ObjectUtils;

import ca.bendo.utils.security.Crypter;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>HashedPassword</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class HashedPassword
{

	/**
	 * String containg the password.
	 */
	private String hashedPassword;

	/**
	 * Default contructor.
	 */
	public HashedPassword()
	{
		// 
	}

	/**
	 * Create a hashed password from another.
	 * 
	 * @param hashedPassword
	 *            Hashpassword to copy
	 */
	public HashedPassword(final HashedPassword hashedPassword)
	{
		this.hashedPassword = hashedPassword.getHashedPassword();
	}

	/**
	 * Create a hashed password from a password string.
	 * 
	 * @param password
	 *            Password to hash
	 */
	public HashedPassword(final String password)
	{
		hashedPassword = Crypter.generateHashKey(password);
	}

	/**
	 * Create a hashed password from a password object.
	 * 
	 * @param password
	 *            Password to hash
	 */
	public HashedPassword(final Password password)
	{
		this(password.getPassword());
	}

	/**
	 * Create a hashed password from a password string.
	 * 
	 * @param password
	 *            Password String to hash
	 * @param salt
	 *            Salt of the password
	 */
	public HashedPassword(final String password, final String salt)
	{
		hashedPassword = Crypter.hashKey(salt, password);
	}

	/**
	 * Create a hashed password from a password object.
	 * 
	 * @param password
	 *            Password object to hash
	 * @param salt
	 *            Salt of the password
	 */
	public HashedPassword(final Password password, final String salt)
	{
		this(password.getPassword(), salt);
	}

	/**
	 * @return the password
	 */
	public String getHashedPassword()
	{
		return hashedPassword;
	}

	/**
	 * @param hashedPassword
	 *            the hashed password to set
	 */
	public void setHashedPassword(final String hashedPassword)
	{
		this.hashedPassword = hashedPassword;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return hashedPassword;
	}

	/**
	 * @return the salt of the hashed password
	 */
	public String getSalt()
	{
		if (hashedPassword != null)
		{
			return hashedPassword.substring(0, Crypter.SALT_LENGTH);
		} else
		{
			return "";
		}
	}

	/**
	 * @param password
	 *            password to compare
	 * @return boolean if the given password match the hashed one
	 */
	public boolean match(final String password)
	{
		String salt = getSalt();
		HashedPassword hashPasswordCmp = new HashedPassword(password, salt);
		System.out.println(hashPasswordCmp.hashedPassword + " " + this.hashedPassword);
		return this.equals(hashPasswordCmp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof HashedPassword)
		{
			HashedPassword cmp = (HashedPassword) obj;
			return ObjectUtils.equals(this.hashedPassword, cmp.hashedPassword);
		} else
		{
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		
		return super.hashCode();
	}
}
