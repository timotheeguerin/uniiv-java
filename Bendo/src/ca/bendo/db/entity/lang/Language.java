package ca.bendo.db.entity.lang;import java.util.Locale;import javax.persistence.Column;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.Table;import javax.servlet.http.HttpServletRequest;/** *  * @author Timoth�e Gu�rin * @version Bendo *  *          <b>Language</b> *          <p> *          </p> *  *  */@Entity@Table(name = "lang_language")public class Language{	/**	 * 	 */	@Id	@GeneratedValue	@Column(name = "id_lang_language", nullable = false, unique = true)	private long id;	/**	 * 	 */	@Column(name = "key")	private String key;	/**	 * 	 */	@Column(name = "name")	private String name;	/**	 * 	 * @param request	 *            request	 * @return the language id of the request	 */	public static Long loadId(final HttpServletRequest request)	{		return load(request).getId();	}	/**	 * 	 * @param request	 *            request	 * @return the language of the request	 */	public static Language load(final HttpServletRequest request)	{		return (Language) request.getAttribute("language.LANGUAGE");	}	/**	 * 	 * @param request	 *            request	 */	public void save(final HttpServletRequest request)	{		request.setAttribute("language.LANGUAGE", this);		setLocale(request);	}	/**	 * 	 * @param request	 *            request	 */	public void setLocale(final HttpServletRequest request)	{		request.setAttribute("language.LOCALE", new Locale(key));	}	/**	 * 	 * @param request	 *            request	 * @return the language of the request	 */	public static Locale getLocale(final HttpServletRequest request)	{		return (Locale) request.getAttribute("language.LOCALE");	}	/**	 * @return the id	 */	public long getId()	{		return id;	}	/**	 * @param id	 *            the id to set	 */	public void setId(final long id)	{		this.id = id;	}	/**	 * @return the key	 */	public String getKey()	{		return key;	}	/**	 * @param key	 *            the key to set	 */	public void setKey(final String key)	{		this.key = key;	}	/**	 * @return the name	 */	public String getName()	{		return name;	}	/**	 * @param name	 *            the name to set	 */	public void setName(final String name)	{		this.name = name;	}	/**	 * @return Return full name.	 * 	 */	@Override	public String toString()	{		return this.getName();	}}