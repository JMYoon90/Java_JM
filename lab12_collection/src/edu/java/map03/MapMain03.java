package edu.java.map03;

import java.util.HashMap;

public class MapMain03 {

    public static void main(String[] args) {
        // 단어 개수 세기(word counting)
        String sentence = "하늘 바다 땅 하늘 땅 사람 바다";
        
        // 문자열 sentence에 등장하는 단어를 key로 하고
        // 그 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고 출력.
        // 결과: {땅=2, 바다=1, 사람=1, 하늘=2}
        
        // 풀이
        
        HashMap<String, Integer> word = new HashMap<>();
        String[] words = sentence.split(" ");
        
        for(int i = 0; i < words.length; i++) {
            if(word.getOrDefault(words[i], 0) == 0 ) {
                word.put(words[i], 1);
            } else {
                word.put(words[i], word.get(words[i]) + 1);
            }
        }
        System.out.println(word);
        
        
        // 해설1
        
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for(String w : words) {
            Integer count = wordCounts.get(w);
            if (count == null) {
                wordCounts.put(w, 1);
            } else {
                wordCounts.put(w, count + 1);
            }
        }
        System.out.println(wordCounts);
        
        // 해설2
        
        HashMap<String, Integer> wordCounts2 = new HashMap<>();
        for (String w : words) {
            Integer count = wordCounts2.getOrDefault(w, 0);
            wordCounts2.put(w, count + 1);
        }
        System.out.println(wordCounts2);
    }
}
