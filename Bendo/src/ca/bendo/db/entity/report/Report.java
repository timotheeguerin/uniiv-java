/**
 * 
 */
package ca.bendo.db.entity.report;

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
 *          <b>Report</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "report")
public class Report
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_report", nullable = false, unique = true)
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_report_type")
	private ReportType type;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_report_comment")
	private ReportComment comment;

	/**
	 * 
	 */
	@Column(name = "id_element")
	private long element;

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
	 * @return the type
	 */
	public ReportType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final ReportType type)
	{
		this.type = type;
	}

	/**
	 * @return the comment
	 */
	public ReportComment getComment()
	{
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(final ReportComment comment)
	{
		this.comment = comment;
	}

	/**
	 * @return the element
	 */
	public long getElement()
	{
		return element;
	}

	/**
	 * @param element
	 *            the element to set
	 */
	public void setElement(final long element)
	{
		this.element = element;
	}

}
