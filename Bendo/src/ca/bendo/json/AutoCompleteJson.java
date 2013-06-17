/**
 * 
 */
package ca.bendo.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>AutoCompleteJson</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class AutoCompleteJson
{
	/**
	 * 
	 */
	private String query;

	/**
	 * 
	 */
	private List<Suggestion> suggestions = new ArrayList<Suggestion>();

	/**
	 * @return the query
	 */
	public String getQuery()
	{
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(final String query)
	{
		this.query = query;
	}

	/**
	 * @return the suggestions
	 */
	public List<Suggestion> getSuggestions()
	{
		return suggestions;
	}

	/**
	 * @param suggestions
	 *            the suggestions to set
	 */
	public void setSuggestions(final List<Suggestion> suggestions)
	{
		this.suggestions = suggestions;
	}

}
