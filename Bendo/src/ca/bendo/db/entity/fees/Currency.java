/**
 * 
 */
package ca.bendo.db.entity.fees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Currency</b>
 *          <p>
 *          </p>
 * 
 * 
 */

@Entity
@Table(name = "currency")
public class Currency
{
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_currency")
	private long id;

	/**
	 * 
	 */
	@Column(name = "symbol")
	private String symbol;

	/**
	 * Name to be translated.
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	@Formula("(SELECT t.translation FROM lang_translation t "
			+ "WHERE (t.key = name) AND t.id_lang_language = :languageId.param)")
	private String translation;

	/**
	 * @return the symbol
	 */
	public String getSymbol()
	{
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(final String symbol)
	{
		this.symbol = symbol;
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
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id)
	{
		this.id = id;
	}

	/**
	 * @return the translation
	 */
	public String getTranslation()
	{
		if (translation != null)
		{
			return translation;
		} else
		{
			return name;
		}
	}

	/**
	 * @param translation
	 *            the translation to set
	 */
	public void setTranslation(final String translation)
	{
		this.translation = translation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return getTranslation();
	}

}
