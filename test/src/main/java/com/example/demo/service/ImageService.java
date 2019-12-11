package com.example.demo.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.constant.EnvironmentConstant;
import com.example.demo.dto.ImageDto;
import com.example.demo.dto.SearchImageDto;
import com.example.demo.dto.json.RapidApiImageJsonDto;
import com.example.demo.dto.json.RapidApiJsonDto;
import com.example.demo.pojo.Image;
import com.example.demo.reoisitory.AppExceptionRepo;
import com.example.demo.reoisitory.ImageRepo;
import com.example.demo.service.implement.IAppExceptionLogService;
import com.example.demo.service.implement.IImageService;
import com.example.demo.util.DemoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Configurable
public class ImageService implements IImageService{

	@Autowired
	ImageRepo imageRepo;
	
	@Autowired
	IAppExceptionLogService appExceptionLog;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageService.class);
	
	public List<Image> getAllData(){
		return (List<Image>) imageRepo.findAll();
	}
	
	public List<ImageDto> getImageSearch(String searchValue){
		
		List<Image> pojo = imageRepo.getImageBySearchValue(searchValue.toUpperCase().replaceAll("\\s+", ""));
		
		return pojoToDto(pojo);
	}
	
	public List<ImageDto> findImageList() {
		return pojoToDto(this.getAllData());
	}
	
	private List<ImageDto> pojoToDto(List<Image> pojoList){
		return pojoList.stream().map((Function<? super Image, ? extends ImageDto>) entry->{
			return new ImageDto(entry);
		}).collect(Collectors.toList());
	}
	
	public List<ImageDto> getImageFromPapidApi(String searchValue) {
		
		try {	
			
			List<ImageDto> imageDtoList = new ArrayList<ImageDto>();
			
//			String searchValue = "Taylor Swift";
			
			if(searchValue != null && !searchValue.trim().isEmpty()) {
				
				SearchImageDto searchPicDto = new SearchImageDto(searchValue);
				Map<String, Object> dtoData = DemoUtil.introspect(searchPicDto);
				String paramValue = DemoUtil.demoUrl(dtoData);
							
				Map<String, String> headerMap = new LinkedHashMap<String, String>();
				headerMap.put(EnvironmentConstant.K_RAPIDAPI_HOST, EnvironmentConstant.V_RAPIDAPI_HOST);
				headerMap.put(EnvironmentConstant.K_RAPIDAPI_KEY, EnvironmentConstant.V_RAPIDAPI_KEY);
				
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.setAll(headerMap);
				HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
				
				RestTemplate restTemplate = new RestTemplate();
				
				final String baseUrl = "https://"+EnvironmentConstant.V_RAPIDAPI_HOST+"/api/Search/ImageSearchAPI?"+paramValue;
				
				ResponseEntity<String> result = restTemplate.exchange(baseUrl, HttpMethod.GET, requestEntity, String.class);
				
				RapidApiJsonDto jsonObj = new ObjectMapper().readValue(result.getBody(), RapidApiJsonDto.class);
				
				List<Image> imagePojoList = new ArrayList<Image>();
				
				String dbSearchString = searchValue.toUpperCase().replaceAll("\\s+", "");
				
				for(RapidApiImageJsonDto x:jsonObj.getValue()) {
					Image imagePojo = new Image(x);
					imagePojo.setSearchValue(dbSearchString);
					ImageDto imageDto = new ImageDto(imagePojo);
					imageDtoList.add(imageDto);
					imagePojoList.add(imagePojo);
				}
				imageRepo.saveAll(imagePojoList);
				
			}
			
			
			return imageDtoList;
		}catch(Exception e) {
			
			appExceptionLog.insertException(e, ImageService.class);
			e.printStackTrace();
			return new ArrayList<ImageDto>();
		}
		
	}
	
}
