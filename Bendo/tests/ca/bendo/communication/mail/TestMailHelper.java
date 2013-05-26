/**
 * 
 */
package ca.bendo.communication.mail;

import org.junit.Test;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestMailHelper</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TestMailHelper
{
		
	/**
	 * 
	 */
	@Test
	public void testSendMail()
	{
		MailHelper mailHelper = new MailHelper();
		mailHelper.send("timothee.guerin@outlook.com", "Subject test", "My super message de merde");
	}
}
