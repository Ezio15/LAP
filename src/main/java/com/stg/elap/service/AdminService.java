package com.stg.elap.service;

import org.springframework.web.multipart.MultipartFile;

public interface AdminService {

	String uploadCityMaster(MultipartFile file);
	
	String uploadCityWiseDocument(MultipartFile file);
}
