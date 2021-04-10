package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("MySQL")
@Profile({"dev","test"})
public class MySQLCustomerDAOImpl implements ICustomerDAO {

	private static String INSERT_QUERY = "INSERT INTO LAYERED_CUSTOMER(cname,address,principle_amount,roi,time,interest_amount) VALUES(?,?,?,?,?,?)";
	@Autowired
	private DataSource ds;
	
	public MySQLCustomerDAOImpl() {
		System.out.println("MySQLCustomerDAOImpl::0-param constructor");
	}

	@Override
	public int insert(CustomerBO bo) throws Exception {
		Connection con = null;
		//get pooled jdbc connection object
		con = ds.getConnection();
		System.out.println("DataSource Class is :: "+ds.getClass());
		//create PreparedStatement object
		PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
		//set values to query params by collecting data from BO class object
		ps.setString(1, bo.getCname());
		ps.setString(2, bo.getAddress());
		ps.setFloat(3, bo.getPAmt());
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
