/**
 * 
 */
package ca.bendo.db.entity.rating;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SoftRatingType</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_rating_method")
public class UniversityRatingMethod
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_rating_method", unique = true, nullable = false)
	private long id;
	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<UniversityRatingMethodElement> elements;

	/**
	 * 
	 */
	@Formula("(SELECT t.translation FROM lang_translation t "
			+ "WHERE (t.key = name) AND t.id_lang_language = :languageId.param)")
	private String translation;

	/**
	 * @param value
	 *            value
	 * @return elements
	 */
	public UniversityRatingMethodElement getElement(final long value)
	{
		for (UniversityRatingMethodElement element : elements)
		{
			if (element.getId() == value)
			{
				return element;
			}
		}
		return null;
	}

	/**
	 * @param value
	 *            value
	 * @return elements
	 */
	public UniversityRatingMethodElement getElementByWeight(final long value)
	{
		for (UniversityRatingMethodElement element : elements)
		{
			if (element.getWeight() == value)
			{
				return element;
			}
		}
		return null;
	}

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
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the elements
	 */
	public List<UniversityRatingMethodElement> getElements()
	{
		return elements;
	}

	/**
	 * @param elements
	 *            the elements to set
	 */
	public void setElements(final List<UniversityRatingMethodElement> elements)
	{
		this.elements = elements;
	}

	/**
	 * @return the translation
	 */
	public String getTranslation()
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
	public void setTranslation(final String translation)
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
