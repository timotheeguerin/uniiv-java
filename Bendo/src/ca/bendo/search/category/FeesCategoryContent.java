/**
 * 
 */
package ca.bendo.search.category;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.db.entity.fees.Currency;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FeesCategory</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FeesCategoryContent extends FilterSectionContent
{

	/**
	 * 
	 */
	private List<Currency> currencies = new ArrayList<Currency>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.search.category.FilterSectionContent#init()
	 */
	@Override
	protected void init()
	{
		setFilename("views/search/filter/category/fees.jsp");
	}

	/**
	 * @return the currencies
	 */
	public List<Currency> getCurrencies()
	{
		return currencies;
	}

	/**
	 * @param currencies
	 *            the currencies to set
	 */
	public void setCurrencies(final List<Currency> currencies)
	{
		this.currencies = currencies;
	}
}
