package edu.java.set03;

import java.util.HashSet;
import java.util.Random;

import javax.print.attribute.standard.NumberUpSupported;

public class SetMain03 {

    public static void main(String[] args) {
        // HashSet<E> 사용
        // [0, 10) 범위의 정수 난수 5개를 저장.
        // Set의 내용을 출력.
        HashSet<Integer> rs = new HashSet<>();
        Random random = new Random();
        
        while(rs.size() != 5) {
            rs.add(random.nextInt(0,10));
            }
        System.out.println(rs);
        
//        while(true) {
//            rs.add(random.nextInt(10));
//            System.out.println(rs); // 경과를 보기위해서 while 문 안에서 출력
//            
//            if(rs.size() == 5) {
//                break;
//            }
//        }
    }

}
