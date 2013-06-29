/**
 * 
 */
package ca.bendo.form.entity;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FormItem</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FormItem
{
	/**
	 * 
	 */
	private String value;

	/**
	 * 
	 */
	private String label;

	/**
	 * 
	 */
	public FormItem()
	{

	}

	/**
	 * 
	 * @param value
	 *            Value
	 * @param label
	 *            Label
	 */
	public FormItem(final String value, final String label)
	{
		this.value = value;
		this.label = label;
	}

	/**
	 * 
	 * @param val
	 *            val
	 * @return string
	 */
	public String custom(final String val)
	{
		return val + value;
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
	 * @return the label
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(final String label)
	{
		this.label = label;
	}

}
