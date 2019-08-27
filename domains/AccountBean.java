package com.bank.web.domains;
/**
 * 계좌 :  계좌번호 거래일 돈
 * 	accountNum today money
 */
public class AccountBean {
	private String today, money, accountNum;

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	@Override
	public String toString() {
		return "AccountBean [today=" + today + ", money=" + money + ", accountNum=" + accountNum + "]";
	}
	
}
