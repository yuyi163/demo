package com.yy.metronic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yy.metronic.entity.User;
import com.yy.metronic.service.UserService;

//响应前台的事件，调用后台方法

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> POST(@RequestBody User user){
		userService.saveUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
}
