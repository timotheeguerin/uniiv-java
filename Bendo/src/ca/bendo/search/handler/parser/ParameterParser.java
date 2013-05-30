/**
 * 
 */
package ca.bendo.search.handler.parser;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ParameterParser</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public abstract class ParameterParser
{


	/**
	 * @param parameter Stirng to parse
	 */
	public abstract void parse(String parameter);

	/**
	 * Check if a string is numeric.
	 * 
	 * @param str
	 *            String to check
	 * @return boolean if the country/state is a integer
	 */
	protected boolean isNumeric(final String str)
	{
		try
		{
			Integer.parseInt(str);
		} catch (NumberFormatException nfe)
		{
			return false;
		}

		return true;
	}
	
	

	
}
