/**
 * 
 */
package ca.bendo.taglib.tag.card;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ca.bendo.taglib.tag.card.handler.CardHandler;
import ca.bendo.taglib.tag.card.handler.CourseCardHandler;
import ca.bendo.taglib.tag.card.handler.ProfessorCardHandler;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>ProfessorCardTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class CardTag extends TagSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7753930890867768691L;
	/**
	 * Value to translate.
	 */
	private long value;

	/**
	 * 
	 */
	private CardType type;

	@Override
	public final int doStartTag() throws JspException
	{
		CardHandler handler = getHandler();

		handler.setup((HttpServletRequest) pageContext.getRequest(), value);

		try
		{
			pageContext.include(getFile());
		} catch (ServletException e)
		{
			
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	/**
	 * 
	 * @return the handler
	 */
	private CardHandler getHandler()
	{
		WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(pageContext
				.getServletContext());
		switch (type)
		{
		case PROFESSOR:
			return appContext.getBean(ProfessorCardHandler.class);
		case COURSE:
			return appContext.getBean(CourseCardHandler.class);
		default:
			return null;
		}
	}

	/**
	 * 
	 * @return the jsp file for the given type
	 */
	private String getFile()
	{

		switch (type)
		{
		case PROFESSOR:
			return "/WEB-INF/jsp/views/university/professor/profCard.jsp";
		case COURSE:
			return "/WEB-INF/jsp/views/university/course/courseCard.jsp";
		default:
			return null;
		}
	}

	/**
	 * @return the value
	 */
	public final long getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(final long value)
	{
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public final CardType getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final CardType type)
	{
		this.type = type;
	}

}
