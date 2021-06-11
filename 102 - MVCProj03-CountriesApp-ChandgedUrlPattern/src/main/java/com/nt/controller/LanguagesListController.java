package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.service.ILocaleMgmtService;

public class LanguagesListController implements Controller {
	
	private ILocaleMgmtService service;
	
	public LanguagesListController(ILocaleMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//use service
		List<String> list1 = service.getLanguagesList();
		return new ModelAndView("languagesList","languagesList",list1);
	}

}
