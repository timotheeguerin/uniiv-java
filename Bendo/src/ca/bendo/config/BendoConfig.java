/**
 * 
 */
package ca.bendo.config;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.velocity.app.Velocity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>BendoConfig</b>
 *          <p>
 *          </p>
 * 
 * 
 */

public final class BendoConfig
{

	/**
	 * Config file name and path.
	 */
	private static final String CONFIG_FILE = "/WEB-INF/config/bendo/bendo-config.xml";
	/**
	 * Logger.
	 */
	private static Logger log = Logger.getLogger(BendoConfig.class);

	/**
	 * 
	 */
	private ServletContext servletContext;

	/**
	 * 
	 */
	private LinkedList<String> styles = new LinkedList<String>();

	/**
	 * 
	 */
	private LinkedList<String> scripts = new LinkedList<String>();

	/**
	 * 
	 */
	private String defaultEmail;

	/**
	 * 
	 */
	private Properties properties = new Properties();

	/**
	 * 
	 */
	private static BendoConfig config;

	/**
	 * Default contructor.
	 */
	private BendoConfig()
	{

	}

	/**
	 * Load the config. Called when on server launch.
	 * 
	 * @param servletContext
	 *            Servlet context
	 * @return The config
	 */
	public static BendoConfig loadConfig(final ServletContext servletContext)
	{
		config = new BendoConfig();
		config.setServletContext(servletContext);
		config.initialise();
		return config;
	}

	/**
	 * Load the config file.
	 */
	public void initialise()
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try
		{
			db = dbf.newDocumentBuilder();
			String in = getServletContext().getRealPath(CONFIG_FILE);
			Document doc = db.parse(in);
			loadStyles(doc);
			loadScripts(doc);
			loadDefaultEmail(doc);
			loadProperties(doc);
			log.info("Bendo config initialise complete");

		} catch (ParserConfigurationException e)
		{

			e.printStackTrace();
		} catch (SAXException e)
		{

			e.printStackTrace();
		} catch (IOException e)
		{

			e.printStackTrace();

		}

		initVelocityEngine("");
	}

	/**
	 * Load the styles filename from the config file.
	 * 
	 * @param doc
	 *            Document containg the styles filename
	 */
	public void loadStyles(final Document doc)
	{
		NodeList stylesNode = doc.getElementsByTagName("styles");
		if (stylesNode != null)
		{
			for (int i = 0; i < stylesNode.getLength(); i++)
			{
				Element element = (Element) stylesNode.item(i);
				NodeList stylesList = element.getElementsByTagName("style");

				for (int j = 0; j < stylesList.getLength(); j++)
				{
					Element stylesElement = (Element) stylesList.item(j);
					String style = stylesElement.getChildNodes().item(0).getNodeValue();
					log.info("Styles sheets loaded: " + style);
					getStyles().add(style);
				}
			}
		}
	}

	/**
	 * Load the scipts filename from the config file.
	 * 
	 * @param doc
	 *            Document containg the scripts filename
	 */
	public void loadScripts(final Document doc)
	{
		NodeList scriptsNode = doc.getElementsByTagName("scripts");
		if (scriptsNode != null)
		{
			for (int i = 0; i < scriptsNode.getLength(); i++)
			{
				Element element = (Element) scriptsNode.item(i);
				NodeList stylesList = element.getElementsByTagName("script");

				for (int j = 0; j < stylesList.getLength(); j++)
				{
					Element scriptElement = (Element) stylesList.item(j);
					String script = scriptElement.getChildNodes().item(0).getNodeValue();
					log.info("Srcipts file loaded: " + script);
					getScripts().add(script);
				}
			}
		}
	}

	/**
	 * Load the styles filename from the config file.
	 * 
	 * @param doc
	 *            Document containg the styles filename
	 */
	public void loadProperties(final Document doc)
	{
		NodeList scriptsNode = doc.getElementsByTagName("properties");
		if (scriptsNode != null)
		{
			for (int i = 0; i < scriptsNode.getLength(); i++)
			{
				Element element = (Element) scriptsNode.item(i);
				NodeList stylesList = element.getElementsByTagName("property");

				for (int j = 0; j < stylesList.getLength(); j++)
				{

					Element propElement = (Element) stylesList.item(j);
					String key = propElement.getAttribute("key");
					String value = propElement.getAttribute("value");
					log.info("Prop loaded: " + key + " - " + value);
					if (key != null)
					{
						getProperties().setProperty(key, value);
					}
				}
			}
		}
	}

	/**
	 * Load the default emailAdress.
	 * 
	 * @param doc
	 *            Document containg
	 */
	public void loadDefaultEmail(final Document doc)
	{
		NodeList stylesNode = doc.getElementsByTagName("emails");
		if (stylesNode != null)
		{
			for (int i = 0; i < stylesNode.getLength(); i++)
			{
				Element element = (Element) stylesNode.item(i);
				NodeList stylesList = element.getElementsByTagName("default");

				if (stylesList.getLength() == 1)
				{
					log.warn("No default email adress specified using noreply@bendo.ca");
					setDefaultEmail("noreply@bendo.ca");
				} else
				{
					if (stylesList.getLength() > 1)
					{
						log.warn("Multiple default email adress specified, using the first one");
					}

					Element emailElement = (Element) stylesList.item(0);
					String email = emailElement.getChildNodes().item(0).getNodeValue();
					log.info("Default email loaded: " + email);
					setDefaultEmail(email);
				}
			}
		}
	}

	/**
	 * Initialise the velocity engine.
	 * 
	 * @param path
	 *            Path to the template
	 */
	public void initVelocityEngine(final String path)
	{
		Properties p = new Properties();
		p.setProperty("file.resource.loader.description", "file");
		p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		p.setProperty("file.resource.loader.path", BendoConfig.getRealPath(getProperty("velocity.template.path")));
		p.setProperty("file.resource.loader.cache", "false");
		p.setProperty("file.resource.loader.modificationCheckInterval", "2");
		p.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");

		Velocity.init(p);
		log.debug("BENDO CONFIG LOADED");
	}

	/**
	 * @return the servletContext
	 * 
	 */
	public ServletContext getServletContext()
	{
		return servletContext;
	}

	/**
	 * @param servletContext
	 *            the servletContext to set
	 * 
	 */
	public void setServletContext(final ServletContext servletContext)
	{
		this.servletContext = servletContext;
	}

	/**
	 * @return the styles
	 */
	public LinkedList<String> getStyles()
	{
		return styles;
	}

	/**
	 * @param styles
	 *            the styles to set
	 */
	public void setStyles(final LinkedList<String> styles)
	{
		this.styles = styles;
	}

	/**
	 * @return the scripts
	 */
	public LinkedList<String> getScripts()
	{
		return scripts;
	}

	/**
	 * @param scripts
	 *            the scripts to set
	 */
	public void setScripts(final LinkedList<String> scripts)
	{
		this.scripts = scripts;
	}

	/**
	 * @return the config
	 */
	public static BendoConfig getConfig()
	{
		return config;
	}

	/**
	 * @param config
	 *            the config to set
	 */
	public static void setConfig(final BendoConfig config)
	{
		BendoConfig.config = config;
	}

	/**
	 * @return the defaultEmail
	 */
	public String getDefaultEmail()
	{
		return defaultEmail;
	}

	/**
	 * @param defaultEmail
	 *            the defaultEmail to set
	 */
	public void setDefaultEmail(final String defaultEmail)
	{
		this.defaultEmail = defaultEmail;
	}

	/**
	 * @param string
	 *            Path
	 * @return The real path
	 */
	public static String getRealPath(final String string)
	{
		return getConfig().getServletContext().getRealPath(string);
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties()
	{
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(final Properties properties)
	{
		this.properties = properties;
	}

	/**
	 * Set a new property.
	 * 
	 * @param key
	 *            Key of the property
	 * @param value
	 *            Value of the property
	 */
	public static void setProperty(final String key, final String value)
	{
		getConfig().getProperties().setProperty(key, value);
	}

	/**
	 * Get a property with the key given.
	 * 
	 * @param key
	 *            Key of the property
	 * @return Value of the property
	 */
	public static String getProperty(final String key)
	{
		return getConfig().getProperties().getProperty(key);
	}

	/**
	 * @param request
	 *            request with information.
	 * @return the base url of the website
	 */
	public static String getBaseUrl(final HttpServletRequest request)
	{
		return String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());

	}

}
