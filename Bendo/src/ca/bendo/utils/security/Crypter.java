/**
 * 
 */
package ca.bendo.utils.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Crypter</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class Crypter
{

	/**
	 * Length of the random generated key.
	 */
	public static final int RANDOM_KEY_LENGHT = 128;
	/**
	 * Lenght of teh hashkey.
	 */
	public static final int HASHKEY_LENGHT = 128;
	/**
	 * Hashed password salt length.
	 */
	public static final int SALT_LENGTH = 64;

	/**
	 * Hash algorithm.
	 */
	private static final String DISGEST_ALGORITHM = "SHA-256";

	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(Crypter.class);

	/**
	 * Prevent instantiation of Utility class.
	 */
	private Crypter()
	{
	}

	/**
	 * Hexadecimal radix for the conversion from byteArray to hexadecimal.
	 */
	private static final int HEX_RADIX = 16;

	/**
	 * Generate a hash key(and salt) with the key send.
	 * 
	 * @param key
	 *            key to be hashed
	 * @return the hashKey
	 */
	public static String generateHashKey(final String key)
	{
		String random = RandomStringUtils.randomAlphanumeric(RANDOM_KEY_LENGHT);
		try
		{
			MessageDigest digest = MessageDigest.getInstance(DISGEST_ALGORITHM);

			try
			{
				digest.update(random.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			byte[] hashedByteArray = digest.digest();

			String salt = encodeToHex(hashedByteArray);
			return hashKey(salt, key);
		} catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * Hash the key with the salt.
	 * 
	 * @param salt
	 *            Salt of the key
	 * @param key
	 *            key to hash
	 * @return the hashed key
	 */
	public static String hashKey(final String salt, final String key)
	{
		try
		{
			String saltandkey = salt + key;
			MessageDigest digest = MessageDigest.getInstance(DISGEST_ALGORITHM);

			try
			{
				digest.update(saltandkey.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			byte[] hashedByteArray = digest.digest();

			return salt + encodeToHex(hashedByteArray);
		} catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * Convert a byteArray to an hex String.
	 * 
	 * @param byteArray
	 *            byteArray to convert
	 * @return The hex String
	 */
	public static String encodeToHex(final byte[] byteArray)
	{
		String hex = new BigInteger(1, byteArray).toString(HEX_RADIX);
		return hex;
	}

	/**
	 * Extract the salt from the hashkey.
	 * 
	 * @param hashKey
	 *            hashKey contaning the salt
	 * @return The salt
	 */
	public static String getSalt(final String hashKey)
	{
		return hashKey.substring(0, SALT_LENGTH);
	}
}
