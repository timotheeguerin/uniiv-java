/**
 * 
 */
package ca.bendo.taglib.template.form;

import java.util.LinkedList;

import javax.servlet.jsp.PageContext;

import ca.bendo.taglib.template.TagTemplate;
import ca.bendo.taglib.template.form.element.FormElement;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>Form</b>
 *          <p>
 *          </p>
 * @see TagTemplate
 * 
 */
public class Form extends TagTemplate
{

	/**
	 * 
	 */
	private LinkedList<FormElement> elements = new LinkedList<FormElement>();
	/**
	 * 
	 */
	private String action;
	/**
	 * 
	 */
	private String method;

	/**
	 * 
	 * @param translator
	 *            Translator
	 * @param pageContext
	 *            PageContext
	 */
	public Form(final Translator translator, final PageContext pageContext)
	{
		super(translator, pageContext);
		setAction("#");
		setMethod("POST");
	}

	@Override
	public final StringBuilder render()
	{
		StringBuilder result = new StringBuilder();
		result.append("<form class='" + getCustclass() + "' action='" + getAction() + "' method='" + getMethod()
				+ "' autocomplete='off'>");
		for (FormElement e : getElements())
		{
			result.append(e.render());
		}
		result.append("</form>");
		return result;
	}

	/**
	 * 
	 * @param e
	 *            Form element to prepend
	 */
	public final void prependElement(final FormElement e)
	{
		this.elements.addFirst(e);
	}

	/**
	 * 
	 * @param e
	 *            Form element to append
	 */
	public final void appendElement(final FormElement e)
	{
		this.elements.addLast(e);
	}

	/**
	 * @return the elements
	 */
	public final LinkedList<FormElement> getElements()
	{
		return elements;
	}

	/**
	 * @param elements
	 *            the elements to set
	 */
	public final void setElements(final LinkedList<FormElement> elements)
	{
		this.elements = elements;
	}

	/**
	 * @return the method
	 * 
	 */
	public final String getMethod()
	{
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 * 
	 */
	public final void setMethod(final String method)
	{
		this.method = method;
	}

	/**
	 * @return the action
	 * 
	 */
	public final String getAction()
	{
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 * 
	 */
	public final void setAction(final String action)
	{
		this.action = action;
	}

}
