package loophw;

import java.util.Random;

public class LoopHomework03 {

    public static void main(String[] args) {
        
        // Ex 4-3. 주사위 2개를 던졌을 때 나오는 눈을 (눈1,눈2) 형식으로 출력.
        // 눈1 + 눈2 == 5 이면 프로그램 실행 멈춤
        
        // 난수 생성 방법 1: Random 클래스의 메서드를 사용.
        int a=0, b=0, y=0;
        double x;
        Random random = new Random();
        // random.nextInt(int a): 0이상 a 미만의 정수 난수를 반환하는 함수.
        a = random.nextInt(10); // 0이상 10 미만의 정수 난수를 반환
        
        // random.nextInt(int a, int b) a이상 b 미만의 정수 난수를 반환하는 함수.
        a = random.nextInt(1, 5); // 1이상 5 미만의 정수 난수를 반환하는 함수.
        
        // random.nextDouble() : 0.0이상 1.0 미만의 실수 난수를 반환하는 함수.
        x = random.nextDouble(9); // 0.0이상 9.0 미만의 실수 난수를 반환하는 함수.
        System.out.println(x);
        
        // random.nextDouble(double a, double b): a 이상 b 미만의 double 타입 난수를 반환하는 함수.
        x = random.nextDouble(1.0, 2.0);
        System.out.println(x);
        
        // 난수 생성 방법 2: Math.random() 메서드를 사용.
        // Math.random(): 0.0 이상 1.0 미만의 double 타입 난수를 반환하는 함수.
        x = Math.random();
        System.out.println(x);
        
        //Math.random() 메서드를 사용해서 1부터 6까지(주사위 눈) 난수를 생성하려면:
        // 1 이상 7 미만의 실수에서 소숫점 이하를 버리고 정수 부분만 취함.
        y = (int) (6 * Math.random() + 1);
        System.out.println(y);
        
        
        
        System.out.println("----------");
        // 무한 루프(반복문)을 만드는 방법:
        // 1. for( ; ; ) {...}
        // 2. while (true) {...}
        
        while(a + b != 5) {
            a = random.nextInt(1, 7);
            b = random.nextInt(1, 7); 
            System.out.println("(" + a + ", " + b + ")");
        }
        System.out.println("----------");
        while (true) {
            int dice1 = random.nextInt(1, 7);
            int dice2 = random.nextInt(1, 7);
            System.out.println("(" + dice1 + ", " + dice2 + ")");
            if(dice1 + dice2 == 5) {
                break;
            }
        }
        
        
        
    }

}
