package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CustomizedResponseLayerExceptionResolverHandler implements HandlerExceptionResolver {
//	@Override
//	public ModelAndView resolveException(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			Object handler,
//			Exception ex
//	) {
//		ModelAndView wrappedResponse = new ModelAndView();
//		wrappedResponse.setStatus(HttpStatus.BAD_REQUEST);
//		wrappedResponse.setView(new BadRequestLayerExceptionResolver(ex.getMessage()));
//		return wrappedResponse;
//	}
	@Override
	public ModelAndView resolveException(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			Exception ex
	) {
		System.err.println("##::handler 1-> "+ handler.toString());
		System.err.println("##::handler 2-> "+ ex);
		String msg_option_1 = GlobalExceptionHandler.getThrowableStackInfo(ex);
		String msg_option_2 = ex.getMessage();
		try {
			response.setStatus(HttpStatus.FORBIDDEN.value());
			response.addHeader("Content-Type", "text/html; charset=UTF-8");
			response.getWriter().append("Custom exception handling!!! \n").append(msg_option_2).flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}



