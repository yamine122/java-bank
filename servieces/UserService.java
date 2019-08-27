package com.bank.web.servieces;
import com.bank.web.domains.*;

public interface UserService {

	public void join(CustomerBean param);
	public void register(EmployeeBean param);
	public CustomerBean[] findAllCustomers();
	public EmployeeBean[] findAllAdmins();
	public MemberBean[] findByName(String name); // 고객, 사원 공용메소드
	public MemberBean findById(String id); // 고객, 사원 공용메소드
	public boolean login(MemberBean param);
	public int countCustomers(); // 고객수
	public int countAdmins(); // 직원수
	public boolean existId(String id);
	public void updatePass(MemberBean param);
	public void deleteMember(MemberBean param);
	

}
