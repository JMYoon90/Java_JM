package edu.java.contact.ver03;

import java.util.List;
import java.util.Scanner;

import edu.java.contact.menu.MainMenu;
import edu.java.contact.ver02.Contact;

public class ContactMain03 {
    
    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();
    

    public static void main(String[] args) {
        System.out.println("***** 연락처 프로그램 Version 0.3 *****");
        // static이 아닌 메서드들을 호출하기 위해 메인 객체 생성
        ContactMain03 app = new ContactMain03(); 
        
        boolean run = true;
        while(run) {
                int n = app.chooseMenu();
                MainMenu menu = MainMenu.getValue(n);
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
                case DELETE:
                    app.deleteContact();
                default:
                    System.out.println("지원하지 않는 메뉴입니다. 다시 선택하세요.");
                }
        }
        System.out.println("***** 프로그램을 종료합니다. *****");
    }
    
    private void deleteContact() {
        System.out.println("--- 연락처 정보 삭제 ---");
        System.out.print("삭제할 연락처 인덱스>> ");
        int index = inputNumber();
        int result = dao.delete(index);
        if(result == 1) {
            System.out.println("연락처 정보 삭제 성공");
        } else {
            System.out.println("연락처 정보 삭제 실패");
        }
        
    }

    private void updateContactInfo() {
            System.out.println("--- 연락처 정보 업데이트 ---");
            System.out.print("업데이트할 인덱스>> ");
            int index = inputNumber();
            if(!dao.isValidindex(index)) {
                System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
                return;
            }
            
            System.out.print("수정할 이름>> ");
            String name = scanner.nextLine();
            System.out.print("수정할 전화번호>> ");
            String phone = scanner.nextLine();
            System.out.print("수정할 E-mail>> ");
            String email = scanner.nextLine();
            
            Contact c = new Contact(name, phone, email);
            int result = dao.update(index, c);
            
            if(result == 1) {
                System.out.println("연락처 정보 업데이트 성공");
            } else {
                System.out.println("연락처 정보 업데이트 실패");
            }
    }

    private void insertNewContact() {
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

    private void selectContactByIndex() {
        try {
            System.out.println("--- 인덱스로 저장된 연락처 검색 ---");
            System.out.print("인덱스 입력>> ");
            int index = inputNumber();
            
            Contact c = dao.read(index);
            System.out.println(c);
            System.out.println("-----------------------------------"); 
        } catch(IndexOutOfBoundsException e) {
            System.out.println("해당 인덱스에는 자료가 없습니다.");
        }

    }

    private void selectAllContacts() {
        List<Contact> contacts = dao.read();
        System.out.println("--- 연락처 전체 리스트 ---");
        for (Contact c : contacts) {
            System.out.println(c);
        }
        System.out.println("--------------------------");

    }

    private int chooseMenu() {
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [5] 삭제 [0]종료");
        System.out.println("----------------------------------------------------------------");
        System.out.print("메뉴 선택>> ");
        return inputNumber();
    }
    private int inputNumber() {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("정수를 입력하세요>> ");
            }
        }
    }
    

}
