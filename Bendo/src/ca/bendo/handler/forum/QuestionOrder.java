/**
 * 
 */
package ca.bendo.handler.forum;

import org.hibernate.criterion.Order;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>QuestionOrder</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public enum QuestionOrder
{
	/**
	 * 
	 */
	RECENT, OLDER, BEST_SCORE, WORST_SCORE;

	/**
	 * @return hibernate order
	 */
	public Order getOrder()
	{
		switch (this)
		{
		case RECENT:
			return Order.desc("dateCreated");
		case OLDER:
			return Order.asc("dateCreated");
		case BEST_SCORE:
			return Order.asc("dateCreated");
		case WORST_SCORE:
			return Order.desc("dateCreated");
		default:
			return Order.desc("dateCreated");
		}
	}
}
