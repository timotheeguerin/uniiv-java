/**
 * 
 */
package ca.bendo.search.handler.parser;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.form.FieldValidator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProgramParser</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class ProgramParser extends ParameterParser
{
	/**
	 * 
	 */
	public ProgramParser()
	{
	}

	/**
	 * 
	 */
	private List<Long> faculties = new ArrayList<Long>();

	/**
	 * 
	 */
	private List<Long> programs = new ArrayList<Long>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.bendo.search.handler.parser.ParameterParser#parse(java.lang.String)
	 */
	@Override
	public void parse(final String parameter)
	{
		if (parameter != null && parameter.length() > 0)
		{
			for (String s : parameter.split(","))
			{
				s.trim();

				// If any state are specified
				if (s.contains("(") && s.endsWith(")"))
				{
					String programsStr = s.substring(s.indexOf("(") + 1, s.length() - 1);

					for (String programStr : programsStr.split(";"))
					{
						if (FieldValidator.isInt(programStr))
						{
							programs.add(Long.parseLong(programStr));
						}
					}

				} else
				{

					// If there is only the country
					if (FieldValidator.isInt(s))
					{

						faculties.add(Long.parseLong(s));
					}
				}

			}
		}
	}

	/**
	 * @return the faculties
	 */
	public List<Long> getFaculties()
	{
		return faculties;
	}

	/**
	 * @param faculties
	 *            the faculties to set
	 */
	public void setFaculties(final List<Long> faculties)
	{
		this.faculties = faculties;
	}

	/**
	 * @return the programs
	 */
	public List<Long> getPrograms()
	{
		return programs;
	}

	/**
	 * @param programs
	 *            the programs to set
	 */
	public void setPrograms(final List<Long> programs)
	{
		this.programs = programs;
	}

}
