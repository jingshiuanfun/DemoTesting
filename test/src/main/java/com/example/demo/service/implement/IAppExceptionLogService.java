package com.example.demo.service.implement;

import com.example.demo.pojo.AppExceptionLog;

public interface IAppExceptionLogService {

	public AppExceptionLog insertException(Exception exception, Class<?> classObj);
	
}
