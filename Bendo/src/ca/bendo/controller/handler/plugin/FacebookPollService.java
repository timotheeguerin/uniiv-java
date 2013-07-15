/**
 * 
 */
package ca.bendo.controller.handler.plugin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.plugin.facebook.FacebookPollDAO;
import ca.bendo.db.dao.plugin.facebook.FacebookPollEntityDAO;
import ca.bendo.db.dao.plugin.facebook.FacebookPollTypeDAO;
import ca.bendo.db.dao.plugin.facebook.FacebookPollUserLikeDAO;
import ca.bendo.db.entity.plugin.facebook.FacebookPoll;
import ca.bendo.db.entity.plugin.facebook.FacebookPollEntity;
import ca.bendo.db.entity.plugin.facebook.FacebookPollType;
import ca.bendo.db.entity.plugin.facebook.FacebookPollUserLike;
import ca.bendo.db.entity.user.User;
import ca.bendo.form.entity.plugin.LikeFacebookPollEntityForm;
import ca.bendo.form.entity.plugin.NewEntityFacebookPollForm;
import ca.bendo.form.entity.plugin.NewFacebookPollForm;
import ca.bendo.session.UserSession;
import ca.bendo.utils.facebook.FacebookUtils;
import ca.bendo.utils.facebook.Place;

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
	private FacebookUtils facebook;

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
	 */
	@Autowired
	private FacebookPollEntityDAO pollEntityDAO;

	/**
	 * 
	 */
	@Autowired
	private FacebookPollUserLikeDAO pollUserLikeDAO;

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

	/**
	 * @param form
	 *            Form
	 */
	public void newPollEntity(final NewEntityFacebookPollForm form)
	{
		User user = UserSession.getSession().getUser();
		FacebookPoll poll = pollDAO.getById(form.getPollId());

		Place place = facebook.getPlace(form.getId());

		FacebookPollEntity entity = new FacebookPollEntity();
		entity.setFacebookId(form.getId());
		entity.setPoll(poll);
		entity.setName(place.getName());
		entity.setScore(calculateScore(place.getLikes(), 0));

		entity.setUser(user);
		pollEntityDAO.add(entity);

	}

	/**
	 * 
	 * @param likes
	 *            Number of facebook likes
	 * @param votes
	 *            Number of uniiv vote
	 * @return score
	 */
	public int calculateScore(final long likes, final int votes)
	{
		return (int) (likes + votes * votes) / (votes + 1);
	}

	/**
	 * @param form
	 *            Form
	 * @return value
	 */
	public int toggleLikeEntity(final LikeFacebookPollEntityForm form)
	{
		User user = UserSession.getSession().getUser();
		FacebookPollUserLike result = pollUserLikeDAO.getByEntityAndUser(form.getEntityId(), user.getId());
		if (result == null)
		{
			FacebookPollEntity entity = pollEntityDAO.getById(form.getEntityId());
			FacebookPollUserLike like = new FacebookPollUserLike();
			like.setUser(user);
			like.setEntity(entity);
			pollUserLikeDAO.add(like);
			return 1;
		} else
		{
			pollUserLikeDAO.delete(result);
			return 0;
		}

	}

	/**
	 * @param pollId
	 *            poll Id
	 * @return poll
	 */
	public FacebookPoll loadPoll(final long pollId)
	{
		FacebookPoll poll = pollDAO.getById(pollId);
		List<FacebookPollEntity> entities = pollEntityDAO.listFromPoll(pollId);
		poll.setEntities(entities);
		return poll;
	}
}
