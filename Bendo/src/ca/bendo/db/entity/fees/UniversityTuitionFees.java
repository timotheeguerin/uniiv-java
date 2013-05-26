/**
 * 
 */
package ca.bendo.db.entity.fees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniTuitionFees</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_fees_tuition")
public class UniversityTuitionFees
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_fees_tuition")
	private long id;

	/**
	 * 
	 */
	@Column(name = "value")
	private int value;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_fees_tuition_type")
	private UniversityTuitionFeesType type;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_fees")
	private UniversityFees fees;

	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final int value)
	{
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public UniversityTuitionFeesType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final UniversityTuitionFeesType type)
	{
		this.type = type;
	}

	/**
	 * @return the idFees
	 */
	public UniversityFees getFees()
	{
		return fees;
	}

	/**
	 * @param fees
	 *            the fees to set
	 */
	public void setFees(final UniversityFees fees)
	{
		this.fees = fees;
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
}
