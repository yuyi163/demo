package com.yy.metronic.commons.spring.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.yy.metronic.commons.exception.BusinessException;



public class HandlerBusinessExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		if (ex instanceof BusinessException) {
			BusinessException businessException = (BusinessException) ex;
			try {
				response.addHeader("content-type", "text/html;charset=UTF-8");
				response.setStatus(businessException.getStatus().value());
				PrintWriter writer = response.getWriter();
				writer.write(businessException.getMessage());
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
