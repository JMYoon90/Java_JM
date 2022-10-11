package edu.java.contact.ver01;

import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

public class ContactMain01 {
    // 상수
    private static final int MAX_LENGTH = 3; // 저장할 수 있는 연락처의 최대 개수(배열 길이).
    
    
    
    //field
    private Scanner scanner = new Scanner(System.in); // 입력 도구
    private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처들의 배열
    private int count = 0; // 배열에 저장된 연락처의 개수. 새 연락처라 추가될 때마다 증가됨.
    
    public static void main(String[] args) {
        System.out.println("***** 연락처 프로그램 Version 0.1 *****");
        
        // static이 아닌 메서드들을 호출하기 위해서 객체를 생성할 필요가 있음.
        ContactMain01 app = new ContactMain01();
        
        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        while(run) {
            // 메인메뉴 보여주기
            app.showMainMenu();
            // 메뉴 입력
            int n = Integer.parseInt(app.scanner.nextLine());
            MainMenu menu = MainMenu.getValue(n);
            // switch-case
            switch (menu) {
            case QUIT: // 종료
                run = false;
                break;
            case SELECT_ALL: // 전체리스트 출력
                app.selecAllContacts();
                break;
            case SELECT_BY_INDEX: // 인덱스 검색
                app.selectContactByIndex();
                break;
            case CREATE: // 새 연락처 추가
                app.insertNewContact();
                break;
            case UPDATE: // 연락처 정보 수정
                app.updateContact();
                break;
            default:
                System.out.println("지원하지 않는 메뉴입니다. 다시 선택하세요.");
                    
            }
        
        }
        
        System.out.println("***** 프로그램 종료 *****");

    } // end main
    
    private void updateContact() {
        // 수정할 인덱스 입력
        System.out.print("수정할 연락처 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        if(index >= MAX_LENGTH || index < 0) {
            System.out.println("해당 인덱스 값은 존재할 수 없습니다(저장 범위 초과.)");
        } else {
            if(index < count) {
             // 수정 전 연락처 정보 출력
                System.out.print("수정 전>>> ");
                contacts[index].printContact();
                // 수정할 이름/전화번호/이메일 주소를 입력
                System.out.print("수정할 이름>> ");
                String name = scanner.nextLine();
                System.out.print("수정할 전화번호>> ");
                String phone = scanner.nextLine();
                System.out.print("수정할 이메일>> ");
                String email = scanner.nextLine();
                // 연락처 정보 업데이트
                contacts[index].setName(name);
                contacts[index].setPhone(phone);
                contacts[index].setEmail(email);
                
                // 수정 후 연락처 정보 출력
                System.out.println("수정 후>>> ");
                contacts[index].printContact();
            } else {
                System.out.println("해당 인덱스 값은 존재할 수 없습니다(인덱스 값이 없음.)");
            }
        }
        
    }

    private void selectContactByIndex() {
        // 검색할 인덱스 입력
        System.out.print("검색할 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        if(index >= MAX_LENGTH) {
            System.out.println("해당 인덱스 값은 존재할 수 없습니다(최대 저장값 초과.)");
        } else { 
            if( index < count && index >= 0 ) {
             // 해당 인덱스의 연락처 정보를 출력
                contacts[index].printContact();
            } else {
                System.out.println("해당 인덱스 값은 존재할 수 없습니다(인덱스 값이 없음.)");
            }
        }
        
    }

    private void insertNewContact() {
         
        if(count < MAX_LENGTH) {
         // 이름, 전화번호, 이메일 입력
            System.out.print("이름 입력 >> ");
            String name = scanner.nextLine();
            System.out.print("전화번호 입력 >> ");
            String phone = scanner.nextLine();
            System.out.print("E-mail 입력 >> ");
            String email = scanner.nextLine();
            
            // Contact 객체 생성
            Contact c = new Contact(name, phone, email);
            
            // 배열에 추가
            contacts[count] = c;
            count++; // 배열에 저장된 연락처 개수를 1 증가. 
        } else {
            System.out.println("더 이상 입력 할 수 없습니다.");
        }
        
    }
    
    private void selecAllContacts() {
        // 배열 contacts에 저장된 Contact 객체들을 출력.
        System.out.println("--- 연락처 전체 리스트 ---");
        for(int i = 0; i < count;i++) {
            // 배열의 길이만큼 반복하는 것이 아니라 배열에 실제로 저장된 연락처 개수만큼만 반복함.
            contacts[i].printContact();
        }
        System.out.println("--------------------------");
    }
    
    private void showMainMenu() {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [0]종료");
        System.out.println("----------------------------------------------------------");
        System.out.print("메뉴 선택> ");
    }

} // end class
