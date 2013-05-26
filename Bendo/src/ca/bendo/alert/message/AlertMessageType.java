/**
 * 
 */
package ca.bendo.alert.message;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>AlertMessageType</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public enum AlertMessageType
{

	/**
	 * Type enum.
	 */
	Info, Error, Debug, Warning;

	/**
	 * @return Enum in string
	 */
	public String toString()
	{
		if (this.equals(AlertMessageType.Info))
		{
			return "info";
		} else if (this.equals(AlertMessageType.Error))
		{
			return "err";
		} else if (this.equals(AlertMessageType.Debug))
		{
			return "debug";
		} else if (this.equals(AlertMessageType.Warning))
		{
			return "warning";
		} else
		{
			return null;
		}
	}

	/**
	 * Convert a string to an AlertMessageType.
	 * 
	 * @param str
	 *            String to convert
	 * @return The type
	 */
	public AlertMessageType fromString(final String str)
	{
		AlertMessageType type = null;
		if (str.equals("err"))
		{
			type = AlertMessageType.Error;
		} else if (str.equals("info"))
		{
			type = AlertMessageType.Info;
		} else if (str.equals("warning"))
		{
			type = AlertMessageType.Warning;
		} else if (str.equals("debug"))
		{
			type = AlertMessageType.Debug;
		}

		return type;
	}
}
