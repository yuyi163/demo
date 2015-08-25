package com.yy.metronic.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yy.metronic.commons.util.JsonUtils;

@RestController
@RequestMapping("/files")
public class FileRestController {

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void POST(@RequestParam(value = "file") MultipartFile file, HttpServletResponse response) throws IOException {
		FileResponse fileResponse = new FileResponse();
		SimpleDateFormat dateFormat = new SimpleDateFormat("/yyyy/MM/dd/");
		String dir = "/upload" + dateFormat.format(new Date()) + RandomUtils.nextInt();
		new File("\\\\192.168.0.111\\FileRoot" + dir).mkdirs();
		fileResponse.path = dir + "/" + file.getOriginalFilename();
		try {
			FileCopyUtils.copy(file.getInputStream(), new FileOutputStream("\\\\192.168.0.111\\FileRoot" + fileResponse.path));
		} catch (IOException e) {
			e.printStackTrace();
			fileResponse.success = false;
		}
		response.addHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(JsonUtils.toJsonString(fileResponse));
		writer.flush();
		writer.close();
	}

	protected class FileResponse {

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
