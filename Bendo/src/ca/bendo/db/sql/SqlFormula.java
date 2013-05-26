 /**
 * 
 */
package ca.bendo.db.sql;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Formula</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class SqlFormula
{
	/**
	 * Prevent instantation of final classs.
	 */
	private SqlFormula()
	{

	}

	/**
	 * 
	 * @param str
	 *            String to get the translation from
	 * @return the sqlquery to get the translation of the string given
	 */
	public String getTranslation(final String str)
	{
		return "(SELECT t.translation FROM lang_translation t WHERE (t.key = " + str
				+ ") AND t.id_lang_language = :languageId.param)";
	}
}
