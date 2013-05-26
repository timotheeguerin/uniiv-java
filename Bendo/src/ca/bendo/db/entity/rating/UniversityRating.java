/**
 * 
 */
package ca.bendo.db.entity.rating;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SoftRatinh</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "rating")
public class UniversityRating
{

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_rating", unique = true, nullable = false)
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_rating_method")
	private UniversityRatingMethod type;
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_rating_form")
	private UniversityRatingForm form;
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
	 * @return the type
	 */
	public final UniversityRatingMethod getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final UniversityRatingMethod type)
	{
		this.type = type;
	}

	/**
	 * @return the translation
	 */
	public final String getTranslation()
	{
		if (translation != null)
		{
			return translation;
		} else
		{
			return name;
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

	
	/**
	 * @return the form
	 */
	public final UniversityRatingForm getForm()
	{
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public final void setForm(final UniversityRatingForm form)
	{
		this.form = form;
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
