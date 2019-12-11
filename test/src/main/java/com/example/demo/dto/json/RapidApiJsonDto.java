package com.example.demo.dto.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RapidApiJsonDto {

	@JsonProperty("_type")
	private String _type;
	
	@JsonProperty("totalCount")
	private int totalCount;
	
	@JsonProperty("value")
	private List<RapidApiImageJsonDto> value;
	
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<RapidApiImageJsonDto> getValue() {
		return value;
	}
	public void setValue(List<RapidApiImageJsonDto> value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "RepidApiJsonDto [_type=" + _type + ", totalCount=" + totalCount + ", value=" + value + "]";
	}
	
	
	
}
