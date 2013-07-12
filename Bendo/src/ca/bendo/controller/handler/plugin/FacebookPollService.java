/**
 * 
 */
package ca.bendo.controller.handler.plugin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.plugin.facebook.FacebookPollDAO;
import ca.bendo.db.dao.plugin.facebook.FacebookPollTypeDAO;
import ca.bendo.db.entity.plugin.facebook.FacebookPoll;
import ca.bendo.db.entity.plugin.facebook.FacebookPollType;
import ca.bendo.form.entity.plugin.NewFacebookPollForm;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FacebookPollService</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class FacebookPollService
{
	/**
	 * 
	 */
	@Autowired
	private FacebookPollDAO pollDAO;

	/**
	 * 
	 */
	@Autowired
	private FacebookPollTypeDAO pollTypeDAO;

	/**
	 * 
	 * @param form
	 *            Form
	 */
	public void createNewPoll(final NewFacebookPollForm form)
	{
		FacebookPollType type = pollTypeDAO.getById(form.getType());
		FacebookPoll poll = new FacebookPoll();
		poll.setName(form.getTitle());
		poll.setType(type);
		pollDAO.add(poll);
	}

	/**
	 * @return list of the poll types
	 * 
	 */
	public List<FacebookPollType> listPollTypes()
	{
		return pollTypeDAO.list();
	}
}
