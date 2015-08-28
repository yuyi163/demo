package com.yy.metronic.service;

import java.util.List;

import com.yy.metronic.entity.Attachment;

public interface AttachmentService {
	
	public void saveAttachment(Attachment attachment);
	
	public void saveAttachments(List<Attachment> attachments);

}
