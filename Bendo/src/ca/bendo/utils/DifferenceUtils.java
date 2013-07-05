/**
 * 
 */
package ca.bendo.utils;

import java.util.List;

import ca.bendo.utils.diff.Diff;
import ca.bendo.utils.diff.DiffUtils;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DifferenceUtils</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class DifferenceUtils
{
	/**
	 * 
	 */
	private DifferenceUtils()
	{

	}

	/**
	 * 
	 * @param original
	 *            Original Text
	 * @param revision
	 *            Revision Text
	 * @return
	 */
	public static String difference(final String original, final String revision)
	{
		DiffUtils util = new DiffUtils();
		List<Diff> diffs = util.diffMain(original, revision);

		StringBuilder result = new StringBuilder();
		for (Diff diff : diffs)
		{
			System.out.println(diff);

			switch (diff.operation)
			{
			case INSERT:
				result.append("<span class='new'>");
				break;
			case DELETE:
				result.append("<span class='old'>");
				break;
			case EQUAL:
				result.append("<span>").append("");
				break;
			default:
				break;
			}

			result.append(diff.textToHtml()).append("</span>");
		}

		return result.toString();

	}
}
