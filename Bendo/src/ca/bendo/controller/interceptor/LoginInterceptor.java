/**
 * 
 */
package ca.bendo.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ca.bendo.controller.interceptor.annotation.Secured;
import ca.bendo.session.UserSession;

/**
 * @author Timothée Guérin
 * @version Bendo
 * 
 *          <b>LoginInterceptor</b>
 *          <p>
 *          </p>
 * 
 * 
 */
public class LoginInterceptor extends HandlerInterceptorAdapter
{
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
		if (handler instanceof HandlerMethod)
		{
			HandlerMethod method = (HandlerMethod) handler;
			Secured securedAnnotation = method.getMethodAnnotation(Secured.class);

			UserSession userSession = UserSession.getSession(request);
			if (securedAnnotation == null || userSession.hasPermission(securedAnnotation.value()))
			{

				return super.preHandle(request, response, handler);
			} else
			{
				request.getRequestDispatcher("/").forward(request, response);

				return false;
			}

		} else
		{
			return super.preHandle(request, response, handler);
		}
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
		System.out.println("Post handle: " + request.getRequestURL());
		super.postHandle(request, response, handler, modelAndView);
	}
}
