/**
 * 
 */
package ca.bendo.db.dao.wiki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.entity.wiki.WikiPage;

/**
 * @author Timothée Guérin
 * @version Uniiv
 * 
 *          <b>TestWikiDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestWikiDAO
{
	@Autowired
	private WikiPageDAO pageDAO;

	/**
	 * 
	 */
	@Test
	public void test()
	{
		WikiPage wiki = pageDAO.getById(1L);
		System.out.println("Last wiki: " + wiki.getLastRevision());
		String str = wiki.getLastRevision().getContent().getContent();

		char[] chars = str.toCharArray();

		for (char c : chars)
		{
			System.out.println(c + " " + (int) c);
		}

	}
}
