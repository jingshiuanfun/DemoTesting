package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.demo.dto.json.RapidApiImageJsonDto;
import com.example.demo.util.UtilityDateBean;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "IMAGE")
public class Image extends CommonPojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8972936624098783514L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
	private Long id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="TITLE")
    private String title;
    
    @Column(name = "SEARCH_VALUE")
    private String searchValue;
    
    @Column(name="URL")
    private String url;
    @Column(name="HEIGHT")
    private int height;
    @Column(name="WIDTH")
    private int width;
    @Column(name="THUMBNAIL")
    private String thumbnail;
    @Column(name="THUMBNAIL_HEIGHT")
    private int thumbnailHeight;
    @Column(name="THUMBNAIL_WIDTH")
    private int thumbnailWidth;
    @Column(name="BASE_64_ENCODING")
    private String base64Encoding;
    
	public Image() {

	}

	public Image(RapidApiImageJsonDto dto) {
		this.name = dto.getName();
		this.title = dto.getTitle();
		this.url = dto.getUrl();
		this.height = dto.getHeight();
		this.width = dto.getWidth();
		this.thumbnail = dto.getThumbnail();
		this.thumbnailHeight = dto.getThumbnailHeight();
		this.thumbnailWidth = dto.getThumbnailWidth();
		this.base64Encoding = dto.getBase64Encoding();
		this.createDate = UtilityDateBean.getCurrentDate();
		this.updateDate = UtilityDateBean.getCurrentDate();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
    
}
