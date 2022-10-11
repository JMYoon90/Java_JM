package loophw;

public class LoopHomework06 {

    public static void main(String[] args) {
        for(int n=1; n<10000; n*=11) {
            if(n<10) {
                System.out.println("   *");
            }else if(n<100) {
                System.out.println("  **");
            }else if(n<1000) {
                System.out.println(" ***");
            }else {
                System.out.println("****");
            }
        }

    }

}
