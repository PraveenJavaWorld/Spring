package com.nt.editor;

import java.beans.PropertyEditorSupport;

import com.nt.beans.InterestAmountDetails;

public class InterestAmountDetailsEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String values[] = text.split(",");
		float pAmt = Float.parseFloat(values[0]);
		float rate = Float.parseFloat(values[1]);
		float time = Float.parseFloat(values[2]);
		//create InterestAmountDetails obj
		InterestAmountDetails amt = new InterestAmountDetails();
		amt.setPAmt(pAmt);
		amt.setRoi(rate);
		amt.setTime(time);
		//set object as the value to bean property
		setValue(amt);
	}

}//class
