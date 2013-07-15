/**
 * 
 */
package ca.bendo.utils;

import org.junit.Test;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestDiff1</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TestDiff1
{


	/**
	 * 
	 */
	@Test
	public void test()
	{
		String original = "hello\n next";
		String revision = "hello toby\n next";
		
		for (char c : original.toCharArray())
		{
			System.out.println(c + " " + (int) c);
		}

		System.out.println(DifferenceUtils.difference(original, revision));
	}
}