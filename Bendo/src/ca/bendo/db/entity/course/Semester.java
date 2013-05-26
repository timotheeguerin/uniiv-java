/**
 * 
 */
package ca.bendo.db.entity.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Semester</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "semester")
public class Semester
{

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_semester")
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@Formula("(SELECT t.translation FROM lang_translation t "
			+ "WHERE (t.key = name) AND t.id_lang_language = :languageId.param)")
	private String translation;

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
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the translation
	 */
	public final String getTranslation()
	{
		if (translation == null)
		{
			return name;
		} else
		{
			return translation;
		}
	}

	/**
	 * @param translation
	 *            the translation to set
	 */
	public final void setTranslation(final String translation)
	{
		this.translation = translation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return getTranslation();
	}
}
