package edu.java.contact.ver02;


import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

// MVC 아키텍쳐에서 View(UI)에 해당하는 클래스

public class ContactMain02 {
    
    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance(); // 컨트롤러 클래스

    public static void main(String[] args) {
        System.out.println("***** 연락처 프로그램 Version 0.2 *****");
        ContactMain02 app = new ContactMain02();
        
        boolean run = true;
        while(run) {
            int n = app.chooseMenu();
            MainMenu menu = MainMenu.getValue(n);
            if(n >=0 && n < 5) {
                switch(menu) {
                case QUIT:
                    run = false;
                    break;
                case SELECT_ALL:
                    app.selectAllContacts();
                    break;
                case SELECT_BY_INDEX:
                    app.selectContactByIndex();
                    break;
                case CREATE:
                    app.insertNewContact();
                    break;
                case UPDATE:
                    app.updateContactInfo();
                    break;
                }
            } else {
                System.out.println("0 ~ 4번의 메뉴에서 선택하세요.");
            }
            
        }
        System.out.println("***** 프로그램을 종료합니다. *****");
    }

    private void updateContactInfo() {
        System.out.println("--- 연락처 정보 업데이트 ---");
        System.out.print("업데이트할 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.print("수정할 이름>> ");
        String name = scanner.nextLine();
        System.out.print("수정할 전화번호>> ");
        String phone = scanner.nextLine();
        System.out.print("수정할 E-mail>> ");
        String email = scanner.nextLine();
        
        int result = dao.update(index, name, phone, email);
            if(result == 1) {
                System.out.println("연락처 정보 업데이트 성공");
            } else {
                System.out.println("연락처 정보 업데이트 실패");
            }
    }

    private void selectContactByIndex() {
        System.out.println("--- 인덱스로 저장된 연락처 검색 ---");
        System.out.print("인덱스 입력>> ");
        int index = Integer.parseInt(scanner.nextLine());
        Contact c = dao.read(index);
        System.out.println(c);
        System.out.println("-----------------------------------");
    }

    private void insertNewContact() {
        if(dao.getCount() == ContactDaoImpl.MAX_LENGTH) {
            System.out.println("연락처 정보를 저장할 메모리가 부족합니다.");
            return; //메서드 종료
        }
        System.out.print("이름 입력>> ");
        String name = scanner.nextLine();
        System.out.print("전화번호 입력>> ");
        String phone = scanner.nextLine();
        System.out.print("E-mail 입력>> ");
        String email = scanner.nextLine();
        
        Contact c = new Contact(name, phone, email);
        int result = dao.create(c);
        if(result == 1) {
            System.out.println("연락처 정보 생성/저장 성공");
        } else {
            System.out.println("연락처 정보 생성/저장 실패");
        }
    }

    private void selectAllContacts() {
        Contact[] contacts = dao.read();
        System.out.println("--- 연락처 전체 리스트 ---");
        for(Contact c : contacts) {
            System.out.println(c);
        }
        System.out.println("--------------------------");
    }

    private int chooseMenu() {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [0]종료");
        System.out.println("----------------------------------------------------------");
        System.out.print("메뉴 선택>> ");
        int n = Integer.parseInt(scanner.nextLine());
        return n;
        
    }

}
