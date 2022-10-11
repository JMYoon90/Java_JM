package edu.java.file08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileMain08 {

    public static void main(String[] args) {
        // Student를 저장하는 ArrayList를 선언, 생성.
        // ArrayList에 Student 객체 5개를 저장.
        // ArrayList를 파일에 write.
        
        // 파일에서 ArrayList 객체를 read.
        // ArrayList의 원소들을 한 줄씩 출력.
        ArrayList<Student> stu = new ArrayList<>();
        
        for(int i = 0; i < 5; i++) {
            stu.add(new Student(i, "학생" + i, new Score(10 * i, 11 * i, 12 * i)));            
        }
        
        String fileName = "data/StudentsArray.dat";
        try (
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName));
                ObjectOutputStream oout = new ObjectOutputStream(out);
        ){
          oout.writeObject(stu);  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
                ObjectInputStream oin = new ObjectInputStream(in);
        ){
            
          ArrayList<Student> stulist = (ArrayList<Student>) oin.readObject();
          for(int i = 0; i < stulist.size();i++) {
              System.out.println(stulist.get(i));
          }
          
            
        } catch( Exception e) {
            e.printStackTrace();
        }
        
    }

}