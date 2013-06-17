/**
 * 
 */
package ca.bendo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestForumReplyController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestForumReplyController
{
	/**
	 * 
	 */
	@Test
	public void testHandleNewReply()
	{
		
	}
}
