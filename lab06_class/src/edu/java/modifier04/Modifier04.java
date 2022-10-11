package edu.java.modifier04;

public class Modifier04 {

    public static void main(String[] args) {
        Member m = new Member("재만", "itwill_java134");
        
        System.out.println("Member ID: " + m.getId());
        
        System.out.println("Member p.w.: " + m.getPassword());
        
        System.out.println("--------------------------------");
        
        m.setPassword("123456");
        
        System.out.println("--------------------------------");

        System.out.println("Member p.w.: " + m.getPassword());

    }

}
