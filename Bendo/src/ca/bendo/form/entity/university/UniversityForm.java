/**
 * 
 */
package ca.bendo.form.entity.university;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import ca.bendo.db.entity.university.University;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityForm</b>
 *          <p>
 *          </p>
 *          Contains information for the university form
 * 
 */
public class UniversityForm
{
	/**
	 * 
	 */
	@NotNull
	private String key;

	/**
	 * 
	 */
	@NotNull
	private String name;

	/**
	 * 
	 */
	@URL
	private String website;

	/**
	 * 
	 */
	public UniversityForm()
	{
	}

	/**
	 * @param university
	 *            University object
	 */
	public UniversityForm(final University university)
	{
		this.key = university.getKey();
		this.name = university.getName();
		this.website = university.getWebsite();
	}

	/**
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(final String key)
	{
		this.key = key;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the website
	 */
	public String getWebsite()
	{
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(final String website)
	{
		this.website = website;
	}

}
