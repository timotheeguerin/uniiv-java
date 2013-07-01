/**
 * 
 */
package ca.bendo.db.entity.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import ca.bendo.db.entity.university.University;
import ca.bendo.db.entity.wiki.Wiki;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>UserBookmark</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Embeddable
public class UserBookmark
{

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "user_bookmark_wiki", joinColumns = { @JoinColumn(name = "id_user") },
			inverseJoinColumns = { @JoinColumn(name = "id_wiki") })
	private List<Wiki> wikis = new ArrayList<Wiki>();

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "user_bookmark_university", joinColumns = { @JoinColumn(name = "id_user") },
			inverseJoinColumns = { @JoinColumn(name = "id_uni_university") })
	private List<University> unis = new ArrayList<University>();

	/**
	 * @return the wikis
	 */
	public List<Wiki> getWikis()
	{
		return wikis;
	}

	/**
	 * @param wikis
	 *            the wikis to set
	 */
	public void setWikis(final List<Wiki> wikis)
	{
		this.wikis = wikis;
	}

	/**
	 * @return the unis
	 */
	public List<University> getUnis()
	{
		return unis;
	}

	/**
	 * @param unis
	 *            the unis to set
	 */
	public void setUnis(final List<University> unis)
	{
		this.unis = unis;
	}

}
