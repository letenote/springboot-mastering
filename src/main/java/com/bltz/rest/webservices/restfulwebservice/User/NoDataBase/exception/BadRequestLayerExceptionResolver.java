package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.exception;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class BadRequestLayerExceptionResolver implements View {
	private String errorMessage;

	public BadRequestLayerExceptionResolver(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public void render(
			Map<String, ?> model,
			HttpServletRequest request,
			HttpServletResponse response
	) throws Exception {
//		response.setContentType("text/plain;charset=UTF-8");
		try (PrintWriter pw = response.getWriter()) {
			pw.write(errorMessage);
		}
	}

}
