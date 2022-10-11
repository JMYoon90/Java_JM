package edu.java.list02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ListMain02 {

    public static void main(String[] args) {
        // 1. 정수를 저장하는 LinkedList 변수(numbers) 선언, 객체 생성.
        LinkedList<Integer> numbers = new LinkedList<>();
        
        // 2. 리스트에 [0, 100) (0이상, 100미만) 범위의 정수 난수 20개를 저장.
        Random random = new Random();
        for(int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(0, 100));
        }
        
        // 3. 난수가 저장된 리스트(numbers)를 출력.
        System.out.println("numbers 리스트 출력값");
        System.out.print(numbers + ", ");
        System.out.println("");
        
        // 4. 홀수들만 저장하는 LinkedList 변수(odds) 선언, 객체 생성.
        LinkedList<Integer> odds = new LinkedList<>();

        // 5. 난수들이 저장된 리스트(numbers)에서 홀수들만 리스트 odds에 저장.
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) % 2 == 1) {
                odds.add(numbers.get(i));
            }
        }
        
        // 6. 리스트 odds를 출력.
        System.out.println();
        System.out.println("odds 리스트 출력값");
        System.out.print(odds + ", ");
        
        // 7. 짝수 제곱들을 저장하는 LinkedList 변수(evenSquares) 선언, 객체 생성.
        LinkedList<Integer> evenSquares = new LinkedList<>(); 
        
        // 8. 난수들이 저장된 리스트 numbers에서 짝수들을 찾아서 그 제곱을 evenSquares에 저장.
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) % 2 == 0) {
                evenSquares.add(numbers.get(i)*numbers.get(i));
            }
        }
        
        
        // 9. 리스트 evenSquares를 출력.
        System.out.println();
        System.out.println();
        System.out.println("evenSquares 리스트 출력값");
        System.out.print(evenSquares + ", ");
        System.out.println();
        
        // Iterator<E>
        Iterator<Integer> itr = evenSquares.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        
        // --
        LinkedList<String> evenSquares2 = new LinkedList<>();
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) % 2 == 0) {
                int a = numbers.get(i)*numbers.get(i);
                int b = numbers.get(i);
                String s = b + "의 제곱의 값: " + a ;
                evenSquares2.add(s);
            }
        }
        System.out.println("\n");
        System.out.println("evenSquares2 리스트 출력값");
        for(String z : evenSquares2) {
            System.out.println(z);
        }
        
        

        
    }

}
