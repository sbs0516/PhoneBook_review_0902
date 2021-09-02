package codes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import codes.datas.UserData;

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
				addUserInfo();
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
	static void addUserInfo() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scanner.next();
		
		System.out.print("전화번호 : ");
		String phoneNum = scanner.next();
		
		System.out.print("출생년도 : ");
		int birthYear = scanner.nextInt();
		
		String content = String.format("%s,%s,%d", name, phoneNum, birthYear);
		
		userInfoDataToFile(content);
		
	}
	
	static void viewPhoneBook() {
		
		List<UserData> list = new ArrayList<>();
		
		userInfoFileToData(list);
		
		for( UserData user : list) {
			System.out.println(user);
		}
		
	}
	
	static void userInfoDataToFile(String content) {
		
		File myFile = new File("myPhoneBook02.txt");
		
		try {
			FileWriter fw = new FileWriter(myFile, true);
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.append(content);
			bw.newLine();
			
			bw.close();
			fw.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void userInfoFileToData(List<UserData> list) {
		
		File myFile = new File("myPhoneBook02.txt");
		
		try {
			FileReader fr = new FileReader(myFile);
			
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				
				String line = br.readLine();
				
				if(line == null) {
					break;
				}
				
				String[] userInfo = line.split(",");
				
				list.add(new UserData(userInfo[0], userInfo[1], Integer.parseInt(userInfo[2])));
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일의 내용에 문제가 있습니다.");
			e.printStackTrace();
		}
	}
}










