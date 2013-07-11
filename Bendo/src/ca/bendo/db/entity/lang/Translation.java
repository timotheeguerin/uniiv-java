package ca.bendo.db.entity.lang;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

/**
 * 
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Translation</b>
 *          <p>
 *          Translation element from the lang_translation table
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "lang_translation")
@FilterDef(name = "language", parameters = @ParamDef(name = "param", type = "java.lang.String"))
public class Translation
{
	/**
	 * 
	 */
	public static final String FORMULA = "(SELECT t.translation FROM lang_translation t"
			+ " left join lang_language l ON t.id_lang_language = l.id_lang_language"
			+ " WHERE (t.key = name) AND l.key = :language.param)";
	/**
	 * Translation id.
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_lang_translation", nullable = false, unique = true)
	private long id;

	/**
	 * Translation key.
	 */
	@Column(name = "key")
	private String key;

	/**
	 * Translation value.
	 */
	@Column(name = "translation")
	private String translation;

	/**
	 * Translation language id.
	 */
	@ManyToOne
	@JoinColumn(name = "id_lang_language")
	private Language language;

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
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(final String key)
	{
		this.key = key;
	}

	/**
	 * @return the translation
	 */
	public String getTranslation()
	{
		return translation;
	}

	/**
	 * @param translation
	 *            the translation to set
	 */
	public void setTranslation(final String translation)
	{
		this.translation = translation;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage()
	{
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(final Language language)
	{
		this.language = language;
	}

	/**
	 * @return the translation
	 */
	@Override
	public String toString()
	{
		return this.translation;
	}

}
