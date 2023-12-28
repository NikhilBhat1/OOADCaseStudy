package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	private boolean chequeDeposit;

	public LoanAccount(String productCode, String productName, ArrayList<Services> productList, boolean chequeDeposit) {
		super(productCode, productName, productList);
		this.chequeDeposit = chequeDeposit;
	}



	public boolean getChequeDeposit() {
		return chequeDeposit;
	}

	public void setChequeDeposit(boolean chequeDeposit) {
		this.chequeDeposit = chequeDeposit;
	}

}
