package com.yy.metronic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yy.metronic.entity.Attachment;



//与数据库交互
//持久层
public interface AttachmentRepository extends JpaRepository<Attachment,String>{
	
	
}
