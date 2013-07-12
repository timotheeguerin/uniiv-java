/**
 * 
 */
package ca.bendo.controller.plugin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.controller.handler.plugin.FacebookPollService;
import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.form.entity.plugin.InputFacebookPollForm;
import ca.bendo.form.entity.plugin.NewFacebookPollForm;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>FacebookPollController</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@Controller
public class FacebookPollController
{
	/**
	 * 
	 */
	@Autowired
	private FacebookPollService service;

	/**
	 * 
	 * @param form
	 *            Form
	 * @param result
	 *            Result
	 * @return success
	 */
	@RequestMapping(value = "/plugin/facebook/poll/entity/new", method = RequestMethod.GET)
	public String inputNewValue(@Valid final InputFacebookPollForm form, final BindingResult result)
	{
		return "1";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @return jsp page
	 */
	@Secured("user")
	@RequestMapping(value = "/plugin/facebook/poll/new", method = RequestMethod.GET)
	public String newPoll(final HttpServletRequest request)
	{
		return setupNewPoll(request, new NewFacebookPollForm());
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param form
	 *            Form
	 * @param result
	 *            form errors
	 * @return jsp page
	 */
	@Secured("user")
	@RequestMapping(value = "/plugin/facebook/poll/new", method = RequestMethod.POST)
	public String handleNewPoll(final HttpServletRequest request, @Valid final NewFacebookPollForm form,
			final BindingResult result)
	{
		if (result.hasErrors())
		{
			return setupNewPoll(request, form);
		}
		service.createNewPoll(form);
		
		return "redirect:";
	}

	/**
	 * 
	 * @param request
	 *            Request
	 * @param form
	 *            Form
	 * @return jsp page
	 */

	public String setupNewPoll(final HttpServletRequest request, final NewFacebookPollForm form)
	{
		request.setAttribute("newFacebookPollForm", form);
		request.setAttribute("types", service.listPollTypes());
		return "views/plugins/facebook/newpoll";
	}

}
