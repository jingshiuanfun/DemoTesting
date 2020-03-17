package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Image;

@Repository
public interface ImageRepo extends CrudRepository<Image, Integer>{

	@Query(value = "SELECT i FROM IMAGE i WHERE i.IS_DELETED = 0",nativeQuery = true)
	public List<Image> getImageDemo();
	
	@Query(value = "SELECT * FROM IMAGE i WHERE i.IS_DELETED = 0 AND i.SEARCH_VALUE = ?1",nativeQuery = true)
	public List<Image> getImageBySearchValue(String searchValue);
	
}
