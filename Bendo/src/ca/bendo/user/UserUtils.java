/**
 * 
 */
package ca.bendo.user;

import ca.bendo.db.entity.forum.ForumQuestion;
import ca.bendo.db.entity.user.User;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserUtils</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class UserUtils
{
	/**
	 * 
	 */
	private UserUtils()
	{

	}

	/**
	 * Check if the given user has the right to edit the given question. Has to
	 * be the user who created the question or a admin.
	 * 
	 * @param user
	 *            User that ask for permission
	 * @param question
	 *            Question that ask to be edited
	 * @return boolean if user is allowed to edit question
	 */
	public static boolean canUserEditQuestion(final User user, final ForumQuestion question)
	{
		if (user == null)
		{
			return false;
		}
		return true;
	}
}
