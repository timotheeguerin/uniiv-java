/**
 * 
 */
package ca.bendo.db.dao;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

import ca.bendo.db.entity.location.Country;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>HibernateDAO</b>
 *          <p>
 *          </p>
 * 
 * @param <T>
 *            type of the mapping entity
 */
public class HibernateDAO<T>
{
	/**
	 * 
	 */
	private Class<T> type;

	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 */
	public HibernateDAO()
	{
		init();
	}

	/**
	 * 
	 */

	protected void init()
	{

	}

	/**
	 * 
	 * @return criteria
	 */
	public Criteria createCriteria()
	{
		return getSession().createCriteria(type);
	}

	/**
	 * @return list all the entity
	 */
	@SuppressWarnings("unchecked")
	public List<T> list()
	{
		return getSession().createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	/**
	 * @param column
	 *            Column name
	 * @return list all the entity order by the column in asc
	 */
	@SuppressWarnings("unchecked")
	public List<T> listOrderAsc(final String column)
	{

		return getSession().createCriteria(type).addOrder(Order.asc(column))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	/**
	 * @param column
	 *            Column name
	 * @return list all the entity order by the column in descending
	 */
	@SuppressWarnings("unchecked")
	public List<T> listOrderDesc(final String column)
	{
		return getSession().createCriteria(type).addOrder(Order.desc(column))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	/**
	 * @param ids
	 *            List of all the ids of the university to return
	 * @return list all the entity with the given ids
	 */
	@SuppressWarnings("unchecked")
	public List<T> listByIds(final Collection<Long> ids)
	{
		return getSession().createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.in("id", ids)).list();
	}

	/**
	 * @param number
	 *            maximum number to retreive
	 * @return list all the entity
	 */
	@SuppressWarnings("unchecked")
	public List<T> listN(final int number)
	{
		return getSession().createCriteria(type).setMaxResults(number).list();
	}

	/**
	 * @param first
	 *            first number
	 * @param number
	 *            maximum number to retrieve
	 * @return list all the entity
	 */
	@SuppressWarnings("unchecked")
	public List<T> listNFrom(final int first, final int number)
	{
		return getSession().createCriteria(type).setFirstResult(first).setMaxResults(number).list();
	}

	/**
	 * @param id
	 *            of the entity to get.
	 * @return entity
	 */

	@SuppressWarnings("unchecked")
	public T getById(final Long id)
	{
		Object result = getSession().createCriteria(type).add(Restrictions.idEq(id)).uniqueResult();

		if (type.isInstance(result))
		{
			return (T) result;
		} else
		{
			return null;
		}
	}

	/**
	 * @param id
	 *            of the country to remove.
	 * @return if delete was succesfull
	 */

	public boolean delete(final long id)
	{
		Object result = getSession().get(type, id);

		if (result == null)
		{
			return false;
		} else
		{
			getSession().delete(result);
			return true;
		}
	}

	/**
	 * @param entity
	 *            to remove
	 */

	public void delete(final T entity)
	{
		getSession().delete(entity);
	}

	/**
	 * 
	 * @param entity
	 *            New Entity.
	 */

	public void saveOrUpdate(final T entity)
	{
		getSession().saveOrUpdate(entity);

	}

	/**
	 * 
	 * @param entity
	 *            New Entity.
	 */

	public void persist(final T entity)
	{
		getSession().persist(entity);

	}

	/**
	 * 
	 * @param entity
	 *            New Entity.
	 */

	public void update(final T entity)
	{
		getSession().update(entity);
	}

	/**
	 * @param entity
	 *            entity to add
	 */
	public void add(final T entity)
	{
		getSession().save(entity);
	}

	/**
	 * 
	 * @return the number of entity
	 */
	public long count()
	{
		return (long) getSession().createCriteria(type).setProjection(Projections.rowCount()).uniqueResult();
	}

	/**
	 * @param column
	 *            Name of the column to filter using the query
	 * @param query
	 *            Query
	 * @param firstResult
	 *            First result
	 * @param maxResults
	 *            Max result
	 * @return list of forum result
	 */
	@SuppressWarnings("unchecked")
	public List<T> search(final String column, final String query, final int firstResult, final int maxResults)
	{
		String value = "%" + query + "%";
		return getSession().createCriteria(type).add(Restrictions.ilike(column, value)).setFirstResult(firstResult)
				.setMaxResults(maxResults).list();
	}

	/**
	 * @param column
	 *            Name of the column to filter using the query
	 * @param query
	 *            to filter the result with the given column name
	 * @return the number of entity
	 */
	public long searchCount(final String column, final String query)
	{
		String value = "%" + query + "%";
		return (long) getSession().createCriteria(type).add(Restrictions.ilike(column, value))
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(final SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 
	 * @param clazz
	 *            Table class
	 * @return id column nam
	 */
	protected String getId(final Class<?> clazz)
	{
		Table table = Country.class.getAnnotation(Table.class);
		return "id_" + table.name();
	}

	/**
	 * 
	 * @return the database connection session
	 */
	protected Session getSession()
	{
		Locale locale = LocaleContextHolder.getLocale();

		Session session = getSessionFactory().getCurrentSession();
		Filter filter = session.enableFilter("language");
		filter.setParameter("param", locale.getDisplayName());
		return session;
	}

	/**
	 * @return the type
	 */
	protected Class<T> getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	protected void setType(final Class<T> type)
	{
		this.type = type;
	}
}
