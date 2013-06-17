/**
 * 
 */
package ca.bendo.db.dao.location;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.location.Country;
import ca.bendo.db.entity.location.State;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestCountryDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestCountryDAO
{
	/**
	 * 
	 */
	private static final long ID_CANADA = 9;
	/**
	 * 
	 */
	private static final long ID_USA = 55;
	/**
	 * 
	 */
	private static final long ID_NOSTATE = 2;

	/**
	 * 
	 */
	@Autowired
	private CountryDAO countryDAO;

	/**
	 * Test the GetUserLoginTypes from the UserLoginTypeDAO class.
	 * 
	 * @see CountryDAO#listCountries()
	 */
	@Test
	public void testListCountries()
	{
		countryDAO.setLanguageId(1);
		List<Country> l = countryDAO.listCountries();

		assertTrue(l != null);

		System.out.println("id - countrykey");
		for (Country country : l)
		{
			System.out.println(country.getId() + " " + country.getCountry() + " " + country.toString());
		}

	}

	/**
	 * 
	 */
	@Test
	public void testGetStatesInCountry()
	{
		countryDAO.setLanguageId(1);
		// Canada
		List<State> l = countryDAO.getById(ID_CANADA).getStates();

		assertTrue(l != null && l.size() > 0);

		System.out.println("result | id - state - countryId ");
		for (State state : l)
		{
			System.out.println(state.getId() + " - " + state + " - " + state.getCountry());
		}

		// USA
		l = countryDAO.getById(ID_USA).getStates();
		assertTrue(l != null);
		// other
		l = countryDAO.getById(ID_NOSTATE).getStates();
		assertTrue(l != null && l.size() == 0);

	}

	/**
	 * @return the countryDAO
	 */
	public CountryDAO getCountryDAO()
	{
		return countryDAO;
	}

	/**
	 * @param countryDAO
	 *            the countryDAO to set
	 */
	public void setCountryDAO(final CountryDAO countryDAO)
	{
		this.countryDAO = countryDAO;
	}
}
