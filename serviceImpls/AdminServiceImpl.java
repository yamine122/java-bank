package com.bank.web.serviceImpls;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.bank.web.domains.AccountBean;
import com.bank.web.servieces.AdminService;

public class AdminServiceImpl implements AdminService{
	private AccountBean[] accounts;
	private int count;
	
	public AdminServiceImpl() {
		accounts = new AccountBean[10];
		count = 0;
	}
	@Override
	public void createAccount(int money) {
		// account , today , money
		AccountBean acc = new AccountBean();
		acc.setAccountNum(createAccountNum());
		acc.setMoney(money+"");
		acc.setToday(findDate());
		
		accounts[count] = acc;
		count++;
		
	}

	@Override
	public String createAccountNum() {
		String accountNum = "";
		Random r = new Random();
		for(int i = 0 ; i < 9; i++) {
			/* int t = r.nextInt(10);
			if(i == 4) {
				accountNum += "-";
			}else {
				accountNum += t;
			}*/
			accountNum += (i == 4)? "-" : r.nextInt(10) ;
		}
		return accountNum;
	}

	@Override
	public AccountBean[] findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean account = new AccountBean();
		for(int i = 0 ; i < count ; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				account = accounts[i];
				break;
			}
		}
		
		return account;
	}

	@Override
	public int countAccounts() {
		return count;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		for(int i = 0; i < count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				flag = true;
			}
		}
		
		return flag;
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		for(int i = 0 ; i < count ; i++) {
			if(param.getAccountNum().equals(accounts[i].getAccountNum())) {
				break;
			}
		}
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		for(int i = 0 ; i < count ; i++) {
			if(param.getAccountNum().equals(accounts[i].getAccountNum())) {
				break;
			}
		}
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		
	}

}
