package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.ProductBO;

public final class ProductDAOImpl implements IProductDao {
	
	private static final String INSERT_QUERY = "INSERT INTO SPRING_PRODUCT VALUES(SPRING_PRODUCT_SEQUENCE.NEXTVAL,?,?,?,?,?,?)";
	private DataSource ds;
	
	public ProductDAOImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public int insertProduct(ProductBO bo) throws Exception {
		//create connection obj
		Connection con = ds.getConnection();
		//create preparedStatement obj
		PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
		//set values to ps obj from ProductBO obj
		ps.setString(1, bo.getPname());
		ps.setString(2, bo.getType());
		ps.setFloat(3, bo.getQty());
		ps.setFloat(4, bo.getBasePrice());
		ps.setFloat(5, bo.getMrp());
		ps.setString(6, bo.getStatus());
		//execute Query
		int result = ps.executeUpdate();
		//close objs
		ps.close();
		con.close();
		
		return result;
	}

}
