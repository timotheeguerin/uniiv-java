package ca.bendo.db.entity.lang;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Link</b>
 *          <p>
 *          Link element from the link table
 *          </p>
 * 
 */
@Entity
@Table(name = "lang_link")
public class Link
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_lang_link", nullable = false, unique = true)
	private long id;
	/**
	 * 
	 */
	@Column(name = "key")
	private String key;
	/**
	 * 
	 */
	@Column(name = "link")
	private String link;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_lang_language")
	private Language language;

	/**
	 * @return the id
	 */
	public final long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(final long id)
	{
		this.id = id;
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
	 * @return the link
	 */
	public final String getLink()
	{
		return link;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	public final void setLink(final String link)
	{
		this.link = link;
	}

	/**
	 * @return the language
	 */
	public final Language getLanguage()
	{
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public final void setLanguage(final Language language)
	{
		this.language = language;
	}

	/**
	 * @return The link
	 */
	@Override
	public final String toString()
	{
		return getLink();
	}
}
