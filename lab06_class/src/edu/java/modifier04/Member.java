package edu.java.modifier04;

/*
 * field: 아이디, 비밀번호
 * constructor: argument 2개를 갖는 생성자.
 * method: 아이디 getter, 비밀번호 getter/ setter
 */


public class Member {

    private String id;
    private String password;
    
    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    public String getId() {
        return this.id;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
            this.password = password;
            System.out.println("비밀번호 변경이 완료되었습니다.");
        
    }
}
