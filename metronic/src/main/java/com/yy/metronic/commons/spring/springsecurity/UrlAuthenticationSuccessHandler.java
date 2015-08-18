package com.yy.metronic.commons.spring.springsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.yy.metronic.entity.User;

public class UrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private static Logger logger = LoggerFactory.getLogger(UrlAuthenticationSuccessHandler.class);

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		String userAgent = request.getHeader("User-Agent");
		User user = (User) authentication.getPrincipal();
		logger.info(user.getUsername() + ": " + userAgent);
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
