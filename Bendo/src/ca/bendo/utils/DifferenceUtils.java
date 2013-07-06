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

		for (int i = 0; i < diffs.size() - 1; i++)
		{
			Diff diff = diffs.get(i);
			Diff nextDiff = diffs.get(i + 1);

			result.append(diff.textToHtml(nextDiff));
		}
		result.append(diffs.getLast().textToHtml(null));

		return result.toString();

	}
}
