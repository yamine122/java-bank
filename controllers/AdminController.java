package com.bank.web.controllers;

import javax.swing.JOptionPane;

import com.bank.web.domains.AccountBean;
import com.bank.web.serviceImpls.AdminServiceImpl;
import com.bank.web.servieces.AdminService;
public class AdminController {

	public static void main(String[] args) {
		AdminService service = new AdminServiceImpl();
		int money;
		String temp = "";
		
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료 1.계좌개설 2.고객정보 3.계좌번호찾기 4.계좌수 5.계좌번호중복확인 6.거래일자 7.입급 8.출금 9.계좌삭제")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				
				return;
			case "1":
				money = Integer.parseInt(JOptionPane.showInputDialog("입금액"));
				
				service.createAccount(money);
				break;
				
				case "2":
					AccountBean[] accounts = service.findAll();
					for(int i = 0 ; i <service.countAccounts(); i++) {
						temp += accounts[i].toString();
					}
					JOptionPane.showMessageDialog(null, temp);
					
				break;
			case "3":
					temp = JOptionPane.showInputDialog("계좌번호를 입력하세요");
					JOptionPane.showMessageDialog(null, service.findByAccountNum(temp));
				break;
			case "4":
					JOptionPane.showMessageDialog(null, service.countAccounts());
				
				break;
			case "5":
					 String searchNum = JOptionPane.showInputDialog("계좌번호를 입력해주세요");
					
					 JOptionPane.showMessageDialog(null, service.existAccountNum(searchNum));
					
				break;
			case "6":
					JOptionPane.showMessageDialog(null, service.findDate());
				
				break;
				
			case "7":
				
				break;
			case "8":
				
				break;
			case "9":
				
				break;
			case "10":
				
				break;
			default:
				break;
			}
		}
		
		
		
		

	}

}
