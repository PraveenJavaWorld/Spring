package com.nt.service;

import com.nt.dto.ProductDTO;

public interface IProductMgmtService {
	
	public String calculateMRP(ProductDTO dto) throws Exception;

}
