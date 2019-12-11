package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.ActionUrlConstant;
import com.example.demo.common.JspPathEnum;
import com.example.demo.common.RenderUrlConstant;
import com.example.demo.dto.ImageDto;
import com.example.demo.service.ImageService;

@Controller
@Configurable
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	@RequestMapping(path = RenderUrlConstant.INDEX, method = RequestMethod.GET)
	public String index(Model model) throws Exception{
		List<ImageDto> imageDtoList = imageService.findImageList();
		
		model.addAttribute("imageList",imageDtoList);
		
		return JspPathEnum.DEMO_TEST.getJspPath();
	}
	
	@RequestMapping(path = ActionUrlConstant.SEARCH_IMAGE, method = RequestMethod.POST)
	public String searchValue(@RequestParam String searchValue, ModelMap modelMap) {
		
		logger.debug("##SearchValue: " + searchValue);
		List<ImageDto> imageDtoList = imageService.getImageSearch(searchValue);
		if(imageDtoList.isEmpty()) {
			logger.debug("Cannot Get Result From DB Get From API");
			imageDtoList = imageService.getImageFromPapidApi(searchValue);
		}else {
			logger.debug("Found Record: "+ imageDtoList.size());
		}
		
		modelMap.addAttribute("imageList", imageDtoList);
		
		return JspPathEnum.DEMO_TEST.getJspPath();
	}
	
}
