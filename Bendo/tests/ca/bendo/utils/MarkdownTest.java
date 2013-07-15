/**
 * 
 */
package ca.bendo.utils;

import org.junit.Test;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>MarkdownTest</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class MarkdownTest
{
	/**
	 * 
	 */
	@Test
	public void testMarkdownCode()
	{
		String input = "Test\n\nnext\n\nline";
		String html = MarkdownUtils.process(input);

		System.out.println("=====================================");
		System.out.println(html);
	}

}
