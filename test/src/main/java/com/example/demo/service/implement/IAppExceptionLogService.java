package com.example.demo.service.implement;

import com.example.demo.pojo.AppExceptionLog;

public interface IAppExceptionLogService {

	AppExceptionLog insertException(Exception exception, Class<?> classObj);
	
}
