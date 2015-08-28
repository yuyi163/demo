package com.yy.metronic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.metronic.entity.Attachment;
import com.yy.metronic.repository.AttachmentRepository;


@Service("attachmentService")
public class AttachmentServiceImp implements AttachmentService {
	
	@Autowired
	private AttachmentRepository ar;

	@Transactional
	public void saveAttachment(Attachment attachment) {
		ar.save(attachment);
	}

	@Transactional
	public void saveAttachments(List<Attachment> attachments) {
		ar.save(attachments);

	}

}
