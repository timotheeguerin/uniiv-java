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
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.sql.JoinType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;

import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
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
	private List<Long> faculties = new ArrayList<Long>();

	/**
	 * 
	 */
	private List<Long> programs = new ArrayList<Long>();

	/**
	 * 
	 */
	private Map<Long, Long> softRatings = new HashMap<Long, Long>();

	/**
	 * @param criteria
	 *            Query criteria
	 */
	public void setupQuery(final Criteria criteria)
	{
		setupLocation(criteria);
		setupPrograms(criteria);
		setupSoftRating(criteria);
	}

	/**
	 * @param criteria
	 *            Query criteria
	 */
	public void setupLocation(final Criteria criteria)
	{
		criteria.createAlias("location", "locationAlias");
		criteria.createAlias("locationAlias.country", "country", JoinType.LEFT_OUTER_JOIN);

		Disjunction disjonction = Restrictions.disjunction();

		if (countries.size() > 0)
		{
			disjonction.add(Restrictions.in("country.id", countries));
		}
		if (states.size() > 0)
		{
			criteria.createAlias("locationAlias.state", "state", JoinType.LEFT_OUTER_JOIN);
			disjonction.add(Restrictions.in("state.id", states));
		}

		criteria.add(disjonction);

	}

	/**
	 * @param criteria
	 *            Query criteria
	 */
	public void setupPrograms(final Criteria criteria)
	{
		criteria.createAlias("programs", "program");
		criteria.createAlias("program.faculty", "faculty");
		Disjunction disjonction = Restrictions.disjunction();

		if (faculties.size() > 0)
		{
			disjonction.add(Restrictions.in("faculty.id", faculties));
		}
		if (programs.size() > 0)
		{
			disjonction.add(Restrictions.in("program.id", programs));
		}

		criteria.add(disjonction);
	}

	/**
	 * @param criteria
	 *            Query criteria
	 */
	public void setupSoftRating(final Criteria criteria)
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
