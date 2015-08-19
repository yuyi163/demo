package com.yy.metronic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yy.metronic.entity.User;
import com.yy.metronic.repository.UserRepository;
import com.yy.metronic.service.UserService;

//响应前台的事件，调用后台方法

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> POST(@RequestBody User user){
		userService.saveUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> GET(@PathVariable String id) {
		User user = userRepository.findOne(id);
		user.setPassword(null);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
