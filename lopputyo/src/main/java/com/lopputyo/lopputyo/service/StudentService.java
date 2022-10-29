package com.lopputyo.lopputyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lopputyo.lopputyo.data.Student;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.lopputyo.lopputyo.data.Course;





@Service
public class StudentService{

    @Autowired
   
    StudentFileService studentFileService;
   
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    //private List<Integer> courseStudents = new ArrayList<>();

    public StudentService(){

    }

 
    public void addStudent(Student student){
        students.add(student);
        studentFileService.writeStudent(students);
    }

    public List<Student>getStudents(){
        try {
            students=studentFileService.readStudent();
           
          
      }catch(NullPointerException e){
       System.out.println(e);
   }
   catch(IOException e){
       System.out.println(e);
   }
   catch(ClassNotFoundException e){
       System.out.println(e);
   }
     return new ArrayList<>(students);
    }







    public List<Course> getCourse(){
        try {
            courses=studentFileService.readCourse();
          
      }catch(NullPointerException e){
       System.out.println(e);
   }
   catch(IOException e){
       System.out.println(e);
   }
   catch(ClassNotFoundException e){
       System.out.println(e);
   }
        return new ArrayList<>(courses);
    }

    public void newCourse(Course course){
        
        courses.add(course);
        studentFileService.writeCourse(courses);
    }

    public void addToCourse(int studentid,String courseName){   //Add studentid to given course
       
        for (Course course2: courses) {
            
        if(course2.getName().equals(courseName)){
           
            System.out.println(courseName);
           List <Integer> courseStudents= course2.getCoursestudents();
        for (Student stu : students) {
            if(studentid==stu.getStudentid())
               courseStudents.add(studentid);
               System.out.println(studentid);
               course2.setCoursestudents(courseStudents);
               studentFileService.writeCourse(courses);
                
            }
        }
    
    }
    
    }
    
    public List<Integer>getCourseStudents(String coursename){
        List<Integer> courseStudents = new ArrayList<>();
            for (Course course : courses) {
                if(course.getName().equals(coursename)){
                courseStudents =course.getCoursestudents();
                for (Integer integer : courseStudents) {
                    for(Student student : students) {
                        if(integer==student.getStudentid()){
                            System.out.println(student.getFname());
                            System.out.println(student.getLname());
                            System.out.println(student.getStudentid());
                        }
                    }
                
               }
                }
            }
       
        return new ArrayList<>(courseStudents);
       }

 
    



    

}