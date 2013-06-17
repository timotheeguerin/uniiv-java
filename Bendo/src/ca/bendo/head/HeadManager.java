/**
 * 
 */
package ca.bendo.head;

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
