package com.bank.web.controllers;


import javax.swing.JOptionPane;

import com.bank.web.domains.*;
import com.bank.web.serviceImpls.UserServiceImpl;
import com.bank.web.servieces.UserService;

public class UserController {

	public static void main(String[] args) {
		CustomerBean customer = null;
		EmployeeBean employee = null;
	
		UserService service = new UserServiceImpl();
		String[] arr = null;
		String temp = "";
		
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료 1.고객회원가입 2.사원회원가입 3.회원의마이페이지 4.사원의 마이페이지"
												+ "5.이름찾기 6.아이디찾기 7.로그인 8.고객수 "
												+ "9.직원수 10.아이디존재여부 11.비밀번호변경 12.회원탈퇴")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료되었습니다");				
				return;
			case "1":
				arr = JOptionPane.showInputDialog("아이디, 비밀번호 , 이름 , 주민번호 입력해주세요").split(",");
				customer= new CustomerBean();
				customer.setId(arr[0]);
				customer.setPw(arr[1]);
				customer.setName(arr[2]);
				customer.setSsn(arr[3]);
				
				service.join(customer);
				break;
			case "2":
			
				arr = JOptionPane.showInputDialog("아이디, 비밀번호 , 이름 , 주민번호를 입력해주세요").split(",");
				employee = new EmployeeBean();
				employee.setId(arr[0]);
				employee.setPw(arr[1]);
				employee.setName(arr[2]);
				employee.setSsn(arr[3]);
				
				service.register(employee);
				
				break;				
				
			case "3":
				temp = "";
				CustomerBean[] customers = service.findAllCustomers();
				for(int i = 0; i < service.countCustomers(); i++) {
					temp += customers[i].toString(); 
				}
				JOptionPane.showMessageDialog(null, temp);
				
				break;
			case "4":
				temp = "";
				EmployeeBean[] employees = service.findAllAdmins();
				for(int i = 0; i < service.countAdmins(); i++) {
					temp += employees[i].toString();
				}
				JOptionPane.showMessageDialog(null, temp);
				break;
			case "5":
				temp = JOptionPane.showInputDialog("이름을 입력하세요");
				JOptionPane.showMessageDialog(null, service.findById(temp));				
				
				break;
			case "6":
				String searchId = JOptionPane.showInputDialog("아이디를 입력하세요");
				JOptionPane.showMessageDialog(null, service.findById(searchId));
				
				break;
			case "7":
				temp = JOptionPane.showInputDialog("아이디,비밀번호 입력하세요");
				arr = temp.split(",");
				MemberBean member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]);
				
				JOptionPane.showMessageDialog(null, service.login(member));
				
				
				break;
			case "8":
					service.countCustomers();
				break;
			case "9":
					service.countAdmins();
				break;
			case "10":
				searchId = JOptionPane.showInputDialog("아이디를 입력해주세요");
				JOptionPane.showMessageDialog(null, service.existId(searchId));
				
				
				break;
			case "11":
				temp = JOptionPane.showInputDialog("아이디 , 비밀번호 , 바꿀비밀번호를 입력하세요");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]+","+arr[2]);
				
				service.updatePass(member);
				
				break;
			case "12":
				temp = JOptionPane.showInputDialog("아이디,비밀번호 입력하세요");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]);
				
				service.deleteMember(member);
				
				break;
		
			default:
				break;
			}
		}
			
			
	}

}
