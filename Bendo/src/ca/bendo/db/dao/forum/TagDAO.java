/**
 * 
 */
package ca.bendo.db.dao.forum;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.entity.forum.Tag;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ForumTagDAO</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Repository
@Transactional
public class TagDAO extends HibernateDAO<Tag>
{
	/**
	 * 
	 */
	public TagDAO()
	{
		setType(Tag.class);
	}

	/**
	 * @param tagName
	 *            Tag name
	 * @return the tag with the given name or translation if not available
	 */
	public Tag getTag(final String tagName)
	{
		Tag tag = (Tag) getSession().createCriteria(Tag.class).add(Restrictions.eq("name", tagName)).uniqueResult();
		if (tag == null)
		{
			tag = new Tag();
			tag.setName(tagName);
			saveOrUpdate(tag);
		}

		return tag;
	}

	/**
	 * 
	 * @param tags
	 *            Tags in the format tag1,tag2,tag3
	 * @return list of forum tags mapping to the given tags
	 */
	public List<Tag> getTags(final String tags)
	{
		return getTags(tags.split(","));
	}

	/**
	 * @param tagStrArray
	 *            Array of string coresponding to the tags array
	 * @return list of tags with the given name/translation
	 */
	private List<Tag> getTags(final String[] tagStrArray)
	{
		List<Tag> tags = new ArrayList<Tag>();
		for (String tagStr : tagStrArray)
		{
			tags.add(getTag(tagStr));
		}

		return tags;
	}
}
