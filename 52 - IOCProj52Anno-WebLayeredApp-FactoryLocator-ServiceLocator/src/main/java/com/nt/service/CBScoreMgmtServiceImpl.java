package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.external.IICCScoreComp;

@Service("service")
public class CBScoreMgmtServiceImpl implements ICBScoreMgmtService {
	
	@Autowired
	private IICCScoreComp comp;

	@Override
	public String findScore(int mid) {
		//get external comp and invoke b.method
		String score = comp.getScore(mid);
		return score;
	}

}
