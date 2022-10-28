package com.lopputyo.lopputyo.service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Service;


import com.lopputyo.lopputyo.data.Student;
@Service
public class StudentFileService  {

    public void writeStudent(List <Student> students){
      
        try{
            
             FileOutputStream f = new FileOutputStream(new File("C:\\temp\\students.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
           
             o.writeObject(students);
           
        
        o.close();
        f.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
       
       
    }
    public List<Student> readStudent() throws IOException, FileNotFoundException, ClassNotFoundException {
       
        int count=0;
        List<Student> students = new ArrayList<>();
      
        try {
            
            
            FileInputStream fi = new FileInputStream(new File("C:\\temp\\students.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
           
               List <Student> studentObject = null;
                
                try{
                    studentObject = (List<Student>) oi.readObject();
                    

                }catch(ClassNotFoundException e){
                    System.out.println(e);
                }catch(EOFException e){
                    System.out.println(e);
                }
                if(studentObject != null){
                    for (Student student : studentObject) {
                        students.add(student);
                System.out.println(student.getFname());
                System.out.println(student.getLname());
                System.out.println(student.getStudentid());
                 count++;
                System.out.println("count= "+count);
                    }
                
                }
 
                else
               
            fi.close();
            oi.close();
         
        } catch (Exception e) {
            System.out.println(e);

 
    }
   
    return students;
}


}