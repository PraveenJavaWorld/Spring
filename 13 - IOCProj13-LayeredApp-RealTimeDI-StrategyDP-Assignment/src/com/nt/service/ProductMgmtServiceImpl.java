package com.nt.service;

import com.nt.bo.ProductBO;
import com.nt.dao.IProductDao;
import com.nt.dto.ProductDTO;

public final class ProductMgmtServiceImpl implements IProductMgmtService {

	private IProductDao dao;

	public ProductMgmtServiceImpl(IProductDao dao) {
		this.dao = dao;
	}

	@Override
	public String calculateMRP(ProductDTO dto) throws Exception {
		
		//calculate MRP
		float mrp = 0;
		float basePrice = dto.getBasePrice();
		if(basePrice<50) {
			mrp = basePrice+basePrice*12/100;
		}
		else if(basePrice<100) {
			mrp = basePrice+basePrice*15/100;
		}
		else if(basePrice>100) {
			mrp = basePrice+basePrice*18/100;
		}

		//set status by qty
		String status = null;
		float qty = dto.getQty();
		if(qty>=1.0f) {
			status = "Available";
		}
		else {
			status = "UnAvailable";
		}
			
		//create ProductBO obj 
		ProductBO bo = new ProductBO();
		bo.setPname(dto.getPname());
		bo.setType(dto.getType());
		bo.setBasePrice(dto.getBasePrice());
		bo.setQty(dto.getQty());
		bo.setMrp(mrp);
		bo.setStatus(status);
		
		//use dao
		int result = dao.insertProduct(bo);

		//immediate if or ternary operator <condition>?<success>:<failure>
		return result==0?"Product Registration Failed":"Product Registration Succeed";
	}

}
