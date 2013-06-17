/**
 * 
 */
package ca.bendo.head;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Title</b>
 *          <p>
 *          Contains the title
 *          </p>
 * @see Filter
 * 
 */
public class Title
{

	/**
	 * Title.
	 */
	private String title;

	/**
	 * Title suffix.
	 */
	private String titleSuffix;

	/**
	 * Title prefix.
	 */
	private String titlePrefix;

	/**
	 * Title separator.
	 */
	private String separator = "";

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final String title)
	{
		this.title = title;
	}

	/**
	 * @return the titleSuffix
	 */
	public String getTitleSuffix()
	{
		return titleSuffix;
	}

	/**
	 * @param titleSuffix
	 *            the titleSuffix to set
	 */
	public void setTitleSuffix(final String titleSuffix)
	{
		this.titleSuffix = titleSuffix;
	}

	/**
	 * @return the titlePrefix
	 */
	public String getTitlePrefix()
	{
		return titlePrefix;
	}

	/**
	 * @param titlePrefix
	 *            the titlePrefix to set
	 */
	public void setTitlePrefix(final String titlePrefix)
	{
		this.titlePrefix = titlePrefix;
	}

	/**
	 * @return the separator
	 */
	public String getSeparator()
	{
		return separator;
	}

	/**
	 * @param separator
	 *            the separator to set
	 */
	public void setSeparator(final String separator)
	{
		this.separator = separator;
	}

	/**
	 * Return the full title.
	 * 
	 * @return the rendered title
	 */
	public String render()
	{
		String result = "";
		if (this.titlePrefix != null)
		{
			result += this.titlePrefix;
			if (this.title != null)
			{
				result += this.separator;
			}
		}

		if (this.title != null)
		{
			result += this.title;
		}

		if (this.titleSuffix != null)
		{
			result += this.separator + this.titleSuffix;
		}

		return result;
	}

	/*
	 * (non-javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return render();
	}

}
