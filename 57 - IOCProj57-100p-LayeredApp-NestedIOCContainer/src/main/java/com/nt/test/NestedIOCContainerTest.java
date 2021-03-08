package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.BusinessAppConfig;
import com.nt.config.PresentationAppConfig;
import com.nt.controller.MainController;

public class NestedIOCContainerTest {

	public static void main(String[] args) {
		
		//create Parent IOC Container
		AnnotationConfigApplicationContext pCtx = new AnnotationConfigApplicationContext(BusinessAppConfig.class);
		//create Child IOC Container
		/*AnnotationConfigApplicationContext cCtx = new AnnotationConfigApplicationContext(PresentationAppConfig.class);
		cCtx.setParent(pCtx);*/ //Model 1 using @Lazy on ControllerClass
		AnnotationConfigApplicationContext cCtx = new AnnotationConfigApplicationContext();
		cCtx.setParent(pCtx);
		cCtx.register(PresentationAppConfig.class);
		cCtx.refresh();
		
		//get Controller Obj
		MainController controller = cCtx.getBean("controller",MainController.class);
		//invoke methods
		try {
			controller.showEmpsByDesgs("CLERK", "MANAGER", "SALESMAN").forEach(dto->{
				System.out.println(dto);
			});
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//close Containers
		pCtx.close();
		cCtx.close();

	}//main

}
