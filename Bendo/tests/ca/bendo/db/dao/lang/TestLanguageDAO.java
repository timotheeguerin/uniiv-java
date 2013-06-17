/**
 * 
 */
package ca.bendo.db.dao.lang;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.lang.Language;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestLanguageDAO</b>
 *          <p>
 *          </p>
 * @see LanguageDAO
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestLanguageDAO
{
	/**
	 * 
	 */
	@Autowired
	private LanguageDAO languageDAO;

	/**
	 * Test the GetUserLoginTypes from the UserLoginTypeDAO class.
	 * 
	 * @see LanguageDAO#listLanguages()
	 */
	@Test
	public void testGetCountries()
	{

		List<Language> l = languageDAO.listLanguages();
		assertTrue(l != null);

		System.out.println("id - key - lowername - fullname");
		for (Language t : l)
		{
			System.out.println(t.getId() + " - " + t.getKey() + " - " + t.getName());
		}

	}

	/**
	 * @return the languageDAO
	 */
	public LanguageDAO getLanguageDAO()
	{
		return languageDAO;
	}

	/**
	 * @param languageDAO
	 *            the languageDAO to set
	 */
	public void setLanguageDAO(final LanguageDAO languageDAO)
	{
		this.languageDAO = languageDAO;
	}
}
