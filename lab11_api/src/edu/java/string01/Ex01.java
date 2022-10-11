package edu.java.string01;

import java.util.Arrays;

public class Ex01 {

    public static void main(String[] args) {
        // String 클래스의 메서드들을 사용
        // ex-1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력.
        String ssn = "991231-1234567";
        char charssn = ssn.charAt(7);
        System.out.println("----- 1번 문제 -----");
        System.out.println("성별분류번호: " + charssn);
        System.out.println("--------------------\n");
        System.out.println("----- 2번 문제 -----");
        
        
        // ex-2. 아래의 문자열 배열에서 "홍길동"의 인덱스를 출력하세요.
        // 만약에 "홍길동"이 배열에 없는 경우 -1을 출력.
        String[] names = {"오쌤", "홍길동", "John", "Jane"};

        int index = -1;
        for(int i = 0; i < names.length; i++) {
            if(names[i].equals("홍길동")) {
                index = i;
                break;
            }
        }
        System.out.println(index);
        System.out.println("--------------------\n");
        System.out.println("----- 3번 문제 -----");
        
        
        // ex-3. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력
        String[] languages = {"Java", "SQL", "JavaScript", "Python"};
        
//        for(int i = 0; i < languages.length ; i++) {
//            if(languages[i].length() >= 5) {
//                System.out.println(languages[i]);
//            }
//        }
        for(String s : languages) {
            if(s.length() >= 5) {
                System.out.print(s + "   ");
            }
        }
        System.out.println();
        System.out.println("--------------------\n");
        System.out.println("----- 4번 문제 -----");
        
        
        // ex-4. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        String[] tests = {"TEST", "test", "TeSt", "tEsT", "테스트"};
//        String[] tests2 = new String[5];
//        for(int i = 0; i < tests.length ; i++ ) {
//            tests2[i] = tests[i].toLowerCase();
//            if(tests2[i].indexOf("est") != -1) {
//                System.out.println(tests[i]);
//            }
//        }
        for(String s : tests) {
            if(s.toLowerCase().contains("est")) {
                System.out.print(s + "   ");
            }
        }
        System.out.println("\n--------------------\n");
        System.out.println("----- 5번 문제 -----");
        
        
        // ex-5. 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 년/월/일 정보를
        // int 타입 변수에 저장하고 출력.
        String date = "2022-09-07";
//        int y = Integer.parseInt(date.substring(0,4));
//        int m = Integer.parseInt(date.substring(6,7));
//        int d = Integer.parseInt(date.substring(9,10));
//        System.out.printf("%d년%d월%d일",y,m,d);
        String[] array = date.split("-"); //{"2022", "09", "07"}
        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);
        System.out.printf("%d년%d월%d일",year,month,day);
    }
}
