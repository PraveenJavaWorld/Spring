package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.service.ILocaleMgmtService;

public class CountriesListController implements Controller {
	
	private ILocaleMgmtService service;
	
	public CountriesListController(ILocaleMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//use service
		List<String> list = service.getCountriesList();

		return new ModelAndView("result","countriesList",list);
	}

}
