package com.example.bill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDetails {
    public BillDetails(Integer amount, Double gst, Integer deliveryCharge) {
		
	}
	private Integer amount;
    private Double gst;
    private Integer deliveryCharge;
}
