/**
 * 
 */
package ca.bendo.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ca.bendo.controller.interceptor.annotation.Title;
import ca.bendo.db.entity.lang.Language;
import ca.bendo.head.HeadManager;
import ca.bendo.translation.translation.Translator;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>TitleInterceptor</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class TitleInterceptor extends HandlerInterceptorAdapter
{

	/**
	 * 
	 */
	@Autowired
	private Translator translator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception
	{

		return super.preHandle(request, response, handler);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView modelAndView) throws Exception
	{
		if (handler != null && handler instanceof HandlerMethod)
		{
			HandlerMethod method = (HandlerMethod) handler;
			Title titleAnnotation = method.getMethodAnnotation(Title.class);

			if (titleAnnotation != null)
			{
				long languageId = Language.loadId(request);
				String title = translator.translate(titleAnnotation.value(), languageId);
				HeadManager.load(request).getTitle().setTitle(title);

			}
			String importStr = request.getParameter("import");
			if (importStr != null && importStr.equalsIgnoreCase("true"))
			{
				request.setAttribute("insertContentOnly", true);
			} else
			{
				request.setAttribute("insertContentOnly", false);
			}

		}
		super.postHandle(request, response, handler, modelAndView);
	}

}
