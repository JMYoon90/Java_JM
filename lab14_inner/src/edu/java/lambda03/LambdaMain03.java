package edu.java.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMain03 {

    public static void main(String[] args) {
        // 정수들을 저장하는 리스트
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(numbers);

        // numbers에서 짝수들만 선택해서 저장한 리스트.
        List<Integer> evens = new ArrayList<>();
        for (Integer x : numbers) { // 리스트의 모든 원소를 차례로 반복하면서
            if(x % 2 == 0) { // 짝수들은 필터링
                evens.add(x);
            }
        }
        System.out.println(evens);
        
        List<Integer> evens2 = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens2);
        
        
        // numbers에서 홀수들만 선택해서 저장한 리스트.
        List<Integer> odds = new ArrayList<>();
        for (Integer x : numbers) {
            if (x % 2 == 1) {
                odds.add(x);
            }
        }
        System.out.println(odds);
        
        List<Integer> odds2 = numbers.stream()
                .filter(x -> x % 2 == 1)
                .collect(Collectors.toList());
        
        System.out.println(odds2);
        
        // numbers에서 짝수들의 제곱을 저장하는 리스트.
        
        List<Integer> odds3 = new ArrayList<>();
        for (Integer x : numbers) {
            if(x % 2 == 0) {
                odds3.add(x * x);
            }
        }
        System.out.println(odds3);
        
        List<Integer> result = new ArrayList<>();
        result = numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(result);
        
        List<String> langs = Arrays.asList("Java", "SQL", "HTML", "JavaScript", "Python");
        System.out.println(langs);
        
        // langs에서 5글자 이상의 문자열들을 찾고, 모두 소문자로 변환한 리스트.
        
        List<String> result1 = new ArrayList<>();
        for(String s : langs) {
            if(s.length() >= 5 ) {
                result1.add(s.toLowerCase());
            }
        }
        System.out.println(result1);
        
        
        List<String> result2 = new ArrayList<>();
        result2 = langs.stream()
                .filter(s -> s.length() >= 5)
                .map(String::toLowerCase) // == (s -> s.toLowerCase())
                .collect(Collectors.toList());
        
        System.out.println(result2);
}
    

}
