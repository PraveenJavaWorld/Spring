package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.ICBScoreMgmtService;

@WebServlet(value = "/controller",loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
	
	private ApplicationContext ctx;
	

	public void init(ServletConfig config) throws ServletException {
		//create IOC Container
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get service class obj
		ICBScoreMgmtService service = ctx.getBean("service",ICBScoreMgmtService.class);
		// read match id as the request param value
		int mid = Integer.parseInt(req.getParameter("mid"));
		//invoke service class b.method
		String score = service.findScore(mid);
		//keep result in request scope
		req.setAttribute("score", score);
		//forward attribute to jsp
		RequestDispatcher rd = req.getRequestDispatcher("show_score.jsp");
		rd.forward(req, res);
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	
	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}

}
