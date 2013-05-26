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

import ca.bendo.db.entity.location.State;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestStateDAO</b>
 *          <p>
 *          </p>
 * 
 * @see StateDAO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestStateDAO
{

	/**
	 * 
	 */
	@Autowired
	private StateDAO stateDao;

	/**
	 * Test the GetUserLoginTypes from the UserLoginTypeDAO class.
	 * 
	 * @see StateDAO#testListStates
	 */
	@Test
	public final void testListStates()
	{
		stateDao.setLanguageId(1);
		List<State> l = stateDao.listStates();
		assertTrue(l != null);
		System.out.println("---------------------------------------------------");
		System.out.println("States: ");
		for (State state : l)
		{
			System.out.printf("%-4s %s\n", state.getId(), state.toString());
		}
	}

	/**
	 * Test the GetUserLoginTypes from the UserLoginTypeDAO class.
	 * 
	 * @see UserLoginTypeDAO#GetUserLoginTypes
	 */
	@Test
	public final void testGetState()
	{

		List<State> l = stateDao.listStates();
		assertTrue(l != null);

		System.out.println("result | id - state - countryId ");
		for (State state : l)
		{

			State stateCheck = stateDao.getById(state.getId());

			boolean b = (stateCheck != null && state.getId() == stateCheck.getId());
			System.out.println((state.getId() == stateCheck.getId()) + " | " + state.getId() + " - "
					+ stateCheck.getId() + " - " + state + " - " + state.getCountry());

			assertTrue(b);

		}

	}

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
	@Test
	public final void testGetStatesInCountry()
	{

		// Canada
		List<State> l = stateDao.getStateInCountry(ID_CANADA);
		assertTrue(l != null && l.size() > 0);

		// USA
		l = stateDao.getStateInCountry(ID_USA);
		assertTrue(l != null);
		// other
		l = stateDao.getStateInCountry(ID_NOSTATE);
		assertTrue(l != null && l.size() == 0);

		System.out.println("result | id - state - countryId ");
		for (State state : l)
		{
			System.out.println(state.getId() + " - " + state + " - " + state.getCountry());
		}

	}

	/**
	 * Test the update state method.
	 */
	@Test
	public void testUpdateState()
	{
		State sState = stateDao.getById(1L);
		String startState = new String(sState.getState());
		System.out.println("Started: " + startState);

		sState.setState("TT");
		stateDao.update(sState);

		sState = stateDao.getById(1L);
		System.out.println("Updated: " + sState.getState());
		assertTrue(sState.getState().equals("TT"));

		System.out.println("StartedU: " + startState);

		sState.setState(startState);
		stateDao.update(sState);

		sState = stateDao.getById(1L);
		System.out.println("Final  : " + sState.getState());
		assertTrue(sState.getState().equals(startState));

	}

	/**
	 * @return the stateDao
	 */
	public final StateDAO getStateDao()
	{
		return stateDao;
	}

	/**
	 * @param stateDao
	 *            the stateDao to set
	 */
	public final void setStateDao(final StateDAO stateDao)
	{
		this.stateDao = stateDao;
	}
}
