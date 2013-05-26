/**
 * 
 */
package ca.bendo.form;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TestFormValidator</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TestFormValidator
{
	/**
	 * Test the isName function.
	 * 
	 * @see FieldValidator#isName(String)
	 */
	@Test
	public void testIsName()
	{

		assertTrue(FieldValidator.isName("Timothee Guerin"));
		assertTrue(!FieldValidator.isName("Tim9"));
		assertTrue(!FieldValidator.isName("Tim9/"));
	}

	/**
	 * Test the isName function.
	 * 
	 * @see FieldValidator#isInt(String)
	 */
	@Test
	public void testIsInt()
	{

		assertTrue(FieldValidator.isInt("151616516"));
		assertTrue(!FieldValidator.isInt("151616516aw"));
		assertTrue(!FieldValidator.isInt("8sef9--0"));
	}

	/**
	 * Test the isComment function.
	 * 
	 * @see FieldValidator#isComment(String)
	 */
	@Test
	public void testIsComment()
	{

		assertTrue(FieldValidator
				.isComment("Il faudrait quon fasse dautres formes d'input pour universities, programs, "
						+ "tuition fees, traduction, enfin tout quoicomme ca cest plus facile pour nous mais "
						+ "il faudrait que ce soit direct sur no ip ou 'chez_tim'"));
		assertTrue(!FieldValidator.isInt("8se9--0"));
	}
}
