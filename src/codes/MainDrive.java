package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
		printMenu();
		
	}

	static void printMenu() {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("===== 전화번호부 =====");
			System.out.println("1. 전화번호 추가 등록");
			System.out.println("2. 전화번호 목록 조회");
			System.out.println("0. 프로그램 종료");
			System.out.println("===================");
			System.out.print("메뉴 입력 : ");
			
			int inputNum = scanner.nextInt();
			
			if(inputNum == 0) {
				break;
			} else if(inputNum == 1) {
				addPhoneNum();
			} else if(inputNum == 2) {
				viewPhoneBook();
			} else {
				System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
				System.out.println();
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	static void addPhoneNum() {
		
	}
	static void viewPhoneBook() {
		
	}
}










