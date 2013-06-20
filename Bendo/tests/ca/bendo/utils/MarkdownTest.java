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
		String input = "[TOC]\n #Heading 1\n ##SubHeading1 \n ##SubHeading2 \n "
				+ "#Heading 2\n #Heading 3\nioejoisjefoisejfojs \n ##SubHeading2";
		String html = MarkdownUtils.process(input);

		System.out.println("=====================================");
		System.out.println(html);
	}

}
