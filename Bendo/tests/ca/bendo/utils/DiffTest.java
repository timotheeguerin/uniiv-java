/**
 * 
 */
package ca.bendo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>DiffTest</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class DiffTest
{
	/**
	 * @throws IOException
	 * 
	 */
	@Test
	public void test() throws IOException
	{
		List<Line> oldFile = readLines("test/file_old.txt");
		List<Line> newFile = readLines("test/file_new.txt");
		System.out.println(oldFile.size() + " - " + newFile.size());

		List<Line> removed = new ArrayList<Line>(oldFile);
		removed.removeAll(newFile);

		List<Line> same = new ArrayList<Line>(oldFile);
		same.retainAll(newFile);

		List<Line> added = new ArrayList<Line>(newFile);
		added.removeAll(oldFile);

		System.out.println(removed.size() + " - " + same.size() + " - " + added.size());

	}

	public List<Line> readLines(final String filename) throws IOException
	{
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Line> lines = new ArrayList<Line>();
		long counter = 0;
		String lineStr = null;
		while ((lineStr = bufferedReader.readLine()) != null)
		{
			counter++;
			Line line = new Line();
			line.setId(counter);
			line.setText(lineStr);
			lines.add(line);
		}
		bufferedReader.close();
		return lines;
	}
}
