package com.bank.web.domains;

public class CustomerBean extends MemberBean{
	private String credit;

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "고객정보  [id=" + getId()+ ", pw=" + getPw() + ", name=" + getName() + ", ssn=" + getSsn() + ", credit = " + credit+"]";
	}
	
}
