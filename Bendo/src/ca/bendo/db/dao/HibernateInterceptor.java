/**
 * 
 */
package ca.bendo.db.dao;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>fsiefos</b>
 *          <p>
 *          </p>
 * 
 * 
 */
// @Transactional
public class HibernateInterceptor extends EmptyInterceptor
{

	/**
	 * 
	 */
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.EmptyInterceptor#afterTransactionBegin(org.hibernate.
	 * Transaction)
	 */
	@Override
	public void afterTransactionBegin(final Transaction tx)
	{
		System.out.println("TRANSACTION BEGIN");
		super.afterTransactionBegin(tx);
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
		System.out.println("SET");
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 
	 * @return the database connection session
	 */
	protected Session getSession()
	{
		return getSessionFactory().getCurrentSession();
	}

}