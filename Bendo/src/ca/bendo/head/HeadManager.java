/**
 * 
 */
package ca.bendo.head;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>HeadManager</b>
 *          <p>
 *          </p>
 * @see Filter
 * 
 */
public class HeadManager
{

	/**
	 * Ressource manager.
	 */
	private RessourcesManager ressources;

	/**
	 * Title of the page.
	 */
	private Title title;

	/**
	 * 
	 */
	public HeadManager()
	{
		setRessources(new RessourcesManager());
		title = new Title();
		title.setTitlePrefix("Uniiv");
		title.setSeparator(" - ");
	}

	/**
	 * 
	 * @param request
	 *            Http request
	 * @return headmanager loaded from the request
	 */
	public static HeadManager load(final HttpServletRequest request)
	{
		return (HeadManager) request.getAttribute("head");
	}

	/**
	 * 
	 * @return the title
	 */
	public Title getTitle()
	{
		return title;
	}

	/**
	 * 
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final Title title)
	{
		this.title = title;
	}

	/**
	 * @return the ressources
	 */
	public RessourcesManager getRessources()
	{
		return ressources;
	}

	/**
	 * @param ressources
	 *            the ressources to set
	 */
	public void setRessources(final RessourcesManager ressources)
	{
		this.ressources = ressources;
	}
}
