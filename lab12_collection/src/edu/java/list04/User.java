package edu.java.list04;

public class User {
    private String UserId;
    private String Password;
    
    // 생성자: (1) 기본생성자, (2) argument 2개를 갖는 생성자
    public User() {}
    public User(String userId, String password) {
        UserId = userId;
        Password = password;
    }
    // getters/setters
    public String getUserId() {
        return UserId;
    }
    public void setUserId(String userId) {
        UserId = userId;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    @Override
    public String toString() {
        return String.format("UserID: %s, Password: %s",
                UserId,Password);
        
    }

}
