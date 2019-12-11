package com.example.demo.dto;

public class SearchImageDto {

	private boolean autoCorrect;
	private int pageNumber;
	private int pageSize;
	private String q;
	private boolean safeSearch;
	
	public SearchImageDto(String searchValue){
		//For Default from sample
		super();
		this.autoCorrect = Boolean.TRUE;
		this.pageNumber = 1;
		this.pageSize = 10;
		this.q = searchValue;
		this.safeSearch = Boolean.FALSE;
	}
	
	public SearchImageDto(boolean autoCorrect, int pageNumber, int pageSize, String q, boolean safeSearch) {
		super();
		this.autoCorrect = autoCorrect;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.q = q;
		this.safeSearch = safeSearch;
	}
	
	public boolean isAutoCorrect() {
		return autoCorrect;
	}
	public void setAutoCorrect(boolean autoCorrect) {
		this.autoCorrect = autoCorrect;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public boolean isSafeSearch() {
		return safeSearch;
	}
	public void setSafeSearch(boolean safeSearch) {
		this.safeSearch = safeSearch;
	}
	
	
	
}
