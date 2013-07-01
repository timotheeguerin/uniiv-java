/**
 * 
 */
package ca.bendo.db.entity.user;

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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import ca.bendo.db.entity.university.University;
import ca.bendo.db.entity.wiki.Wiki;
import ca.bendo.form.entity.user.SignupForm;
import ca.bendo.user.element.HashedPassword;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>User</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Entity
@Table(name = "user")
public class User
{

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user")
	private long id;

	/**
	 * 
	 */
	@Column(name = "email", unique = true, nullable = false)
	private String email;

	/**
	 * User password in an HashedFormat.
	 */
	@Type(type = "ca.bendo.db.type.HashPasswordType")
	@Column(name = "password", nullable = false)
	private HashedPassword password;

	/**
	 * 
	 */
	@Column(name = "firstname")
	private String firstName;

	/**
	 * 
	 */
	@Column(name = "lastname")
	private String lastName;
	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "id_user_state")
	private UserState state;

	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "user_permission_link", joinColumns = { @JoinColumn(name = "id_user") },
			inverseJoinColumns = { @JoinColumn(name = "id_user_permission") })
	private List<UserPermission> permissions = new ArrayList<UserPermission>();

	/**
	 * 
	 */
	@Column(name = "date_created")
	private Date timeCreated;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "user_bookmark_wiki", joinColumns = { @JoinColumn(name = "id_user") },
	inverseJoinColumns = { @JoinColumn(name = "id_wiki") })
	private List<Wiki> wikis = new ArrayList<Wiki>();
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "user_bookmark_university", joinColumns = { @JoinColumn(name = "id_user") },
	inverseJoinColumns = { @JoinColumn(name = "id_uni_university") })
	private List<University> unis = new ArrayList<University>();
	
	/**
	 * 
	 */
	public User()
	{
		//
	}

	/**
	 * 
	 * @param signupForm
	 *            New user to initialise from
	 * @param state
	 *            User state when adding
	 */
	public User(final SignupForm signupForm, final UserState state)
	{
		this.email = signupForm.getEmail();
		this.password = new HashedPassword(signupForm.getPassword());
		this.firstName = signupForm.getFirstName();
		this.lastName = signupForm.getLastName();
		this.state = state;
	}

	/**
	 * @param permission
	 *            permission to add
	 */
	public void addPermission(final UserPermission permission)
	{
		permissions.add(permission);
	}

	/**
	 * @param dPerm
	 *            permission to remove
	 */
	public void removePermission(final UserPermission dPerm)
	{
		for (UserPermission permission : permissions)
		{
			if (permission.getId() == dPerm.getId())
			{
				permissions.remove(permission);
				return;
			}
		}
	}

	/**
	 * 
	 * @param str
	 *            permission
	 * @return check if the user has the given permission
	 */
	public boolean hasPermission(final String str)
	{
		for (UserPermission permission : permissions)
		{
			if (permission.hasPermission(str))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id)
	{
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public HashedPassword getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final HashedPassword password)
	{
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * @return the state
	 */
	public UserState getState()
	{
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(final UserState state)
	{
		this.state = state;
	}

	/**
	 * @return the permissions
	 */
	public List<UserPermission> getPermissions()
	{
		return permissions;
	}

	/**
	 * @param permissions
	 *            the permissions to set
	 */
	public void setPermissions(final List<UserPermission> permissions)
	{
		this.permissions = permissions;
	}

	/**
	 * @return the timeCreated
	 */
	public Date getTimeCreated()
	{
		return timeCreated;
	}

	/**
	 * @param timeCreated
	 *            the timeCreated to set
	 */
	public void setTimeCreated(final Date timeCreated)
	{
		this.timeCreated = timeCreated;
	}
	
	public List<Wiki> getWikis()
	{
		return wikis;
	}
	
	public List<University> getUnis()
	{
		return unis;
	}
	
	public void setWikis(List<Wiki> wikis)
	{
		this.wikis = wikis;
	}
	
	public void setUnis(List<University> unis)
	{
		this.unis = unis;
	}

}
