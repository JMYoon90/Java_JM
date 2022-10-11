package edu.java.class06;

public class ClassMain06 {

    public static void main(String[] args) {
        Account acc = new Account(123456, 5000);
        System.out.println("초기 계좌 잔액 : " + acc.balance + " | 계좌번호(" + acc.accountNo + ")");    
        
        System.out.println("--------------------------");
        
        acc.deposit(500);
            System.out.println("입금 후 계좌 잔액: " + acc.balance);

            System.out.println("--------------------------");
            
        acc.withdraw(1000);
            System.out.println("출금 후 계좌 잔액: " + acc.balance);
            
            System.out.println("--------------------------");
            
            // 이체할 계좌 생성
            Account account2 = new Account(654321, 1000);
            
            // acc에서 account2으로 2500원 이체
            
        acc.transfer(account2, 2500);
            
        acc.printAccountInfo();
        account2.printAccountInfo();

        
    }

}
