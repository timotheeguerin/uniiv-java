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

import ca.bendo.db.entity.lang.Translation;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SoftRatingElement</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_rating_method_element")
public class UniversityRatingMethodElement
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_rating_method_element", unique = true, nullable = false)
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * Link to the rating type.
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_rating_method")
	private UniversityRatingMethod type;

	/**
	 * 
	 */
	@Column(name = "weight")
	private int weight;

	/**
	 * 
	 */
	@Column(name = "image")
	private String image;

	/**
	 * 
	 */
	@Formula(Translation.FORMULA)
	private String translation;

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
	 * @return the type
	 */
	public UniversityRatingMethod getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final UniversityRatingMethod type)
	{
		this.type = type;
	}

	/**
	 * @return the weight
	 */
	public int getWeight()
	{
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(final int weight)
	{
		this.weight = weight;
	}

	/**
	 * @return the image
	 */
	public String getImage()
	{
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(final String image)
	{
		this.image = image;
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
