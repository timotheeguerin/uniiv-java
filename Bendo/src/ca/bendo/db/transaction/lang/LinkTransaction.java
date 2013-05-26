/**
 * 
 */
package ca.bendo.db.transaction.lang;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.lang.LinkDAO;
import ca.bendo.db.entity.lang.Link;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LinkTransaction</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class LinkTransaction
{
	/**
	 * 
	 */
	@Autowired
	private LinkDAO linkDAO;

	/**
	 * @param id
	 *            id
	 * @return links
	 */
	public Map<String, Link> listLinks(final long id)
	{
		return linkDAO.listLinks(id);
	}

	/**
	 * @param key
	 *            key
	 * @return links with given key
	 */
	public Map<String, Link> getLinksWithKey(final String key)
	{
		return linkDAO.getLinksWithKey(key);
	}

}
