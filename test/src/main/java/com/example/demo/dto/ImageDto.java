package com.example.demo.dto;

import com.example.demo.pojo.Image;

public class ImageDto {

	private Long id;
	private String url;
	private String thumbnail;
	
	public ImageDto() {}
	
	public ImageDto(Image pojo) {
		this.id = pojo.getId();
		this.url = pojo.getUrl();
		this.thumbnail = pojo.getThumbnail();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
}
