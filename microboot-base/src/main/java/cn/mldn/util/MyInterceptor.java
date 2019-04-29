package cn.mldn.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class MyInterceptor implements HandlerInterceptor {
	private Logger log = LoggerFactory.getLogger(MyInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		this.log.info("MyInterceptor.afterCompletion拦截处理完毕");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		HandlerMethod handlerMethod =  (HandlerMethod)arg2;
		this.log.info("MyInterceptor.postHandle"+handlerMethod.getBean().getClass().getSimpleName());

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		HandlerMethod handlerMethod =  (HandlerMethod)arg2;
			this.log.info("MyInterceptor.preHandle"+handlerMethod.getBean().getClass().getSimpleName());
		return true;//false不继续请求，如果true表示继续请求
	}

}
