package ca.bendo.db.dao.lang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.lang.Link;

/**
 * Connect to the lang_link table.
 * 
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LinkDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class LinkDAO extends HibernateDAO<Link>
{

	/**
	 * 
	 */
	public LinkDAO()
	{
		setType(Link.class);
	}

	/**
	 * @return a list of countries
	 */
	@SuppressWarnings("unchecked")
	public final List<Link> listLinks()
	{
		return (List<Link>) getSession().createCriteria(Link.class).list();
	}

	/**
	 * @param languageId
	 *            Country Id
	 * @return Links in the country
	 */
	public Map<String, Link> listLinks(final long languageId)
	{

		@SuppressWarnings("unchecked")
		List<Link> links = getSession().createCriteria(Link.class).add(Restrictions.eq("language.id", languageId))
				.list();

		Map<String, Link> linksMap = new HashMap<String, Link>();
		for (Link link : links)
		{
			linksMap.put(link.getKey(), link);
		}
		return linksMap;
	}

	/**
	 * @param key
	 *            Link key
	 * @return a map of the link for the key in all language
	 */
	public final Map<String, Link> getLinksWithKey(final String key)
	{

		@SuppressWarnings("unchecked")
		List<Link> links = getSession().createCriteria(Link.class).add(Restrictions.eq("key", key)).list();

		Map<String, Link> linksMap = new HashMap<String, Link>();

		for (Link link : links)
		{
			linksMap.put(link.getLanguage().getKey(), link);
		}
		return linksMap;
	}

	/**
	 * Get the link having the key and in the language given.
	 * 
	 * @param key
	 *            Key of the link
	 * @param languageId
	 *            Language id of the link.
	 * @return Transaltion object.
	 */
	public Link getLink(final String key, final long languageId)
	{
		Criterion keyRestriction = Restrictions.eq("key", key);
		Criterion langugageRestriction = Restrictions.eq("language.id", languageId);

		Link link = (Link) getSession().createCriteria(Link.class)
				.add(Restrictions.and(keyRestriction, langugageRestriction)).uniqueResult();
		return link;
	}

	/**
	 * Get all the unique keys of the link table.
	 * 
	 * @return Key list
	 */
	@SuppressWarnings("unchecked")
	public List<String> listKeys()
	{

		return (List<String>) getSession().createCriteria(Link.class)
				.setProjection(Projections.distinct(Projections.property("key"))).list();

	}

}