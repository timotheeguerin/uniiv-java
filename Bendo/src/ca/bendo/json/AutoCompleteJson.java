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
	public final String getQuery()
	{
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public final void setQuery(final String query)
	{
		this.query = query;
	}

	/**
	 * @return the suggestions
	 */
	public final List<Suggestion> getSuggestions()
	{
		return suggestions;
	}

	/**
	 * @param suggestions
	 *            the suggestions to set
	 */
	public final void setSuggestions(final List<Suggestion> suggestions)
	{
		this.suggestions = suggestions;
	}

}
