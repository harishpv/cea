package com;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.utils.HttpUtils;
import com.app.utils.Logging;

@Controller
@RequestMapping("/api1")
public class AppController {

	@Autowired
	HttpUtils httpUtils;
	
	@RequestMapping("/getContents")
	public String getContents(@Valid @RequestParam(value = "path") String path, Map<String, Object> model) {
		try {
			Logging.getInfoLog().info("Request recieved at getFoldersAndCOntents : " + path);
			model.put("message", path);
			model.put("files", httpUtils.getFilesAndFolders(path));
		} catch (Exception e) {
			Logging.getErrorLog().error("Exception at retrieving", e);
		} 
		return "view";
	}
	
	@RequestMapping("/downloadFile")
	public String downloadContents(@Valid @RequestParam(value = "path") String path, Map<String, Object> model) {
		try {
			Logging.getInfoLog().info("Request recieved at downloading " + path);
			return "redirect:" + httpUtils.getDownloadLinks(path).getProviderLink();
		} catch (Exception e) {
			Logging.getErrorLog().error("Exception at downloadng", e);
		} 
		return "view";
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"}, value="/upload")
	public String importQuestion(@RequestParam(value = "path") String path, 
			@Valid @RequestParam("file") MultipartFile multipart,  MultipartHttpServletRequest request) {
		httpUtils.uploadFile(path, multipart);
	   return "view";
	}

}