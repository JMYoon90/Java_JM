package loophw;

public class LoopHomework04 {

    public static void main(String[] args) {
        
        // Ex 4-4. 4x + 5y = 60 모든 해 구하기. 단 x, y는 10 이하의 자연수.
        
        int x, y;
        
        for(x=1; x<=10; x++) {
            for(y=1; y<=10; y++) {
                if(4*x + 5*y == 60) {
                    System.out.println("(" + x + "," + y + ")");
                }
            }
        }
    }
}
