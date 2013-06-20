/**
 * 
 */
package ca.bendo.db.entity.wiki;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ca.bendo.db.entity.forum.FormattedContent;
import ca.bendo.db.entity.forum.Tag;

/**
 * @author toby
 * @version Bendo 

 * <b>Wiki</b>
 * <p></p>
 *
 * 


 */
@Entity
@Table(name = "wiki")
public class Wiki
{
	@Id
	@GeneratedValue
	@Column(name = "id_wiki")
	private long id;

	@Column(name = "id_user")
	private long user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_formatted_content")
	private FormattedContent content;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@Column(name = "last_edited")
	private Date dateEdited;
	
	@Column(name = "title")
	private String title;
	
	@OneToMany
	@JoinTable(name = "wiki_comment",
		joinColumns = { @JoinColumn(name = "id_wiki")},
		inverseJoinColumns = { @JoinColumn(name = "id_wiki_comment")})
	private List<WikiComment> comments = new ArrayList<WikiComment>();
	

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "wiki_tag", joinColumns = { @JoinColumn(name = "id_wiki") },
			inverseJoinColumns = { @JoinColumn(name = "id_tag") })
	private List<Tag> tags = new ArrayList<Tag>();

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
	 * @return the user
	 */
	public long getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(long user) {
		this.user = user;
	}

	/**
	 * @return the content
	 */
	public FormattedContent getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(FormattedContent content) {
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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}