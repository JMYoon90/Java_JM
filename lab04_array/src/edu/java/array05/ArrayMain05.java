package edu.java.array05;

public class ArrayMain05 {

    public static void main(String[] args) {
        // 문자열 1차원 배열
        String[] bts = {"정국", "뷔", "RM", "지민", "슈가", "제이홉", "진"};
        String[] newJeans = {"민지", "하니", "다니엘", "해린", "혜인"};
        
        // 문자열 2차원 배열
        String[][] idols = {bts, newJeans}; // { {...}, {...} }
        
        // for문을 사용해서 idols 맴버들을 출력
        // for-each 문을 사용해서 idols 맴버들을 출력
        
        for(int i = 0; i < idols.length; i++) {
            for(int j = 0; j < idols[i].length; j++) {
                System.out.print(idols[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
        
        for(String[] idol : idols) {
            for(String i : idol) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}