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

 * <b>FeesCategory</b>
 * <p></p>
 *
 * 


 */
public class FeesCategoryContent extends FilterCategoryContent
{

	/**
	 * 
	 */
	private List<Currency> currencies = new ArrayList<Currency>();
	/**
	 * 
	 */
	public FeesCategoryContent()
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
	 * @param currencies the currencies to set
	 */
	public void setCurrencies(final List<Currency> currencies)
	{
		this.currencies = currencies;
	}
}
