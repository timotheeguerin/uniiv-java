/**
 * 
 */
package ca.bendo.translation;

import ca.bendo.db.entity.lang.Language;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>ITranslationmanager</b>
 *          <p>
 *          Interface for all translation manager
 *          </p>
 * @see Filter
 * 
 */
public interface ITranslationManager
{
	/**
	 * 
	 * @param lang
	 *            translation language
	 */
	void loadFromDataBase(Language lang);

	/**
	 * 
	 * @param title
	 *            key to translate
	 * @return The translated segment
	 */
	String translate(String title);
}
