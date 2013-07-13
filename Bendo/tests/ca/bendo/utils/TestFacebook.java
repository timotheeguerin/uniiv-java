/**
 * 
 */
package ca.bendo.utils;

import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.utils.facebook.FacebookUtils;
import ca.bendo.utils.facebook.Place;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestFacebook</b>
 *          <p>
 *          </p>
 * 
 * 
 */
 @RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration(locations = { "classpath:applicationContext.xml" })
 @Transactional
public class TestFacebook
{
	@Autowired
	private FacebookUtils facebook;

	/**
	 * 
	 */
	@Test
	public void testFacebook()
	{
		ClassLoader cl = ClassLoader.getSystemClassLoader();

		URL[] urls = ((URLClassLoader) cl).getURLs();

		for (URL url : urls)
		{
			System.out.println(url.getFile());
		}
		Place place = facebook.getPlace("445044678861631");

		System.out.println(place);
		System.out.println(place.getLikes());

	}
}
