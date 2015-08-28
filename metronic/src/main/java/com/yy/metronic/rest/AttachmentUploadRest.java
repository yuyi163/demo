package com.yy.metronic.rest;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/attachment")
public class AttachmentUploadRest {
	 
	@RequestMapping(value = "/oneFileUpload", method = RequestMethod.POST)  
	public void upload1(@RequestParam("name")  String name, @RequestParam("file")  MultipartFile file,HttpServletResponse response) throws IOException {  
		AttachmentResponse ar = new AttachmentResponse();
		SimpleDateFormat dateFormat = new SimpleDateFormat("/yyyy/MM/dd/");
		String dir = "/upload1" + dateFormat.format(new Date()) + RandomUtils.nextInt();
		new File("\\\\192.168.0.111\\FileRoot" + dir).mkdirs();
		ar.path = dir + "/" + file.getOriginalFilename();  
		
		response.addHeader("content-type", "text/html;charset=UTF-8");
		
	    if (!file.isEmpty()) {  
	    	try{
	    		this.copyFile(file.getInputStream(), ar.path);  
	    	}catch(IOException e){
	    		e.printStackTrace();
	    		ar.success = false;
	    	}
	    }   
	}  
	
	
	@RequestMapping(value = "/multipartFileUpload",method = RequestMethod.POST)  
    public void upload2(MultipartHttpServletRequest request , @RequestParam("name") String name , HttpServletResponse response) throws Exception {  
	    List<MultipartFile> files = request.getFiles("file");  
	 	AttachmentResponse ar = new AttachmentResponse();
		SimpleDateFormat dateFormat = new SimpleDateFormat("/yyyy/MM/dd/");
		String dir = "/upload1" + dateFormat.format(new Date()) + RandomUtils.nextInt();
		new File("\\\\192.168.0.111\\FileRoot" + dir).mkdirs();
		
		response.addHeader("content-type", "text/html;charset=UTF-8");
		
	    for( int i=0; i<files.size() ;i++){  
	          if(! files.get(i).isEmpty()) {  
	        	  MultipartFile file = files.get(i);
	        	  ar.path = dir + "/" + file.getOriginalFilename();
	        	  try{
	        		  this.copyFile(files.get(i).getInputStream(), ar.path);  
	        	  }catch(IOException e){
	  	    		e.printStackTrace();
	  	    		ar.success = false;
	  	    	}
	          }  
	     }  
    }  
	
	private void copyFile(InputStream in,String targetFileName) throws IOException{  
        FileOutputStream fs = new FileOutputStream(targetFileName);  
          byte[] buffer = new byte[1024 * 1024];  
          int bytesum = 0;  
          int byteread = 0;  
          while ((byteread = in.read(buffer)) != -1) {  
              bytesum += byteread;  
              fs.write(buffer, 0, byteread);  
              fs.flush();  
          }  
          fs.close();  
          in.close();  
    }  
	
	protected class AttachmentResponse {

		protected boolean success = true;

		protected String path;

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getUri() {
			return "http://192.168.0.111/FileRoot" + path;
		}

	}
}
