package com.bank.web.servieces;

import com.bank.web.domains.AccountBean;
public interface AdminService {
	
	public void createAccount(int money);
	
	public String createAccountNum();
	
	//계좌번호 생성
	public AccountBean[] findAll();
	
	public AccountBean findByAccountNum(String accountNum);
	
	public int countAccounts();
	
	public boolean existAccountNum(String accountNum);
	
	public String findDate();//오늘 날짜, 현재시간(분까지) 반환
	
	public void depositMoney(AccountBean param);//입금
	
	public void withdrawMoney(AccountBean param);//출금
	
	public void deleteAccountNum(String accountNum);
}
