package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.model.ActorDetails;

@Repository("actorDAO")
public class ActorDAOImpl implements IActorDAO {


	@Autowired
	private SimpleJdbcInsert sji;
	
	/*@Override
	public int insertActor(ActorDetails info) {
		//set table name
		sji.setTableName("ACTOR");
		//give col names and values
		Map<String,Object> map = Map.of("ID",info.getId(),
				"NAME",info.getName(),
				"ADDRESS",info.getAddress(),
				"CAR",info.getCar(),
				"REMUNERATION",info.getRemuneration());
		
		//execute the query
		int count = sji.execute(map);
		return count;
	}*/
	
	@Override
	public int insertActor(ActorDetails info) {
		//set table name
		sji.setTableName("ACTOR");
		//execute the query
		int count = sji.execute(new BeanPropertySqlParameterSource(info));
		return count;
	}

}
