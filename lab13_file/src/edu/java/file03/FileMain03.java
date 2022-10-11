package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMain03 {

    public static void main(String[] args) {
        // data/ratings.data 파일을 읽고 ratings_copy.data 파일에 복사
        // read(), write(int b)를 사용했을 때
        // read(byte[] b), write(byte[] b, int off, int len)를 사용했을 때
        // 복사 시간의 차이를 비교.
        
        FileInputStream in = null;
        FileOutputStream out = null;
        
        // read() 연산
        
        try {
            in = new FileInputStream("data/ratings.dat");
            out = new FileOutputStream("data/ratings_copy.dat");
            
            long startTime = System.currentTimeMillis();
            
            while (true) {
                int read = in.read();
                if(read == -1) {
                    break;
                }
                out.write(read);
            }
            
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("read() 파일 복사 시간 : " + elapsedTime + "ms");
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        // read(byte[]) 연산
        
        try {
            in = new FileInputStream("data/ratings.dat");
            out = new FileOutputStream("data/ratings_copy2.dat");
            
            long startTime2 = System.currentTimeMillis();
            
            while (true) {
                byte[] buffer = new byte[10000];
                int result = in.read(buffer);
                if(result == -1) {
                    break;
                }
                out.write(buffer, 0, result);
            }
            
            long endTime2 = System.currentTimeMillis();
            long elapsedTime2 = endTime2 - startTime2;
            System.out.println("read(byte[] b) 파일 복사 시간 : " + elapsedTime2 + "ms");
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
