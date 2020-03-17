package com.example.demo.service.implement;

import java.util.List;

import com.example.demo.dto.ImageDto;
import com.example.demo.pojo.Image;

public interface IImageService {

	List<Image> getAllData();
	
	List<ImageDto> getImageSearch(String searchValue);
	
	List<ImageDto> findImageList();
	
	List<ImageDto> getImageFromPapidApi(String searchValue);
	
}
