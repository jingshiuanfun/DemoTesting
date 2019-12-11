package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "APP_EXCEPTION_LOG")
public class AppExceptionLog extends CommonPojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2167977121715304119L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
	private Long id;
	
//	@Column(name = "MESSAGE", length=200, nullable=false)
//	private String message;
	
	@Column(name = "CLASSPATH", length=500, nullable=false)
	private String classpath;
	
	@Column(name = "UNIQUE_ID ", length=50, nullable=false)
	private String uniqueId;
	
	@Lob
	@Column(name = "\"STACK_TRACE\"", columnDefinition = "LONGTEXT")
	private String stackTrace;
	
	@Column(name = "SERVER_NAME", length=80)
	private String serverName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}

	public String getClasspath() {
		return classpath;
	}

	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	
	
}
