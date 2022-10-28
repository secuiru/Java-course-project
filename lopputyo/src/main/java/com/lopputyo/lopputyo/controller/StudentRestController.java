
package com.lopputyo.lopputyo.controller;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.strategy.StdInstantiatorStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lopputyo.lopputyo.data.*;
import com.lopputyo.lopputyo.service.StudentService;
import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public  String loadStudents(){
        return "hello";
}

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/readstudents")
    public List<Student> readStudents(){
        return studentService.readStudents();
        
    }

    @PostMapping("/addstudent")
    public String addStudent(@RequestParam String fname,@RequestParam String lname ){

        studentService.addStudent(new Student(fname,lname));
       

        return"";
    }



    @GetMapping("/courses")
    public List<Course> getCourse(){
        return studentService.getCourse();
    }
    @GetMapping("/coursestudents")
    public List<Integer> getCourseStudents(){
        return studentService.getCourseStudents();
    }

    @PostMapping("/newcourse")
    public String newCourse(@RequestParam String name,@RequestParam String teacher){

        studentService.newCourse(new Course(name,teacher,new ArrayList<>()));
       

        return "Course";
    }
    
    @PostMapping("/addtocourse")
    public void addtocourse(@RequestParam int studentid,@RequestParam String course){
       studentService.addToCourse(studentid,course);
       
        
    }       
    }


    

