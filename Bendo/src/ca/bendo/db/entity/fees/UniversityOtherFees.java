/**
 * 
 */
package ca.bendo.db.entity.fees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>price</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_fees_other")
public class UniversityOtherFees
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "fees"))
	@Column(name = "id_uni_fees")
	private long id;

	/**
	 * 
	 */
	@Column(name = "min")
	private int minimum;

	/**
	 * 
	 */
	@Column(name = "max")
	private int maximum;

	/**
	 * 
	 */
	@OneToOne
	@PrimaryKeyJoinColumn
	private UniversityFees fees;

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
	 * @return the minimum
	 */
	public int getMinimum()
	{
		return minimum;
	}

	/**
	 * @param minimum
	 *            the minimum to set
	 */
	public void setMinimum(final int minimum)
	{
		this.minimum = minimum;
	}

	/**
	 * @return the maximum
	 */
	public int getMaximum()
	{
		return maximum;
	}

	/**
	 * @param maximum
	 *            the maximum to set
	 */
	public void setMaximum(final int maximum)
	{
		this.maximum = maximum;
	}

	/**
	 * @return the fees
	 */
	public UniversityFees getFees()
	{
		return fees;
	}

	/**
	 * @param fees the fees to set
	 */
	public void setFees(final UniversityFees fees)
	{
		this.fees = fees;
	}

}
