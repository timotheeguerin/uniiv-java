/**
 * 
 */
package ca.bendo.db.entity.fees;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import ca.bendo.math.Range;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityFees</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_fees")
public class UniversityFees
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_fees", unique = true, nullable = false)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_currency")
	private Currency currency;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "fees", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<UniversityTuitionFees> tuitionFees;

	/**
	 * 
	 */
	@OneToOne(mappedBy = "fees", cascade = CascadeType.ALL)
	private UniversityOtherFees otherFees;

	/**
	 * 
	 * @return the range of the fees
	 */
	public Range<Integer> getRange()
	{
		Range<Integer> range = new Range<Integer>();

		Range<Integer> tuitionRange = getTuitionFeesRange();
		range.setMinimum(tuitionRange.getMinimum() + otherFees.getMinimum());
		range.setMaximum(tuitionRange.getMaximum() + otherFees.getMaximum());

		return range;
	}

	/**
	 * 
	 * @return the range of the fees
	 */
	public Range<Integer> getTuitionFeesRange()
	{

		Range<Integer> range = new Range<Integer>();
		if (tuitionFees != null && tuitionFees.size() > 0)
		{
			range.setMinimum(tuitionFees.get(0).getValue());
			range.setMaximum(tuitionFees.get(0).getValue());

			for (int i = 1; i < tuitionFees.size(); i++)
			{
				int value = tuitionFees.get(i).getValue();
				if (value < range.getMinimum())
				{
					range.setMinimum(value);
				} else if (value > range.getMaximum())
				{
					range.setMaximum(value);
				}
			}
		} else
		{
			range.setMinimum(0);
			range.setMaximum(0);
		}

		return range;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		Range<Integer> range = getRange();

		return range.getMinimum() + currency.getSymbol() + " - " + range.getMaximum() + currency.getSymbol();
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
	 * @return the currency
	 */
	public Currency getCurrency()
	{
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(final Currency currency)
	{
		this.currency = currency;
	}

	/**
	 * @return the tuitionFees
	 */
	public List<UniversityTuitionFees> getTuitionFees()
	{
		return tuitionFees;
	}

	/**
	 * @param tuitionFees
	 *            the tuitionFees to set
	 */
	public void setTuitionFees(final List<UniversityTuitionFees> tuitionFees)
	{
		this.tuitionFees = tuitionFees;
	}

	/**
	 * @return the otherFees
	 */
	public UniversityOtherFees getOtherFees()
	{
		return otherFees;
	}

	/**
	 * @param otherFees
	 *            the otherFees to set
	 */
	public void setOtherFees(final UniversityOtherFees otherFees)
	{
		this.otherFees = otherFees;
	}

}
