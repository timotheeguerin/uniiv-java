/**
 * 
 */
package ca.bendo.json;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Suggestion</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Suggestion
{
	/**
	 * 
	 */
	private String value;

	/**
	 * 
	 */
	private String data;

	/**
	 * 
	 */
	private String type = "none";

	/**
	 * 
	 */
	public Suggestion()
	{
		//
	}

	/**
	 * @param value
	 *            for initialisation
	 * @param data
	 *            for initialisation
	 */
	public Suggestion(final String value, final String data)
	{
		super();
		this.value = value;
		this.data = data;
	}

	/**
	 * @param value
	 *            for initialisation
	 * @param data
	 *            for initialisation
	 * 
	 * @param type
	 *            for initialisation
	 */
	public Suggestion(final String value, final String data, final String type)
	{
		super();
		this.value = value;
		this.data = data;
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final String value)
	{
		this.value = value;
	}

	/**
	 * @return the data
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(final String data)
	{
		this.data = data;
	}

	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final String type)
	{
		this.type = type;
	}

}
