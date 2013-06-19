/**
 * 
 */
package ca.bendo.db.entity.wiki;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author toby
 * @version Bendo 

 * <b>Wiki</b>
 * <p></p>
 *
 * 


 */
@Entity
@Table(name = "wiki_comment")
public class WikiComment
{
	@Id
	@GeneratedValue
	@Column(name = "id_wiki_comment")
	private long id;
	
	@Column(name = "comment")
	private long content;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Column(name = "last_edited")
	private Date dateEdited;

	@ManyToOne
	@JoinColumn(name = "id_wiki")
	private Wiki wiki;
	
	/**
	 * @return the parent
	 */
	public Wiki getWiki()
	{
		return wiki;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the content
	 */
	public long getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(long content) {
		this.content = content;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the dateEdited
	 */
	public Date getDateEdited() {
		return dateEdited;
	}

	/**
	 * @param dateEdited the dateEdited to set
	 */
	public void setDateEdited(Date dateEdited) {
		this.dateEdited = dateEdited;
	}
}
