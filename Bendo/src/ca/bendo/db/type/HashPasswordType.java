/**
 * 
 */
package ca.bendo.db.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.lang.ObjectUtils;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

import ca.bendo.user.element.HashedPassword;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>HashPasswordType</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class HashPasswordType implements UserType
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#returnedClass()
	 */
	@Override
	public Class<HashedPassword> returnedClass()
	{
		return HashedPassword.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#sqlTypes()
	 */
	@Override
	public int[] sqlTypes()
	{
		return new int[] { Types.VARCHAR };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet,
	 * java.lang.String[], org.hibernate.engine.spi.SessionImplementor,
	 * java.lang.Object)
	 */
	@Override
	public Object nullSafeGet(final ResultSet rs, final String[] names, final SessionImplementor session,
			final Object owner) throws SQLException
	{
		String value = StandardBasicTypes.STRING.nullSafeGet(rs, names[0], session);
		if (value != null)
		{
			HashedPassword hashedPassword = new HashedPassword();
			hashedPassword.setHashedPassword(value);
			return hashedPassword;
		} else
		{
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement,
	 * java.lang.Object, int, org.hibernate.engine.spi.SessionImplementor)
	 */
	@Override
	public void nullSafeSet(final PreparedStatement st, final Object value, final int index,
			final SessionImplementor session) throws SQLException
	{
		String valStr = null;
		if (value != null)
		{
			valStr = value.toString();
		}

		StandardBasicTypes.STRING.nullSafeSet(st, valStr, index, session);
	}

	/* "default" implementations */

	@Override
	public boolean isMutable()
	{
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#equals(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public boolean equals(final Object x, final Object y)
	{
		return ObjectUtils.equals(x, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
	 */
	@Override
	public int hashCode(final Object x)
	{
		if (x != null)
		{
			return x.hashCode();
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
	 */
	@Override
	public Object deepCopy(final Object value)
	{
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#replace(java.lang.Object,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object replace(final Object original, final Object target, final Object owner)
	{
		return original;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
	 */
	@Override
	public Serializable disassemble(final Object value)
	{
		return (Serializable) value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable,
	 * java.lang.Object)
	 */
	@Override
	public Object assemble(final Serializable cached, final Object owner)
	{
		return cached;
	}

}
