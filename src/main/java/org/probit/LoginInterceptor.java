package org.probit;

import org.apache.commons.lang3.StringUtils;
import org.probit.domain.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * LoginInterceptor
  *
  * @author sunghyun
  * @since 2016. 12. 05.
  */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private KakaoRestApiHelper kakaoRestApiHelper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			if (request.getSession().getAttribute("account") == null || needNewAccessToken(request)) {
				System.out.println("request.getRequestURI() : "+request.getRequestURI());
				response.sendRedirect("/loginPage?redirectUrl=" + request.getRequestURI());
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	public boolean needNewAccessToken(HttpServletRequest request) {
		SessionUser sessionUser = (SessionUser)request.getSession().getAttribute("account");
		kakaoRestApiHelper.setAccessToken(sessionUser.getAccessToken());
		String validTokenJson = kakaoRestApiHelper.getUserAccessTokenInfo();
		return kakaoRestApiHelper.jsonGetValue(validTokenJson, "id") == null;
	}
}
