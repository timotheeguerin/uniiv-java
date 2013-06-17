/**
 * 
 */
package ca.bendo.head;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import ca.bendo.config.BendoConfig;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>RessourcesManager</b>
 *          <p>
 *          Manage style, scripts
 *          </p>
 * @see Filter
 * 
 */
public class RessourcesManager
{

	/**
	 * Logger.
	 */
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(RessourcesManager.class);

	/**
	 * Styles list.
	 */
	private LinkedList<String> styles = new LinkedList<String>();

	/**
	 * Scripts list.
	 */
	private LinkedList<String> scripts = new LinkedList<String>();

	/**
	 * Constructor load the styles and scripts from the BendoConfig.
	 */
	public RessourcesManager()
	{
		styles = BendoConfig.getConfig().getStyles();

		scripts = BendoConfig.getConfig().getScripts();
	}

	/**
	 * Add a new style sheet at the beginning of the list.
	 * 
	 * @param str
	 *            Stylesheet url
	 */
	public void prependStyleSheet(final String str)
	{
		this.styles.addFirst(str);
	}

	/**
	 * Add a new style sheet at the end of the list.
	 * 
	 * @param str
	 *            Stylesheet url
	 */
	public void appendStyleSheet(final String str)
	{
		this.styles.addLast(str);
	}

	/**
	 * Add a new script file at the beginning of the list.
	 * 
	 * @param str
	 *            Script url
	 */
	public void prependScript(final String str)
	{
		this.scripts.addFirst(str);
	}

	/**
	 * Add a new script file at the end of the list.
	 * 
	 * @param str
	 *            Script url
	 */
	public void appendScript(final String str)
	{
		this.scripts.addLast(str);
	}

	/**
	 * 
	 * @return the styles list
	 */
	public List<String> getStyles()
	{
		return this.styles;
	}

	/**
	 * 
	 * @return the script list
	 */
	public List<String> getScripts()
	{
		return this.scripts;
	}
}
