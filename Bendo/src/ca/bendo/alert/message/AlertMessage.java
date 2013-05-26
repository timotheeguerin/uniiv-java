/**
 * 
 */
package ca.bendo.alert.message;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>AlertMessage</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class AlertMessage
{

	/**
	 * Key.
	 */
	private String key;

	/**
	 * Message that will be display.
	 */
	private String msg;

	/**
	 * Type of Message.
	 * 
	 * @See AlertMessageType
	 */
	private AlertMessageType type;

	/**
	 * @param key
	 *            Ket to set
	 * @param msg
	 *            Msg to set
	 * @param type
	 *            Type to set
	 */
	public AlertMessage(final String key, final String msg, final AlertMessageType type)
	{
		setKey(key);
		setMsg(msg);
		setType(type);
	}

	/**
	 * @return the key
	 */
	public final String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public final void setKey(final String key)
	{
		this.key = key;
	}

	/**
	 * @return the msg
	 */
	public final String getMsg()
	{
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public final void setMsg(final String msg)
	{
		this.msg = msg;
	}

	/**
	 * @return the type
	 */
	public final AlertMessageType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final AlertMessageType type)
	{
		this.type = type;
	}

}
