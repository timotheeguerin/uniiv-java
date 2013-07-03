/**
 * 
 */
package ca.bendo.db.dao.wiki;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.wiki.WikiPage;

/**
 * @author toby
 * @version Bendo
 * 
 *          <b>WikiDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class WikiPageDAO extends HibernateDAO<WikiPage>
{
	/**
	 * 
	 */
	public WikiPageDAO()
	{
		setType(WikiPage.class);
	}

	/**
	 * 
	 * @return Wiki by alphabetical order
	 */
	@SuppressWarnings("unchecked")
	public List<WikiPage> listSort()
	{
		return (List<WikiPage>) createCriteria().addOrder(Order.asc("title")).list();
	}
}
