package com.stg.elap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stg.elap.model.UserModel;
import com.stg.elap.responseentity.CommonResponse;
import com.stg.elap.responseentity.LoginResponse;
import com.stg.elap.service.AdminService;
import com.stg.elap.utils.CommonUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {
//	
//	@Autowired
//	CommonUtil utilObj;
//	
//	@Autowired
//	AdminService adminService;
//
//	@PostMapping("/uploadDocument")
//	ResponseEntity<CommonResponse>  uploadCityWiseDocument(@RequestParam("file") MultipartFile file) {
//
//		String message = "";
//		CommonResponse response = new CommonResponse();
//		try {
//			System.out.println("file-"+file.getOriginalFilename());
//			if(file!=null) {
//			if(utilObj.checkFileExtension(file.getOriginalFilename(), "csv")) {
//				
//				message =  adminService.uploadCityMaster(file);
//				if(message.equalsIgnoreCase("success")) {
//				 message = "Uploaded the file successfully: " + file.getOriginalFilename();
//				}else {
//					
//				}
//				}else {
//				message = "Please upload CSV file type!";
//			}
//			}else {
//				message = "File not uploaded properly. Please upload again";
//			}
//		     
//			response.setMessage(message);
//		      return ResponseEntity.status(HttpStatus.OK).body(response);
//		}catch (Exception e) {
//			// TODO: handle exception
//			response.setMessage("Exception: While uploading document : "+e.getMessage());
//		}
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//		
//	}
//	
//	
//	@PostMapping("/uploadCity")
//	ResponseEntity<CommonResponse>  uploadCityMaster(@RequestParam("file") MultipartFile file) {
//
//		String message;
//		CommonResponse response = new CommonResponse();
//		try {
//			System.out.println("file-"+file.getOriginalFilename());
////			if()
//		      message = "Uploaded the file successfully: " + file.getOriginalFilename();
//		      response.setMessage(message);
//		      return ResponseEntity.status(HttpStatus.OK).body(response);
//		}catch (Exception e) {
//			// TODO: handle exception
//			response.setMessage("Exception: While uploading document : "+e.getMessage());
//		}
//		return null;
//		
//	}
//	
}
