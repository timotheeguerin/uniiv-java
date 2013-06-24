/**
 * 
 */
package ca.bendo.db.dao.university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;

import ca.bendo.db.entity.program.Program;
import ca.bendo.db.entity.program.UniversityFaculty;
import ca.bendo.db.entity.university.University;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>UniversityQuery</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class UniversityQuery
{
	/**
	 * 
	 */
	private static final int ACCEPTABLE_MEAN = 5;

	/**
	 * 
	 */
	private List<Long> countries = new ArrayList<Long>();

	/**
	 * 
	 */
	private List<Long> states = new ArrayList<Long>();

	/**
	 * 
	 */
	private List<UniversityFaculty> faculties = new ArrayList<UniversityFaculty>();

	/**
	 * 
	 */
	private Map<Long, Long> softRatings = new HashMap<Long, Long>();

	/**
	 * @param criteria
	 *            Query criteria
	 */
	public void getRestrictions(final Criteria criteria)
	{
		setupLocation(criteria);
		// setupProgramCriterion(criteria);
		// setupSoftRatingCriterion(criteria);
	}

	/**
	 * @param criteria
	 *            Query criteria
	 * @return The generated location criterion
	 */
	public Criterion setupLocation(final Criteria criteria)
	{
		Criterion locations = null;
		criteria.createAlias("location.country", "country");
		Criterion countryCriterion = Restrictions.or();
		Criterion stateCriterion = Restrictions.or();
		
		if (countries.size() > 0)
		{
			countryCriterion = Restrictions.in("country.id", countries);
		}
		if (states.size() > 0)
		{
			criteria.createAlias("location.state", "state");
			stateCriterion = Restrictions.in("state.id", states);
		}

		criteria.add(Restrictions.or(countryCriterion, stateCriterion));
		return locations;
	}

	/**
	 * @param criteria
	 *            Query criteria
	 * @return The generated program criterion
	 */
	public Criterion setupProgramCriterion(final Criteria criteria)
	{
		Criterion programsCriterion = null;
		criteria.createAlias("programs", "programMap");
		criteria.createAlias("programs.program", "program");
		criteria.createAlias("program.faculty", "faculty");

		for (UniversityFaculty faculty : faculties)
		{
			Criterion facultyRestriction = Restrictions.eq("faculty.id", faculty.getId());

			if (faculty.hasPrograms())
			{
				Criterion programsRestriction = null;
				for (Program program : faculty.getPrograms())
				{
					Criterion programRestriction = Restrictions.eq("program.id", program.getId());
					if (programsRestriction == null)
					{
						programsRestriction = programRestriction;
					} else
					{
						programsRestriction = Restrictions.or(programsRestriction, programRestriction);
					}
				}

				facultyRestriction = Restrictions.and(facultyRestriction, programsRestriction);

			}
			if (programsCriterion == null)
			{
				programsCriterion = facultyRestriction;
			} else
			{
				programsCriterion = Restrictions.or(programsCriterion, facultyRestriction);
			}

		}
		if (programsCriterion == null)
		{
			programsCriterion = Restrictions.or();
		}
		criteria.add(programsCriterion);
		return programsCriterion;
	}

	/**
	 * @param criteria
	 *            Query criteria
	 * @return The generated softRating criterion
	 */
	public Criterion setupSoftRatingCriterion(final Criteria criteria)
	{
		Criterion ratingsCriterion = null;

		criteria.createAlias("softRatings", "softRatingMap");
		criteria.createAlias("softRatings.softRating", "softRating");
		criteria.createAlias("softRating.type", "type");
		criteria.createAlias("type.elements", "element");

		DetachedCriteria innerQuery = DetachedCriteria.forClass(University.class, "inner");

		innerQuery.createAlias("softRatings", "softRatingMap");
		innerQuery.createAlias("softRatings.softRating", "softRating");
		innerQuery.createAlias("softRating.type", "type");
		innerQuery.createAlias("type.elements", "element");

		innerQuery.setProjection(Projections.sqlProjection("SUM(weight * value) / SUM(weight) as mean",
				new String[] { "mean" }, new Type[] { new IntegerType() }));

		for (Entry<Long, Long> rating : softRatings.entrySet())
		{
			Criterion ratingIdCrt = Restrictions.eq("softRating.id", rating.getKey());
			Criterion typeIdCtr = Restrictions.eq("element.id", rating.getValue());

			Criterion ratingCriterion = Restrictions.and(ratingIdCrt, typeIdCtr);
			if (ratingsCriterion == null)
			{
				ratingsCriterion = ratingCriterion;
			} else
			{
				ratingsCriterion = Restrictions.or(ratingsCriterion, ratingCriterion);
			}

		}
		if (ratingsCriterion == null)
		{
			ratingsCriterion = Restrictions.or();
		}

		innerQuery.add(ratingsCriterion);

		criteria.add(Restrictions.or(Subqueries.lt(ACCEPTABLE_MEAN, innerQuery), Subqueries.eq(0, innerQuery)));

		return ratingsCriterion;
	}

	/**
	 * @return the countries
	 */
	public List<Long> getCountries()
	{
		return countries;
	}

	/**
	 * @param countries
	 *            the countries to set
	 */
	public void setCountries(final List<Long> countries)
	{
		this.countries = countries;
	}

	/**
	 * @return the states
	 */
	public List<Long> getStates()
	{
		return states;
	}

	/**
	 * @param states
	 *            the states to set
	 */
	public void setStates(final List<Long> states)
	{
		this.states = states;
	}

	/**
	 * @return the faculties
	 */
	public List<UniversityFaculty> getFaculties()
	{
		return faculties;
	}

	/**
	 * @param faculties
	 *            the faculties to set
	 */
	public void setFaculties(final List<UniversityFaculty> faculties)
	{
		this.faculties = faculties;
	}

	/**
	 * @return the softRatings
	 */
	public Map<Long, Long> getSoftRatings()
	{
		return softRatings;
	}

	/**
	 * @param softRatings
	 *            the softRatings to set
	 */
	public void setSoftRatings(final Map<Long, Long> softRatings)
	{
		this.softRatings = softRatings;
	}
}
