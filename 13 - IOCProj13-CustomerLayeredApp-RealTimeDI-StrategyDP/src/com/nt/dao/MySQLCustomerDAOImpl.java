package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public final class MySQLCustomerDAOImpl implements ICustomerDAO {

	private static final String INSERT_QUERY = "INSERT INTO LAYERED_CUSTOMER(cname,address,principle_amount,roi,time,interest_amount) VALUES(?,?,?,?,?,?)";
	private DataSource ds;

	public MySQLCustomerDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public int insert(CustomerBO bo) throws Exception {
		Connection con = null;
		//get pooled jdbc connection object
		con = ds.getConnection();
		//create PreparedStatement object
		PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
		//set values to query params by collecting data from BO class object
		ps.setString(1, bo.getCname());
		ps.setString(2, bo.getAddress());
		ps.setFloat(3, bo.getpAmt());
		ps.setFloat(4, bo.getRate());
		ps.setFloat(5, bo.getTime());
		ps.setFloat(6, bo.getIntAmt());
		
		//execute sql query
		int result = ps.executeUpdate();
		//close jdbc objects
		ps.close();
		con.close();
		
		return result;
	}

}
