package com.nt.beans;

import java.util.Date;
import java.util.Map;

public class FruitsInfo {

	private Map<String, String> fruitsInfo;
	private Map<String, Date> impDates;

	public FruitsInfo(Map<String, String> fruitsInfo, Map<String, Date> impDates) {
		super();
		this.fruitsInfo = fruitsInfo;
		this.impDates = impDates;
	}

	@Override
	public String toString() {
		return "FruitsInfo [fruitsInfo=" + fruitsInfo + ", impDates=" + impDates + "]";
	}

}
