/**
 * 
 */
package ca.bendo.search.handler.parser;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.db.entity.program.UniversityFaculty;
import ca.bendo.db.entity.program.UniversityProgram;

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
	private List<UniversityFaculty> faculties = new ArrayList<UniversityFaculty>();

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
				UniversityFaculty faculty = new UniversityFaculty();
				String facultyStr = "";
				s.trim();

				// If any program are specified
				if (s.contains("(") && s.endsWith(")"))
				{

					facultyStr = s.substring(0, s.indexOf("("));

					String programsStr = s.substring(s.indexOf("(") + 1, s.length() - 1);

					for (String programStr : programsStr.split(";"))
					{
						if (isNumeric(programStr))
						{
							UniversityProgram program = new UniversityProgram();
							program.setId(Integer.parseInt(programStr));
							faculty.addProgram(program);
						}
					}

				} else
				{
					// If there is only the faculty
					facultyStr = s;
				}

				if (isNumeric(facultyStr))
				{
					faculty.setId(Integer.parseInt(facultyStr));
					faculties.add(faculty);
				}
			}
		}
	}

	/**
	 * @return the faculties
	 */
	public final List<UniversityFaculty> getFaculties()
	{
		return faculties;
	}
	
}
