/**
 * 
 */
package ca.bendo.db.entity.wiki;

import java.util.Comparator;

/**
 * @author toby
 * @version Bendo 

 * <b>WikiAlphabeticalComparator</b>
 * <p></p>
 *
 * 


 */
public class WikiAlphabeticalComparator implements Comparator<Wiki>
{
	public int compare(Wiki prime, Wiki secondary)
	{
		return prime.getTitle().compareTo(secondary.getTitle());
	}
}
