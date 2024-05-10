package com.example.bill;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillResponse {
	  private List<Food> OrderedFoods;
	    private BillDetails billDetails;
	    private Double totalPrice;
}

