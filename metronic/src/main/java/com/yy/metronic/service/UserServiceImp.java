package com.yy.metronic.service;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yy.metronic.commons.util.Validate;
import com.yy.metronic.entity.User;
import com.yy.metronic.entity.UserMeta;
import com.yy.metronic.repository.UserMetaRepository;
import com.yy.metronic.repository.UserRepository;

@Service("userService")
public class UserServiceImp implements UserDetailsService,UserService {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	@Transactional
	public void init() {
		User user = userRepository.findByUsername("admin");
		if (user == null) {
			user = new User();
			user.setUsername("admin");
			user.setPassword("admin");
			user.setMobilePhone("12345678901");
			saveUser(user);
		}
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(username);
	}

	@Transactional
	public void saveUser(User user) {
		Validate.isNotEmpty("用户名为空",user.getUsername());
		Validate.isNull("用户名已存在", userRepository.findByUsername(user.getUsername()));
		userRepository.save(user);
	}
	
}
