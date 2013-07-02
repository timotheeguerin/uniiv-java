/**
 * 
 */
package ca.bendo.search.softrating;

import java.util.ArrayList;
import java.util.List;

import ca.bendo.search.category.FilterButton;
import ca.bendo.search.category.FilterSectionContent;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>SectionContentRadioButton</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class SectionContentRadioButton extends FilterSectionContent
{
	/**
	 * 
	 */
	private boolean useImage;
	/**
	 * 
	 */
	private List<FilterButton> boxes = new ArrayList<FilterButton>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.bendo.search.category.FilterSectionContent#init()
	 */
	@Override
	protected void init()
	{
		setFilename("views/search/filter/category/radioButton.jsp");
		this.useImage = false;
	}

	/**
	 * @return the boxes
	 */
	public List<FilterButton> getBoxes()
	{
		return boxes;
	}

	/**
	 * @param boxes
	 *            the boxes to set
	 */
	public void setBoxes(final List<FilterButton> boxes)
	{
		this.boxes = boxes;
	}

	/**
	 * @return the useImage
	 */
	public boolean isUseImage()
	{
		return useImage;
	}

	/**
	 * @param useImage
	 *            the useImage to set
	 */
	public void setUseImage(final boolean useImage)
	{
		this.useImage = useImage;
	}

}
