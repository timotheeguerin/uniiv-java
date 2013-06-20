/**
 * 
 */
package ca.bendo.db.dao.wiki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.wiki.Wiki;
import ca.bendo.db.entity.wiki.WikiAlphabeticalComparator;

/**
 * @author toby
 * @version Bendo 

 * <b>WikiDAO</b>
 * <p></p>
 *
 * 


 */
@Repository
@Transactional
public class WikiDAO extends HibernateDAO<Wiki>
{
	public WikiDAO()
	{
		setType(Wiki.class);
	}
	
	public Wiki getWiki(final String wikiName)
	{
		Wiki wiki = (Wiki) getSession().createCriteria(Wiki.class).add(Restrictions.eq("name", wikiName))
				.uniqueResult();
		if (wiki == null)
		{
			wiki = new Wiki();
			wiki.setTitle(wikiName);
			saveOrUpdate(wiki);
		}

		return wiki;
	}
	
	public Wiki getWiki(final long wikiID)
	{
		Wiki wiki = getById(wikiID);
		return wiki;
	}
	
	public List<Wiki> getWikis(final String wikis)
	{
		return getWikis(wikis.split(","));
	}
	
	private List<Wiki> getWikis(final String[] wikiStrArray)
	{
		List<Wiki> wikis = new ArrayList<Wiki>();
		for (String wikiStr : wikiStrArray)
		{
			wikis.add(getWiki(wikiStr));
		}

		return wikis;
	}
	
	public String getContent(final long wikiID)
	{
		return getWiki(wikiID).getContent().getHtml();
	}
	
	public List<Wiki> listSort()
	{
		List<Wiki> list = list();
		Collections.sort(list, new WikiAlphabeticalComparator());
		return list;
	}
}
