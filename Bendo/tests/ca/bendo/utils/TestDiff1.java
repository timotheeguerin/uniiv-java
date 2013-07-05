/**
 * 
 */
package ca.bendo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

	private String fileToStr(final String filename)
	{
		StringBuilder result = new StringBuilder();
		String line = "";
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null)
			{
				result.append(line).append("\n");
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * 
	 */
	@Test
	public void test()
	{
		String original = fileToStr("test/file_old.txt");
		String revision = fileToStr("test/file_new.txt");

		System.out.println(DifferenceUtils.difference(original, revision));
	}
}