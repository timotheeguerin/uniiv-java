/**
 * 
 */
package ca.bendo.form.entity.geolocation;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

/**
 * @author Timoth�e Gu�rin
 * @version Bendo
 * 
 *          <b>GeoLocation</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class GeoLocation
{
	/**
	 * 
	 */
	private float latitude;

	/**
	 * 
	 */
	private float longitude;

	/**
	 * 
	 */
	public GeoLocation()
	{

	}

	/**
	 * 
	 * @param latitude
	 *            init latitude
	 * @param longitude
	 *            init longitude
	 */
	public GeoLocation(final float latitude, final float longitude)
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * 
	 * @param location
	 *            Stirng location to parse
	 */
	public GeoLocation(final String location)
	{
		fromString(location);
	}

	/**
	 * @param location
	 *            Location to parse
	 */
	private void fromString(final String location)
	{
		String loc = location;
		if (location.startsWith("("))
		{
			loc = location.substring(1);
		}
		if (location.endsWith(")"))

		{
			loc = loc.substring(0, loc.length() - 1);
		}

		String[] array = loc.split(",", 2);
		if (array.length == 2)
		{
			try
			{
				this.latitude = Float.parseFloat(array[0]);
				this.longitude = Float.parseFloat(array[1]);
			} catch (NumberFormatException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @return geometry
	 */
	public Point toPoint()
	{
		GeometryFactory geometryFactory = new GeometryFactory();

		return (Point) geometryFactory.createPoint(new Coordinate(longitude, latitude));

	}

	/**
	 * @return the latitude
	 */
	public float getLatitude()
	{
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(final float latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public float getLongitude()
	{
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(final float longitude)
	{
		this.longitude = longitude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "(" + latitude + "," + longitude + ")";
	}
}
