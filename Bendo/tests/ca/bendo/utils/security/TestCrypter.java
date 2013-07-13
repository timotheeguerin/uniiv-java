/**
 * 
 */
package ca.bendo.utils.security;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestCrypter</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TestCrypter
{

	/**
	 * Password lenght.
	 */
	private static final int PASSWORD_LENTGH = 100;
	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger("TestCrypterLog");

	/**
	 * Test the generateHashKey function.
	 */
	@Test
	public void testGenerateHashKey()
	{
		System.out.println("Catalina: " + System.getenv("CATALINA_HOME"));
		Crypter.generateHashKey("superpasswrd");
	}

	/**
	 * Test the hashKey function.
	 */
	@Test
	public void testHashKey()
	{
		String password = RandomStringUtils.randomAscii(PASSWORD_LENTGH);
		String hashKey = Crypter.generateHashKey(password);
		String salt = Crypter.getSalt(hashKey);
		String hashKey2 = Crypter.hashKey(salt, password);
		assertTrue(hashKey.equals(hashKey2));
	}

}
