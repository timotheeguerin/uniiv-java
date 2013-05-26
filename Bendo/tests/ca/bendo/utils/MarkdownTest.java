/**
 * 
 */
package ca.bendo.utils;

import org.junit.Test;

import com.github.rjeschke.txtmark.Processor;

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
		String input = "\tfor(int i = 0; i<10; i++) System.out.println(\"test\");";
		String result = Processor.process(input);
		System.out.println(result);
	}
}
