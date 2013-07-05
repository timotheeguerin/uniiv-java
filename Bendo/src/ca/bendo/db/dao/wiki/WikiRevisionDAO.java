/**
 * 
 */
package ca.bendo.db.dao.wiki;

import java.util.List;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.wiki.WikiRevision;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>WikiRevsionDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class WikiRevisionDAO extends HibernateDAO<WikiRevision>
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.db.dao.HibernateDAO#init()
	 */
	@Override
	protected void init()
	{
		setType(WikiRevision.class);
	}

	/**
	 * 
	 * @param wikiId
	 *            Wiki Id
	 * @param order
	 *            Order the result by
	 * @return list of revision of the given wiki ordered in the given order
	 */
	@SuppressWarnings("unchecked")
	public List<WikiRevision> listWikiRevsions(final long wikiId, final Order order)
	{
		return (List<WikiRevision>) createCriteria().add(Restrictions.eq("page.id", wikiId)).addOrder(order);

	}
}
