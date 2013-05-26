/**
 * 
 */
package ca.bendo.form.entity.search;

import ca.bendo.annotation.Input;
import ca.bendo.form.entity.Entity;
import ca.bendo.form.entity.EntityType;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TextSearchEntity</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TextSearchEntity extends Entity
{
	/**
	 * 
	 */
	@Input(name = "query", type = EntityType.OTHER)
	private String query;

	/**
	 * @return the query
	 */
	public final String getQuery()
	{
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public final void setQuery(final String query)
	{
		this.query = query;
	}
	
}
