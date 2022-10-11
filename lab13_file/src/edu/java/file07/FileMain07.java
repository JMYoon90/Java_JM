package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.java.file06.Product;

public class FileMain07 {

    public static void main(String[] args) {
        // edu.java.file06.Product 타입의 객체를 1,000,000개를 생성하고 arrayList에 저장.
        // ArrayList의 내용을 product_list.dat 파일에 write - 시간 측정.
        // product_list.dat 파일에서 데이터를 읽어서 ArrayList 타입으로 변환 - 시간 측정.
        
        ArrayList<Product> products = new ArrayList<>();
        
        
        for(int i = 0; i < 1000000; i++) {
            products.add(new Product(i, "상품 - " + i, 1000000 + i));
        }
        System.out.println(products.size());
        
        String fileName = "data/product_list.dat";
        try( // Try-with-resource 에서는 Stream과 같이 자동으로 close가 되는 변수들만 선언가능.
                BufferedOutputStream out = new BufferedOutputStream (new FileOutputStream(fileName));
                ObjectOutputStream oout = new ObjectOutputStream(out);
                ) {
            long startTime = System.currentTimeMillis();
            oout.writeObject(products);
            
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("파일 복사 시간 : " + elapsedTime + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try(
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
                ObjectInputStream oin = new ObjectInputStream(in);
        ) {
            long startTime = System.currentTimeMillis();
            
            ArrayList<Product> list = (ArrayList<Product>) oin.readObject();
            System.out.println(list.size());
            
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("파일 읽어오는 시간 : " + elapsedTime + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
