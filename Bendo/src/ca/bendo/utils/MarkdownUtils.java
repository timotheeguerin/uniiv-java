/**
 * 
 */
package ca.bendo.utils;

import org.apache.commons.lang.RandomStringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import com.github.rjeschke.txtmark.Processor;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>MardownUtils</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public final class MarkdownUtils
{
	private static final int TOC_RANDOM_ID = 5;

	/**
	 * 
	 */
	private MarkdownUtils()
	{
	}

	/**
	 * 
	 * @param markdown
	 *            Markdown text to convert to html
	 * @return html
	 */
	public static String process(final String markdown)
	{
		String html = Processor.process(markdown);
		return generateTableOfContent(html);
	}

	/**
	 * 
	 * @param html
	 *            Html
	 * @return tableofcontent
	 */
	private static String generateTableOfContent(final String html)
	{
		if (!html.contains("[TOC]"))
		{
			return html;
		}
		String id = "toc" + RandomStringUtils.randomAlphabetic(TOC_RANDOM_ID);
		int counter = 0;
		int lastHeading = 1;

		Document document = Jsoup.parse(html);
		String toc = "<nav role='navigation' class='table-of-contents'>" + "<ul>";
		Elements hTags = document.select("h1, h2");

		// For all the headings
		for (Element e : hTags)
		{
			int heading = 0;
			System.out.println("Tag: " + e.tagName());
			if (e.tagName().equalsIgnoreCase("h1"))
			{
				heading = 1;
			} else
			{
				heading = 2;
			}

			if (lastHeading < heading)
			{
				toc += "<ul>";
			} else if (lastHeading > heading)
			{
				toc += "</ul></li>";
			} else
			{
				toc += "</li>";
			}

			e.attr("id", id + counter);

			toc += "<li><a href='#" + id + counter + "'>" + e.html() + "</a>";
			lastHeading = heading;
			counter++;
		}
		toc += "</ul>" + "</nav>";
		return document.html().replace("[TOC]", toc);
	}
}
