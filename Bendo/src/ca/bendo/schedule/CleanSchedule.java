/**
 * 
 */
package ca.bendo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.user.UserResetPasswordDAO;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>CleanSchedule</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
@Transactional
public class CleanSchedule
{
	/**
	 * 
	 */
	@Autowired
	private UserResetPasswordDAO userResetPasswordDAO;

	/**
	 * Clean all the expired reset password key.
	 */
	@Scheduled(cron = "0 0 0 */1 * *")
	public void cleanExpiredResetPasswordKey()
	{
		userResetPasswordDAO.cleanExpiredKey();
	}
}
