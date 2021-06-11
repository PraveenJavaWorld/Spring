package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.ILocaleMgmtService;

@Controller
public class LocaleController {
	
	@Autowired
	private ILocaleMgmtService service;
	
	@RequestMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/countriesList")
	public ModelAndView countriesList() {
		//use service
		List<String> list = service.getCountriesList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("countriesList", list);
		mav.setViewName("countriesList");
		return mav;
	}
	
	@RequestMapping("/languagesList")
	public ModelAndView languagesList() {
		//use service
		List<String> list = service.getLanguagesList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("languagesList", list);
		mav.setViewName("languagesList");
		return mav;
	}
	
	@RequestMapping("/about")
	public String showAboutUs() {
		return "about_us";
	}
	
	@RequestMapping("/contact")
	public String showContactUs() {
		return "contact_us";
	}

}
