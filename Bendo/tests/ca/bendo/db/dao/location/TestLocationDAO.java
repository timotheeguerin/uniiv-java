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

import ca.bendo.db.entity.location.Location;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestLocationDAO</b>
 *          <p>
 *          </p>
 * @see LocationDAO
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestLocationDAO
{
	/**
	 * 
	 */
	@Autowired
	private LocationDAO locationDAO;

	/**
	 * Test the listLocation function.
	 * 
	 * @see LocationDAO#listLocations()
	 */
	@Test
	public void testListLocation()
	{
		List<Location> locations = locationDAO.listLocations();
		assertTrue(locations != null && locations.size() > 0);
		System.out.println("--------------------------------");
		System.out.println("Locations: ");
		System.out.printf("%-4s %-16s %s\n\n", "Id", "City", "Country(State)");
		for (Location location : locations)
		{
			System.out.printf("%-4s %-16s %s", location.getId(), location.getCity(), location.getCountry().toString());

			if (location.getState() != null)
			{
				System.out.println("(" + location.getState().toString() + ")");
			}
		}
	}

	/**
	 * @return the locationDAO
	 */
	public LocationDAO getLocationDAO()
	{
		return locationDAO;
	}

	/**
	 * @param locationDAO
	 *            the locationDAO to set
	 */
	public void setLocationDAO(final LocationDAO locationDAO)
	{
		this.locationDAO = locationDAO;
	}

}
