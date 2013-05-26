/**
 * 
 */
package ca.bendo.db.entity.fees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniTuitionFeesType</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_fees_tuition_type")
public class UniversityTuitionFeesType
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_fees_tuition_type")
	private long id;

	/**
	 * 
	 */
	@Column(name = "name")
	private String name;

	/**
	 * @return the idUniFeesTuition
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the idUniFeesTuition to set
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

}
