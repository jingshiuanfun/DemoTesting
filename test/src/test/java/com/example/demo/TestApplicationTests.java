package com.example.demo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.constant.EnvironmentConstant;
import com.example.demo.dto.SearchImageDto;
import com.example.demo.dto.json.RapidApiJsonDto;
import com.example.demo.pojo.Image;
import com.example.demo.service.AppExceptionLogService;
import com.example.demo.util.DemoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
		
		try {	
			String searchValue = "Taylor Swift";
			SearchImageDto searchPicDto = new SearchImageDto(searchValue);
			Map<String, Object> dtoData = DemoUtil.introspect(searchPicDto);
			String paramValue = DemoUtil.demoUrl(dtoData);
						
			Map headerMap = new LinkedHashMap();
			headerMap.put(EnvironmentConstant.K_RAPIDAPI_HOST, EnvironmentConstant.V_RAPIDAPI_HOST);
			headerMap.put(EnvironmentConstant.K_RAPIDAPI_KEY, EnvironmentConstant.V_RAPIDAPI_KEY);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAll(headerMap);
			HttpEntity<Image> requestEntity = new HttpEntity<>(null, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			
			final String baseUrl = "https://"+EnvironmentConstant.V_RAPIDAPI_HOST+"/api/Search/ImageSearchAPI?"+paramValue;
			
			ResponseEntity<String> result = restTemplate.exchange(baseUrl, HttpMethod.GET, requestEntity, String.class);
			
			RapidApiJsonDto jsonObj = new ObjectMapper().readValue(result.getBody(), RapidApiJsonDto.class);
			
			System.out.println(result.getStatusCodeValue());
			System.out.println(jsonObj);

			
		}catch(Exception e) {
//			new AppExceptionLogImpl().insertException(e, TestApplicationTests.class);
			e.printStackTrace();
		}
			
		
	}

}
