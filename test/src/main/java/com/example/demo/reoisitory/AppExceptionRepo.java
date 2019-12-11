package com.example.demo.reoisitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.AppExceptionLog;

public interface AppExceptionRepo extends CrudRepository<AppExceptionLog, Integer>{

	@Query(
			value = "SELECT * FROM APP_EXCEPTION_LOG a WHERE a.IS_DELETED = 0",
			nativeQuery = true)
	List<AppExceptionLog> getAllExceptionLog();
	
}
