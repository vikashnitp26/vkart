package com.vkart.details;

import java.io.Serializable;
import java.util.List;

public class CartDetails implements Serializable {
	private static final long serialVersionUID = 2148379415619933775L;
	
	public List<ProductDetails> cartDetails;	
	public double totalprice;
	public double totaldeliverycharge;
	public double grandtotal;
	public CartDetails()
	{
		
	}
	public CartDetails(List<ProductDetails> productDetails, double totalprice, double totaldeliverycharge,
			double grandtotal) {
		super();
		this.cartDetails = productDetails;
		this.totalprice = totalprice;
		this.totaldeliverycharge = totaldeliverycharge;
		this.grandtotal = grandtotal;
	}
}
