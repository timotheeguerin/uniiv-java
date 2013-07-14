/**
 * 
 */
package ca.bendo.taglib.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import ca.bendo.session.UserSession;

/**
 * @author toby
 * @version Bendo
 * 
 *          <b>PermissionsTag</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class PermissionsTag extends BodyTagSupport
{
	/**
	 * 
	 */
	private List<String> permissions;

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
		boolean hasPermission = false;
		for (String permission : permissions)
		{
			if (permission != null && session.hasPermission(permission))
			{
				hasPermission = true;
			}
		}

		if (hasPermission)
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
	public List<String> getPermissions()
	{
		return permissions;
	}

	/**
	 * @param permission
	 *            the permission to set
	 */
	public void setPermissions(final List<String> permissions)
	{
		this.permissions = permissions;
	}

}
