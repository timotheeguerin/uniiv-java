/**
 * 
 */
package ca.bendo.controller.admin;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.db.dao.HibernateDAO;
import ca.bendo.db.dao.user.UserDAO;

/**
 * @author Timothée Guérin
 * @version Uniiv
 * 
 *          <b>AdminController</b>
 *          <p>
 *          </p>
 * 
 *          template
 */
@Service
@Transactional
public class RepositoryManagerHandler
{

	/**
	 * 
	 * @param request
	 *            HttpServelet request
	 * @param dao
	 *            Dao
	 */
	public void list(final HttpServletRequest request, final HibernateDAO<?> dao)
	{
		Class<?> type = dao.getType();
		List<?> list = dao.list();
		List<Map<String, Object>> table = new ArrayList<Map<String, Object>>();
		System.out.println("TYPE: " + type);
		for (Object element : list)
		{
			Map<String, Object> values = new HashMap<String, Object>();
			for (Field field : type.getDeclaredFields())
			{
				String name = field.getName();
				Object value;
				try
				{
					field.setAccessible(true);

					value = field.get(element);

					if (value instanceof Collection<?>)
					{
						Collection<?> collection = (Collection<?>) value;
						ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
						Class<?> collectionType = (Class<?>) parameterizedType.getActualTypeArguments()[0];
						String display = collection.size() + " " + collectionType.getSimpleName();
						values.put(name, display);
					} else
					{
						values.put(name, value);
					}

				} catch (IllegalArgumentException e)
				{
					e.printStackTrace();
				} catch (IllegalAccessException e)
				{
					e.printStackTrace();
				}
			}
			table.add(values);
		}
		request.setAttribute("table", table);
		request.setAttribute("fields", type.getDeclaredFields());

	}

	/**
	 * @param request
	 *            Request
	 * @param dao
	 *            dao
	 */
	public void add(final HttpServletRequest request, final UserDAO dao)
	{
		Class<?> type = dao.getType();
		List<?> list = dao.list();
		List<Map<String, Object>> table = new ArrayList<Map<String, Object>>();

		for (Field field : type.getDeclaredFields())
		{
			String name = field.getName();

			field.getGenericType();
			Id idAnnotation = field.getAnnotation(Id.class);
			if (idAnnotation == null)
			{
				continue;
			}

			ManyToOne mtoAnnotation = field.getAnnotation(ManyToOne.class);
			if (mtoAnnotation != null)
			{
				
			}

		}

	}
}
