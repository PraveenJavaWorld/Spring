package com.nt.external;

public class ICCScoreCompImpl implements IICCScoreComp {

	@Override
	public String getScore(int mid) {
		
		if(mid==1001)
			return "IND vs PAK :: 300/4. INDIA is Batting";
		else if(mid==1002)
			return "AUS vs ENG :: 250/8. ENGLAND is Batting";
		else if(mid==1003)
			return "NZ vs WI :: 390/10. WEST INDIES is Batting";
		else
			throw new IllegalArgumentException("invalid match id");
	}

}
