package com.example.bill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
	private String foodName;
    private Integer quantity;
}
