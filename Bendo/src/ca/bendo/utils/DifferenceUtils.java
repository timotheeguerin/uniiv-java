/**
 * 
 */
package ca.bendo.utils;

import java.util.LinkedList;
import java.util.List;

import ca.bendo.utils.diff.Diff;
import ca.bendo.utils.diff.DiffUtils;
import ca.bendo.utils.diff.DiffUtils.LinesToCharsResult;

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
	 * @return Html
	 */
	public static String difference(final String original, final String revision)
	{

		DiffUtils util = new DiffUtils();
		
		LinesToCharsResult b = util.wordsToChars(original, revision);

		String wordText1 = b.chars1;
		String wordText2 = b.chars2;
		List<String> wordarray = b.lineArray;
		LinkedList<Diff> diffs = util.diffMain(wordText1, wordText2, false);
		util.charsToLines(diffs, wordarray);

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
