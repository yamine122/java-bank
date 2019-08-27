package com.bank.web.domains;
/**
 * 회원 : 아이디 비번 이름 주민번호
 *		 id pw name ssn
 */
public class MemberBean {
	private String id , pw , name , ssn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "회원정보 [id=" + id + ", pw=" + pw + ", name=" + name + ", ssn=" + ssn + "]";
	}

	
}
