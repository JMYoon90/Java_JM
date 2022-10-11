package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {

    public static void main(String[] args) {
        // 문자열들을 원소로 갖는 리스트를 생성하고 초기화.
        List<String> languages = Arrays.asList("Java", "SQL", "HTML"
                , "CSS","JavaScript", "Servlet", "JSP", "Spring", "Python");
        System.out.println(languages);
        
        // 리스트 languages에서 5글자 이상인 문자열들만 저장하는 리스트를 생성, 출력.
        ArrayList<String> fl = new ArrayList<>();
        System.out.println("5글자 이상인 문자열");
        for(String s : languages) {
            if(s.length() >= 5) {
                fl.add(s);
            }
        }
        System.out.println(fl);
        System.out.println("-------------------");
        
        // Iterator<E> 사용
        List<String> longwords = new ArrayList<>(); // 다형성
        Iterator<String> itr = languages.iterator();
        while (itr.hasNext()) {
            String s = itr.next();
            if(s.length() >= 5) {
                longwords.add(s);
            }
        }
        System.out.println(longwords);
        System.out.println("-------------------");
        
        // 리스트 languages의 원소들의 글자수를 저장하는 리스트를 만들고 출력.
        ArrayList<Integer> textlength = new ArrayList<>();
        for(String s : languages) {
            textlength.add(s.length());
        }
        System.out.println("languages 원소들의 글자수");
        System.out.println(textlength);
        System.out.println("-------------------------");
        
        // 정수(1, 2)들을 저장하는 리스트를 만들고 초기화.
        List<Integer> genderCodes = Arrays.asList(1, 1, 2, 2, 1, 2, 2);
        
        // 리스트 genderCodes의 원소가 1이면 "Male", 2이면 "Female"을 저장하는 리스트를 만들고 출력.
        ArrayList<String> gender = new ArrayList<>();
        for(Integer i = 0; i < genderCodes.size(); i++) {
//            if( genderCodes.get(i) == 1 ) {
//                gender.add("Male");
//            } else { 
//                gender.add("Female");
//            }
            gender.add(genderCodes.get(i) == 1 ? "Male" : "Female");
        }
        System.out.println("gender 리스트");
        System.out.println(gender);
        System.out.println("-------------");
    }

}
