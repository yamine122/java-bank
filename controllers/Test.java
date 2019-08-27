package com.bank.web.controllers;

import com.bank.web.servieces.AdminService;
import com.bank.web.serviceImpls.AdminServiceImpl;

public class Test {

	public static void main(String[] args) {
		AdminService service = new AdminServiceImpl();
		service.createAccountNum();
	}

}
