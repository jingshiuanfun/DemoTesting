package com.example.demo.service.implement;

import java.util.List;

import com.example.demo.dto.ImageDto;
import com.example.demo.pojo.Image;

public interface IImageService {

	public List<Image> getAllData();
	
	public List<ImageDto> getImageSearch(String searchValue);
	
	public List<ImageDto> findImageList();
	
	public List<ImageDto> getImageFromPapidApi(String searchValue);
	
}
