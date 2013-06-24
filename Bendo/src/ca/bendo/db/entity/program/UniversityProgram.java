/**
 * 
 */
package ca.bendo.db.entity.program;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityPrograms</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "uni_university_program")
public class UniversityProgram
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_uni_university_program")
	private long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_university")
	private University university;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_uni_program")
	private Program program;

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
	 * @return the university
	 */
	public University getUniversity()
	{
		return university;
	}

	/**
	 * @param university
	 *            the university to set
	 */
	public void setUniversity(final University university)
	{
		this.university = university;
	}

	/**
	 * @return the program
	 */
	public Program getProgram()
	{
		return program;
	}

	/**
	 * @param program
	 *            the program to set
	 */
	public void setProgram(final Program program)
	{
		this.program = program;
	}

	/**
	 * 
	 * @author Timothée Guérin
	 * @version Bendo
	 * 
	 *          <b>UniversityProgramsComparator</b>
	 *          <p>
	 *          </p>
	 * 
	 * 
	 */
	public static class UniversityProgramsComparator implements Comparator<UniversityProgram>
	{

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(final UniversityProgram o1, final UniversityProgram o2)
		{
			if (o1.getProgram().getTranslation() == null)
			{
				return -1;
			} else if (o2.getProgram().getTranslation() == null)
			{
				return 1;
			}

			return o1.getProgram().getTranslation().compareTo(o2.getProgram().getTranslation());
		}

	}

}
