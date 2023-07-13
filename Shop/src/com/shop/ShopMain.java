package com.shop;

import java.util.Scanner;

import com.shop.dao.CustomerDAO;
import com.shop.dao.OrderDAO;
import com.shop.dao.ProductDAO;
import com.shop.vo.CustomerVO;

public class ShopMain {

	public static void main(String[] args) {
		System.out.println("-----------------------------");
		System.out.println("쇼핑몰에 오신 것을 환영합니다.");
		System.out.println("----------------------------");
		
		
		Scanner sc = new Scanner(System.in);

		CustomerDAO customerDAO= CustomerDAO.getInstance();
		OrderDAO orderDAO = OrderDAO.getInstance();
		ProductDAO producDAO = ProductDAO.getInstance();
		
		while(true) {
			System.out.println("종료:0, 로그인:1, 회원가입: 2, 상품목록 : 3, 구매하기 : 4");
			
			int answer = sc.nextInt();
			if(answer==0) {
				break;
			}else if(answer==1) {
				System.out.println("아이디 입력");
				String custid = sc.next();
				
				
				CustomerVO vo = customerDAO.selectCustomer(custid);
				
		
				if(vo!=null) {
					
					System.out.println(vo.getName()+"님 어서오세요.");
					
					
					
				}else {
					System.out.println("일치하는 회원이 없습니다.");
					
				}
				
			}else if(answer ==2) {
				//회원가입
				CustomerVO vo = new CustomerVO();
				
				System.out.print("아이디 입력 : ");
				vo.setCustid(sc.next());
				
				System.out.print("이름입력 : ");
				vo.setName(sc.next());
				
				System.out.print("휴대폰 입력 : ");
				vo.setHp(sc.next());
				
				System.out.print("주소 입력: ");
				vo.setAddr(sc.next());
				
				int result = customerDAO.insertCustomer(vo);
				
				if(result>0) {
					System.out.println("회원가입을 축하합니다.");
				}else {
					System.out.println("회원 가입에 실패하였습니다.  다시 회원가입 하십시오.");
				}

			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		

		sc.close();
		System.out.println("안녕히 가세요~");
	}
}
