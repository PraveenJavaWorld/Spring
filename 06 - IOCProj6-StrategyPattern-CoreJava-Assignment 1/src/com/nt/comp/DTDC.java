package com.nt.comp;

import java.time.LocalDate;

public final class DTDC implements ICourier {

	@Override
	public String deliver(int orderId) {
		
		return "DTDC will Deliver you order of id :: "+orderId;
	}

	@Override
	public void dispatchDate() {
		System.out.println("Dispatched on :: "+LocalDate.now());

	}

	@Override
	public void deliveryDate() {
		System.out.println("Order will be Delivered on :: "+LocalDate.now().plusDays(4));

	}

}
