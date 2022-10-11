package edu.java.class06;

import java.util.Scanner;

/**
 * 은행 계좌 정보 클래스.
 * 계좌번호, 잔액을 필드로 갖고, 입금, 출금, 이체, 정보 출력 기능을 메서드로 갖음.
 */
public class Account {
    // field
    int accountNo; // 계좌번호
    double balance; // 잔고
    double account; // 이체계좌
    // constructor - argument 2개를 갖는 생성자.
    public Account(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    /**
     * 입금(deposit)
     * 
     * @param amount 입금액
     * @return 입금 후 잔액을 리턴.
     */
    public double deposit(double amount) {
        return this.balance += amount;
    }
    
    
    /**
     * 출금(withdraw)
     * 
     * @param amount 출금액
     * @return 출금 후 잔액을 리턴.
     */
    public double withdraw(double amount) {
        return this.balance -= amount;
    }
    
    
    /**
     * 이체(transfer)
     * 
     * @param to 이체할 계좌 객체(Account 타입)
     * @param amount 이체할 금액
     * @return true(이체 성공).
     */
//    public double transfer(int accountNo, int withdraw) {
//
//        this.account += withdraw;
//        System.out.println("[" + accountNo + "] 계좌로 이체 성공" );
//        System.out.println("이체 계좌 잔액: " + account);
//        return this.balance -= withdraw;
        
        public boolean transfer(Account to, double amount) {
            // 이체: (1) 내 계좌 출금. (2) 상대 계좌 입금.
//            this.balance -= amount;
//            to.balance += amount;
            this.withdraw(amount);
            to.deposit(amount);
            return true;
    }
    
    
    /**
     * 계좌 정보 출력(printAccountInfo). 계좌 번호와 잔액을 출력.
     */
    
    public void printAccountInfo() {
        System.out.println("계좌 번호: " + accountNo);
        System.out.println("잔액: " + balance);
    }    
    
}