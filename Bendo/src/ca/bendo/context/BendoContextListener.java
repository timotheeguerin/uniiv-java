/**
 * 
 */
package ca.bendo.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ca.bendo.config.BendoConfig;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>BendoContextListener</b>
 *          <p>
 *          Setup stuff on server load
 *          </p>
 * 
 * 
 */
@Transactional
public class BendoContextListener implements ServletContextListener
{

	/**
	 * Logger.
	 */
	private Logger log = Logger.getLogger(BendoContextListener.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(final ServletContextEvent event)
	{

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	@Override
	public final void contextInitialized(final ServletContextEvent event)
	{

		WebApplicationContextUtils.getWebApplicationContext(event
				.getServletContext());

		log.info("BendoConfig loading ...");
		BendoConfig.loadConfig(event.getServletContext());
		log.info("BendoConfig loaded");

		// Set state
		// UserStateDAO userStateDao = (UserStateDAO)
		// springContext.getBean("userStateDAO");
		// UserFactory.setStates(userStateDao.list());
		// log.info("User state loaded");

		// Set permission

		log.info("User permisson loaded");

	}
}
