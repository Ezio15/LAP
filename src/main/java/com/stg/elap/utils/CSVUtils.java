package com.stg.elap.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.stg.elap.model.CityMasterModel;

public class CSVUtils {

	

	public <T> List<T> csvToBean(
			HeaderColumnNameTranslateMappingStrategy<CityMasterModel> strategy, MultipartFile file) {
		try {
			 CSVReader csvReader = null; 
		        try { 
		        	BufferedReader fileReader = new BufferedReader(new 
		        			InputStreamReader(file.getInputStream(), "UTF-8"));
		            csvReader = new CSVReader(fileReader); 
		        } 
		        catch (FileNotFoundException e) { 
		  
		            // TODO Auto-generated catch block 
		            e.printStackTrace(); 
		        } 
		        CsvToBean csvToBean = new CsvToBean(); 
		        
		        return csvToBean.parse(strategy, csvReader); 
		  
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
