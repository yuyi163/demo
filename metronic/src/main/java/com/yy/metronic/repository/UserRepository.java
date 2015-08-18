package com.yy.metronic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yy.metronic.entity.User;


//与数据库交互
public interface UserRepository extends JpaRepository<User,String>{
	
	User findByMobilePhone(String mobilePhone);
	
	User findByUsername(String username);
}
