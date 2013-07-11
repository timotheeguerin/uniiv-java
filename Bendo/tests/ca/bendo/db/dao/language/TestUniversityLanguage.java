/**
 * 
 */
package ca.bendo.db.dao.language;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.language.UniversityLanguage;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestUniversityLanguage</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestUniversityLanguage
{
	/**
	 * 
	 */
	@Autowired
	private UniversityLanguageDAO languageDAO;

	/**
	 * 
	 *
	 */
	@Test
	public void testListLanguage()
	{
		List<UniversityLanguage> languages = languageDAO.list();

		assertTrue(languages != null);
		for (UniversityLanguage language : languages)
		{
			System.out.printf("%-4s %-10s %s\n", language.getId(), language.getName(), language.getTranslation());
		}
	}
}
