/**
 * 
 */
package ca.bendo.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ca.bendo.config.BendoConfig;
import ca.bendo.db.dao.HibernateInterceptor;

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
	public void contextInitialized(final ServletContextEvent event)
	{

		WebApplicationContext v = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());

		log.info("BendoConfig loading ...");
		BendoConfig.loadConfig(event.getServletContext());
		log.info("BendoConfig loaded");

		HibernateInterceptor interceptor = v.getBean(HibernateInterceptor.class);
		SessionFactory factory = v.getBean(SessionFactory.class);
		log.info("fac loaded");
		interceptor.setSessionFactory(factory);

		log.info("User permisson loaded");

	}
}
