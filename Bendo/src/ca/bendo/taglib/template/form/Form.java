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
	public StringBuilder render()
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
	public void prependElement(final FormElement e)
	{
		this.elements.addFirst(e);
	}

	/**
	 * 
	 * @param e
	 *            Form element to append
	 */
	public void appendElement(final FormElement e)
	{
		this.elements.addLast(e);
	}

	/**
	 * @return the elements
	 */
	public LinkedList<FormElement> getElements()
	{
		return elements;
	}

	/**
	 * @param elements
	 *            the elements to set
	 */
	public void setElements(final LinkedList<FormElement> elements)
	{
		this.elements = elements;
	}

	/**
	 * @return the method
	 * 
	 */
	public String getMethod()
	{
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 * 
	 */
	public void setMethod(final String method)
	{
		this.method = method;
	}

	/**
	 * @return the action
	 * 
	 */
	public String getAction()
	{
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 * 
	 */
	public void setAction(final String action)
	{
		this.action = action;
	}

}
