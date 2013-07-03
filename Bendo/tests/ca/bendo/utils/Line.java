/**
 * 
 */
package ca.bendo.utils;

import org.apache.commons.lang.ObjectUtils;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Line</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class Line
{
	/**
	 * 
	 */
	private long id;

	/**
	 * 
	 */
	private String text;

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id)
	{
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text)
	{
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj)
	{
		if (obj instanceof Line)
		{
			Line l = (Line) obj;
			return ObjectUtils.equals(text, l.text);
		} else
		{
			return false;
		}
	}
}
