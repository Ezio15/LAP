package com.stg.elap.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.stg.elap.model.CityMasterModel;
import com.stg.elap.utils.CSVUtils;


public class AdminServiceImpl implements AdminService{

	@Autowired
	CSVUtils csvUtil;
	@Override
	public String uploadCityWiseDocument(MultipartFile file) {
		try {
			 Map<String, String> mapping = new 
                     HashMap<String, String>(); 
       mapping.put("CITY", "city"); 
       mapping.put("DOCUMENTITLE", "documentTitle"); 
       mapping.put("COPIES", "copies"); 
       mapping.put("UPLOADEDBY", "uploadedBy"); 
       mapping.put("UPLOADEDDATE", "uploadedDate"); 
       
       HeaderColumnNameTranslateMappingStrategy<CityMasterModel> strategy = 
               new HeaderColumnNameTranslateMappingStrategy<CityMasterModel>(); 
          strategy.setType(CityMasterModel.class); 
          strategy.setColumnMapping(mapping); 
          
          List<CityMasterModel> masterCityList = csvUtil.csvToBean(strategy,file);
			
          for(CityMasterModel result: masterCityList)
          System.out.println("city-");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String uploadCityMaster(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

}
