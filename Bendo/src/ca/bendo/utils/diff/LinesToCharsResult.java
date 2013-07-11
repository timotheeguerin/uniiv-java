/**
 * 
 */
package ca.bendo.utils.diff;

import java.util.List;

/**
 * @author Timothée Guérin
 * @version Bendo 

 * <b>ef</b>
 * <p></p>
 *
 * 


 */
/**
 * Internal class for returning results from diff_linesToChars(). Other less
 * paranoid languages just use a three-element array.
 */
public class LinesToCharsResult
{
	/**
	 * 
	 */
	private String chars1;
	/**
	 * 
	 */
	private String chars2;
	/**
	 * 
	 */
	private List<String> lineArray;

	/**
	 * 
	 * @param chars1
	 *            Char1
	 * @param chars2
	 *            Char2
	 * @param lineArray
	 *            Linearray
	 */
	protected LinesToCharsResult(final String chars1, final String chars2, final List<String> lineArray)
	{
		this.chars1 = chars1;
		this.chars2 = chars2;
		this.lineArray = lineArray;
	}

	/**
	 * @return the chars1
	 */
	public String getChars1()
	{
		return chars1;
	}

	/**
	 * @param chars1
	 *            the chars1 to set
	 */
	public void setChars1(final String chars1)
	{
		this.chars1 = chars1;
	}

	/**
	 * @return the chars2
	 */
	public String getChars2()
	{
		return chars2;
	}

	/**
	 * @param chars2
	 *            the chars2 to set
	 */
	public void setChars2(final String chars2)
	{
		this.chars2 = chars2;
	}

	/**
	 * @return the lineArray
	 */
	public List<String> getLineArray()
	{
		return lineArray;
	}

	/**
	 * @param lineArray
	 *            the lineArray to set
	 */
	public void setLineArray(final List<String> lineArray)
	{
		this.lineArray = lineArray;
	}

}
