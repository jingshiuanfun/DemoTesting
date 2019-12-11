package com.example.demo.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CommonPojo implements java.io.Serializable{

	private static final long serialVersionUID = 4199902115070052779L;
	
	private static final String DEFAULT_EMPTY_VALUE = "";
	
	@Column(name = "IS_DELETED")
	protected boolean isDeleted;
	
	@Column(name = "CREATE_DATE", nullable=false)
	protected Date createDate;
	
	@Column(name = "UPDATE_DATE")
	protected Date updateDate;

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getDefaultEmptyValue() {
		return DEFAULT_EMPTY_VALUE;
	}
	
	
}
