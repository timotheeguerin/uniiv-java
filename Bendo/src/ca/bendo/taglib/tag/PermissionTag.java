/**
 * 
 */
package ca.bendo.taglib.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import ca.bendo.db.entity.user.User;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>PermissionTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class PermissionTag extends BodyTagSupport
{
	/**
	 * 
	 */
	private String permission;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doAfterBody()
	 */
	@Override
	public int doAfterBody() throws JspException
	{
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		UserSession session = UserSession.getSession(request);
		BodyContent body = getBodyContent();
		if (permission != null && session.hasPermission(permission))
		{
			JspWriter out = body.getEnclosingWriter();
			try
			{
				out.write(body.getString());
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SKIP_BODY;
	}

	/**
	 * @return the permission
	 */
	public String getPermission()
	{
		return permission;
	}

	/**
	 * @param permission
	 *            the permission to set
	 */
	public void setPermission(final String permission)
	{
		this.permission = permission;
	}

}
