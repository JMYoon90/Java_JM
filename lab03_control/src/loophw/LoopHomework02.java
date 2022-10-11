package loophw;

public class LoopHomework02 {

    public static void main(String[] args) {
        // 1부터 10까지 자연수들의 합 : sum = 1 + 2 + 3 + ... + 9 + 10
        
        int n,sum = 0;
        for (n = 1; n <= 10; n++){
            System.out.println(sum += n);
        }
        
        System.out.println("-----");
        
        // Ex 4-2.
        
        sum = 0;
        for (n = 3; n <= 100; n += 3) {
            sum += n;
        }
        System.out.println("100이하의 자연수 중 3의 배수들의 합 : " + sum);
        
        // for, if문을 사용한 코드
        
        sum = 0;
        for (n = 1; n <= 100; n++) {
            if(n % 3 == 0) {
                sum += n;
            }
        }            
        System.out.println("100이하의 자연수 중 3의 배수들의 합 : " + sum);
        
        // while, if문을 사용한 코드
        
        sum = 0;
        n = 1;
        while (n<=100) {
            if(n % 3 == 0) {
               sum += n;
            }
            n++;
        }
        System.out.println("100이하의 자연수 중 3의 배수들의 합 : " + sum);
    }

}
