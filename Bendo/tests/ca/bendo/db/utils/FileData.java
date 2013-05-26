/**
 * 
 */
package ca.bendo.db.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FileData</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class FileData
{
	/**
	 * Name of the file.
	 */
	private String filename;

	/**
	 * Data of the file.
	 */
	private List<TableRow> data = new ArrayList<TableRow>();

	/**
	 * 
	 * @param filename
	 *            name of the file
	 */
	public FileData(final String filename)
	{
		this.filename = filename;
	}

	/**
	 * Load the file previously specified.
	 */
	public void load()
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try
		{
			db = dbf.newDocumentBuilder();
			String in = filename;
			Document doc = db.parse(in);
			read(doc);

		} catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	/**
	 * Insert the filedata in the database.
	 * 
	 * @param connection
	 *            Connection to the database
	 * @throws SQLException Exception if sql problem
	 */
	public void insert(final Connection connection) throws SQLException
	{
		for (TableRow row : data)
		{
			row.insert(connection);
		}
	}

	/**
	 * Remove the fileData of the database.
	 */
	public void delete()
	{

	}

	/**
	 * 
	 * @param doc
	 *            Document to read
	 */
	private void read(final Document doc)
	{
		NodeList insertNode = doc.getElementsByTagName("insert");
		if (insertNode != null)
		{
			NodeList nodes = insertNode.item(0).getChildNodes();

			for (int i = 0; i < nodes.getLength(); i++)
			{
				TableRow row = new TableRow();

				Node node = nodes.item(i);
				String nodename = node.getNodeName();
				row.setTableName(nodename);

				NamedNodeMap attributes = node.getAttributes();
				if (attributes != null)
				{
					for (int j = 0; j < attributes.getLength(); j++)
					{
						Node attr = attributes.item(j);

						row.addValue(attr.getNodeName(), attr.getNodeValue());
						data.add(row);
					}
				}
			}
		}
	}

	/**
	 * @return the fileName
	 */
	public String getFilename()
	{
		return filename;
	}

	/**
	 * @param filename
	 *            the fileName to set
	 */
	public void setFilename(final String filename)
	{
		this.filename = filename;
	}

	/**
	 * @return the data
	 */
	public List<TableRow> getData()
	{
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(final List<TableRow> data)
	{
		this.data = data;
	}
}
