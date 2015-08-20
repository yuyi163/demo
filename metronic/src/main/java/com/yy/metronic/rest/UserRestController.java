package com.yy.metronic.rest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yy.metronic.commons.util.Assert;
import com.yy.metronic.entity.User;
import com.yy.metronic.model.PasswordChange;
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> PUT(@PathVariable String id, @RequestBody User user) {
		User old = userRepository.findOne(id);
		Assert.isNotNull("该账号不存在", old);
		if (StringUtils.isNotEmpty(user.getPassword())) {
			old.setPassword(user.getPassword());
		}
		old.setMobilePhone(user.getMobilePhone());
		userRepository.save(old);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{username}/personal", method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePersonal(@PathVariable String username, @RequestBody User user) {
		User old = userRepository.findByUsername(username);
		Assert.isNotNull("账号不存在", old);
		old.setMobilePhone(user.getMobilePhone());
		userRepository.save(old);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{username}/password", method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePassword(@PathVariable String username, @RequestBody PasswordChange passwordChange) {
		Assert.isNotEmpty("旧密码为空", passwordChange.getOldPassword());
		Assert.isNotEmpty("新密码为空", passwordChange.getNewPassword());
		User old = userRepository.findByUsername(username);
		Assert.isNotNull("该账号不存在", old);
		Assert.isEquals("旧密码不正确", passwordChange.getOldPassword(), old.getPassword());
		old.setPassword(passwordChange.getNewPassword());
		userRepository.save(old);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
