package com.lopputyo.lopputyo.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lopputyo.lopputyo.service.StudentService;
public class Student implements Serializable {
    private String fname;
    private String lname;
    private int studentid;

    private static int count =0;

    public Student(String fname, String lname){
        this.fname=fname;
        this.lname=lname;
        int randomnum = (int)Math.floor(Math.random()*(999-111+1)+1);
        this.studentid=randomnum;
     
        
    }
    public Student(List <Student> students){
        
    }
    public List<Student> students= new ArrayList<>();

   
    

    
   

    public String getFname(){
        return this.fname;
    }
    public String getLname(){
        return this.lname;
    }
    public int getStudentid(){
        return this.studentid;
    }
    
    public void setFname(String fname){
        this.fname=fname;
    }
    public void setLname(String lname){
        this.lname=lname;
    }
   

}
