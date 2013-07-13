/**
 * 
 */
package ca.bendo.controller.plugin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.criterion.LikeExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.bendo.controller.handler.plugin.FacebookPollService;
import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.form.entity.plugin.LikeFacebookPollEntityForm;
import ca.bendo.form.entity.plugin.NewEntityFacebookPollForm;
import ca.bendo.form.entity.plugin.NewFacebookPollForm;
import ca.bendo.json.Json;
import ca.bendo.json.JsonError;
import ca.bendo.json.JsonSuccess;
import ca.bendo.translation.translation.Translator;

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
	 */
	@Autowired
	private Translator translator;

	/**
	 * @param form
	 *            Form
	 * @param result
	 *            Result
	 * @return success
	 */
	@ResponseBody
	@RequestMapping(value = "/plugin/facebook/poll/{pollId}/entity/new", method = RequestMethod.GET)
	public Json inputNewChoice(@Valid final NewEntityFacebookPollForm form, final BindingResult result)
	{
		if (result.hasErrors())
		{
			return new JsonError(result.getAllErrors());
		}

		service.newPollEntity(form);
		return new JsonSuccess(translator.translate("poll.entity.added"));
	}

	/**
	 * @param form
	 *            Form
	 * @param result
	 *            Result
	 * @return success
	 */
	@ResponseBody
	@RequestMapping(value = "/plugin/facebook/poll/{pollId}/entity/{entityId}/like", method = RequestMethod.GET)
	public Json toggleLikeChoice(@Valid final LikeFacebookPollEntityForm form, final BindingResult result)
	{
		if (result.hasErrors())
		{
			return new JsonError(result);
		}
		int value = service.toggleLikeEntity(form);
		if (value == 1)
		{
			return new JsonSuccess(translator.translate("success.like"));
		} else
		{
			return new JsonSuccess(translator.translate("success.unlike"));
		}

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
