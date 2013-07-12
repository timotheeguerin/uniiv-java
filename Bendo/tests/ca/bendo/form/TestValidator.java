/**
 * 
 */
package ca.bendo.form;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.bendo.form.entity.plugin.NewFacebookPollForm;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestValidator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestValidator
{
	/**
	 * 
	 */
	private static Validator validator;

	/**
	 * 
	 */
	@BeforeClass
	public static void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		System.out.println("Message inter: " + factory.getMessageInterpolator());
	}

	/**
	 * 
	 */
	@Test
	public void manufacturerIsNull()
	{
		NewFacebookPollForm form = new NewFacebookPollForm();
		form.setTitle("TITLE");
		form.setType(2);
		Set<ConstraintViolation<NewFacebookPollForm>> constraintViolations = validator.validate(form);
		ConstraintViolation<NewFacebookPollForm> error = constraintViolations.iterator().next();
		System.out.println(error.getPropertyPath() + " - " + error.getMessage());

	}

}
