package edu.java.loop01;

public class LoopMain01 {

    public static void main(String[] args) {
        // 반복문
        
        System.out.println("Java " + 0);
        System.out.println("Java " + 1);
        System.out.println("Java " + 2);
        System.out.println("Java " + 3);
        System.out.println("Java " + 4);
        
        //for문

        for( int i = 0 ; i < 5 ; i++ ) {
            System.out.println("Java " + i);
        }
        
        // 증가 연산자(++), 감소 연산자(--): 변수의 값을 1 증가/감소.
        
        //10부터 1까지 내림차순으로 출력
        
        for(int i = 10 ; i >= 1 ; i--) {
            System.out.println(i);
        }
        
        // 지역 변수(local variable) : 메서드 안에서 선언한 변수.
        // 지역 변수는 선언된 곳에서부터 변수가 속한 블록({...}) 안에서만 사용이 가능.
    }
    
}

    