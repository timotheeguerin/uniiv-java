/**
 * 
 */
package ca.bendo.schedule;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ca.bendo.university.UniversityRatingsCalculator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UniversityRatingSchedule</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Service
public class UniversityRatingSchedule
{
	/**
	 * 
	 */
	private Logger log = Logger.getLogger(UniversityRatingSchedule.class);
	/**
	 * 
	 */
	@Autowired
	private UniversityRatingsCalculator calculator;

	/**
	 * 
	 * */

	@Scheduled(cron = "0 0 */3 * * *")
	public void doSchedule()
	{
		log.info("Start: Recalcuate all university ratings");
		calculator.updateAllRatings();
		log.info("End: Recalcuate all university ratings");

	}
}
