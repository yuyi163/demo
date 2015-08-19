package com.yy.metronic.commons.spring.springsecurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		Cookie cook = new Cookie("USER_ID", user.getId());//新建一个Cook,是键值(key-value)关系
		int month = 60 * 60 * 24 * 30;// 设置一个月(秒*分*时*天)
		cook.setMaxAge(month);// 设置Cook的生存期为一个月
		response.addCookie(cook);
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
