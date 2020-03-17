package com.example.demo.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.AppExceptionLog;
import com.example.demo.repository.AppExceptionRepo;
import com.example.demo.service.implement.IAppExceptionLogService;
import com.example.demo.util.UtilityDateBean;

@Service
@Configurable
public class AppExceptionLogService implements IAppExceptionLogService{

	private static final Logger logger = LoggerFactory.getLogger(AppExceptionLogService.class);
	
	@Autowired
	AppExceptionRepo repo;
	
	public AppExceptionLog insertException(Exception exception, Class<?> classObj) {
				
		AppExceptionLog appLogException = new AppExceptionLog();
		
		StringWriter errors = new StringWriter();
		exception.printStackTrace(new PrintWriter(errors));
		
		appLogException.setStackTrace(errors.toString());
		logger.debug("clob="+errors.toString().length());
		logger.debug("classPath="+classObj.getResource(classObj.getSimpleName()+ ".class").getPath().length());
//		logger.debug("message="+exception.toString());
//		appLogException.setMessage(exception.toString());
		appLogException.setClasspath(classObj.getResource(classObj.getSimpleName()+ ".class").getPath());
		
		String serviceName = "";
		try {
			serviceName = InetAddress.getLocalHost().getHostName();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		appLogException.setServerName(serviceName);
		appLogException.setUniqueId(String.valueOf(UtilityDateBean.getCalendar(UtilityDateBean.getCurrentDate()).getTimeInMillis()));
		appLogException.setCreateDate(UtilityDateBean.getCurrentDate());
		appLogException.setUpdateDate(UtilityDateBean.getCurrentDate());
				
		return repo.save(appLogException);
		
	}
	
}
