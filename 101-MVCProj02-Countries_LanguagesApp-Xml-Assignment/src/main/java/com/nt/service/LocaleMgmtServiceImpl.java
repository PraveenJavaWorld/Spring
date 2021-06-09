package com.nt.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class LocaleMgmtServiceImpl implements ILocaleMgmtService {

	@Override
	public List<String> getCountriesList() {
		Locale locale[] = Locale.getAvailableLocales();
		List<String> list = new LinkedList<>();
		for(Locale l:locale) {
			if(l!=null && l.getDisplayCountry().length()!=0) {
				list.add(l.getDisplayCountry());
			}
		}
		return list;
	}
	
	@Override
	public List<String> getLanguagesList() {
		Locale locale[] = Locale.getAvailableLocales();
		List<String> list = new LinkedList<>();
		for(Locale l:locale) {
			if(l!=null && l.getDisplayLanguage().length()!=0) {
				list.add(l.getDisplayLanguage());
			}
		}
		return list;
	}

}
