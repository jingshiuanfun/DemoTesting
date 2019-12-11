package com.example.demo.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RapidApiImageJsonDto {

	@JsonProperty("url")
	private String url;
	
	@JsonProperty("height")
	private int height;
	
	@JsonProperty("width")
	private int width;
	
	@JsonProperty("thumbnail")
	private String thumbnail;
	
	@JsonProperty("thumbnailHeight")
	private int thumbnailHeight;
	
	@JsonProperty("thumbnailWidth")
	private int thumbnailWidth;
	
	@JsonProperty("base64Encoding")
	private String base64Encoding;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("title")
	private String title;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getThumbnailHeight() {
		return thumbnailHeight;
	}
	public void setThumbnailHeight(int thumbnailHeight) {
		this.thumbnailHeight = thumbnailHeight;
	}
	public int getThumbnailWidth() {
		return thumbnailWidth;
	}
	public void setThumbnailWidth(int thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}
	public String getBase64Encoding() {
		return base64Encoding;
	}
	public void setBase64Encoding(String base64Encoding) {
		this.base64Encoding = base64Encoding;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "RapidApiImageJsonDto [url=" + url + ", height=" + height + ", width=" + width + ", thumbnail="
				+ thumbnail + ", thumbnailHeight=" + thumbnailHeight + ", thumbnailWidth=" + thumbnailWidth
				+ ", base64Encoding=" + base64Encoding + ", name=" + name + ", title=" + title + "]";
	}
	
	
}
