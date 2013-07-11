/**
 * 
 */
package ca.bendo.controller.plugin;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.bendo.form.entity.plugin.InputFacebookPollForm;

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
	 * @param form
	 *            Form
	 * @param result
	 *            Result
	 * @return success
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String inputNewValue(@Valid final InputFacebookPollForm form, final BindingResult result)
	{
		return "1";
	}
}
