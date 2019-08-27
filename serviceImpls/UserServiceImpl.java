package com.bank.web.serviceImpls;

import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.servieces.UserService;

public class UserServiceImpl implements UserService{
	private CustomerBean[] customers;
	private EmployeeBean[] employees;
	private int custCount , empCount;
	
	public UserServiceImpl() {
		customers = new CustomerBean[10];
		employees = new EmployeeBean[10];
		custCount = 0;
		empCount = 0;
	}
	
	@Override
	public void join(CustomerBean param) {
		customers[custCount] = param;
		custCount++;
	}
	@Override
	public void register(EmployeeBean param) {
		employees[empCount] = param;
		empCount++;
	}

	@Override
	public CustomerBean[] findAllCustomers() {
		return customers;
	}

	@Override
	public EmployeeBean[] findAllAdmins() {
		return employees;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int count1 = 0 , count2 = 0 , count3 = 0;
		for(int i = 0 ; i < custCount ; i++) {
			if(name.equals(customers[i].getName())) {
				count1++;
				break;
			}
		}
		for(int i = 0 ; i < empCount ; i++) {
			if(name.equals(employees[i].getName())) {
				count2++;
			}
		}
		count3 = count1 + count2;
		MemberBean[] members = new MemberBean[count3];
		int j = 0;
		for(int i = 0 ; i < custCount; i++) {
			if(name.equals(customers[i].getName())) {
				members[j] = customers[i];
				j++;
				if(count1 == j) {
					break;
				}
			}
		}
		int k = 0;
		for(int i = 0 ; i < empCount; i++) {
			if(name.equals(employees[i].getName())) {
				members[j] = customers[i];
				k++;
				j++;
				if(count2 == k) {
					break;
				}
				break;
			}
		}
		return members;
}
	@Override
	public MemberBean findById(String id) {
		MemberBean customer = new MemberBean();
		for(int i = 0 ; i < custCount; i++) {
			if(id.equals(customers[i].getId())) {
				customer = customers[i];
				break;
			}
		}
		for(int i = 0 ; i < empCount; i++) {
			if(id.equals(employees[i].getId())) {
				customer = employees[i];
				break;
			}
		}
		return customer;
	}
	

	@Override
	public boolean login(MemberBean param) {
		/*boolean flag = false;
		MemberBean t = findById(param.getId());
		if(findById(param.getId()).getPw().equals(param.getPw())) {
			flag = true;
		}
		return*/
		return findById(param.getId()).getPw().equals(param.getPw())?true:false;
	}
	@Override
	public int countCustomers() {
		return custCount;
	}

	@Override
	public int countAdmins() {
		return empCount;
	}

	@Override
	public boolean existId(String id) {
		boolean flag = false;
		for(int i = 0 ; i < custCount; i++) {
			if(id.equals(customers[i].getId())) {
				flag = true;
				break;
			}
		}
		for(int i = 0 ; i < empCount; i++) {
			if(id.equals(employees[i].getId())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String[] pws = param.getPw().split(",");
		String oldPw = pws[0];
		String newPw = pws[1];
		param.setPw(oldPw);
		if(login(param)) {
			for(int i = 0; i < custCount ; i++) {
				if(id.equals(customers[i].getId())) {
					 customers[i].setPw(newPw);
					break;
					}
			}
			for(int i = 0; i < empCount ; i++) {
				if(id.equals(employees[i].getId())) {
					employees[i].setPw(newPw);
					break;
					}
			}
		}
		
	}

	@Override
	public void deleteMember(MemberBean param) {
		if(login(param)) {
			for(int i = 0; i < custCount ; i++) {
				if(customers[i].getId().equals(param.getId())) {
					//customers[i] = null;
					customers[i] = customers[custCount-1];
					custCount--;
					break;
				}
			}
			for(int i = 0; i < empCount ; i++) {

				if(employees[i].getId().equals(param.getId())) {
					//customers[i] = null;
					employees[i] = employees[empCount-1];
					empCount--;
					break;
				}
			}
		}
	}
}