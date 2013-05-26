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
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>UrlSegmentTransaltion</b>
 *          <p>
 *          UrlSegmentTransaltion element from the UrlSegmentTransaltion table
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "lang_url_translation")
public class UrlSegmentTransaltion
{
	/**
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_lang_url_translation", nullable = false, unique = true)
	private long id;
	/**
	 */
	@Column(name = "key")
	private String key;
	/**
	 */
	@Column(name = "translation")
	private String translation;
	/**
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
	 * @return the translation
	 */
	public final String getTranslation()
	{
		return translation;
	}

	/**
	 * @param translation
	 *            the translation to set
	 */
	public final void setTranslation(final String translation)
	{
		this.translation = translation;
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

}
