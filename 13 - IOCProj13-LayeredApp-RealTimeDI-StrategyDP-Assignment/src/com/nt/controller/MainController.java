package com.nt.controller;

import com.nt.dto.ProductDTO;
import com.nt.service.IProductMgmtService;
import com.nt.vo.ProductVO;

public final class MainController {
	
	private IProductMgmtService service;

	public MainController(IProductMgmtService service) {
		this.service = service;
	}
	
	public String processProduct(ProductVO vo) throws Exception {
		//create ProductDTO obj
		ProductDTO dto = new ProductDTO();
		//convert ProductVO to ProductDTO
		dto.setPname(vo.getPname());
		dto.setType(vo.getType());
		dto.setBasePrice(Float.parseFloat(vo.getBasePrice()));
		dto.setQty(Float.parseFloat(vo.getQty()));
		
		//use service obj
		String result = service.calculateMRP(dto);
		
		return result;
	}
	
	

}
