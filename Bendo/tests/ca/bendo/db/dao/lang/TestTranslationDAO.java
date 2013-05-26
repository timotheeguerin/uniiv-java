/**
 * 
 */
package ca.bendo.db.dao.lang;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.lang.Translation;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestTranslationDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestTranslationDAO
{
	/**
	 * 
	 */
	private static final Long ID_ENG = 1L;

	/**
	 * 
	 */
	@Autowired
	private TranslationsDAO translationsDAO;

	/**
	 * @see TranslationsDAO#listTranslations()
	 */
	@Test
	public void testListTranslations()
	{
		List<Translation> translations = translationsDAO.listTranslations();
		assertTrue(translations != null);

		System.out.println("------------------------------------------------------------------");
		System.out.println("All translations: ");
		for (Translation translation : translations)
		{
			System.out.printf("%-10s %s\n", translation.getKey(), translation.getTranslation());
		}
	}

	/**
	 * @see TranslationsDAO#listTranslations()
	 */
	@Test
	public void testGetTranslation()
	{
		Translation translation = translationsDAO.getTranslation("nz", 1L);
		assertTrue(translation != null);

		System.out.println("------------------------------------------------------------------");
		System.out.println("One translations: ");
		System.out.println(translation.getTranslation());

	}

	/**
	 * @see TranslationsDAO#listTranslations(long)
	 */
	@Test
	public void testListTranslationsWithID()
	{
		Map<String, Translation> translations = translationsDAO.listTranslations(ID_ENG);
		assertTrue(translations != null);

		System.out.println("------------------------------------------------------------------");
		System.out.println("Translations in eng: ");

		for (Translation translation : translations.values())
		{
			System.out.printf("%-10s %s\n", translation.getKey(), translation.getTranslation());
		}
	}
}
