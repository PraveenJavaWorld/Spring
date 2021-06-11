package com.nt.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class LocaleMgmtServiceImpl implements ILocaleMgmtService {

	@Override
	public List<String> getCountriesList() {
		Locale locale[] = Locale.getAvailableLocales();
		List<String> list = new ArrayList<>();
		for(Locale l:locale) {
			if(l!=null && l.getDisplayCountry().length()!=0) {
				list.add(l.getDisplayCountry());
				Collections.sort(list);
			}
		}
		return list;
	}
	
	@Override
	public List<String> getLanguagesList() {
		Locale locale[] = Locale.getAvailableLocales();
		List<String> list = new ArrayList<>();
		for(Locale l:locale) {
			if(l!=null && l.getDisplayLanguage().length()!=0) {
				list.add(l.getDisplayLanguage());
				Collections.sort(list);
			}
		}
		return list;
	}

}
