
package com.lopputyo.lopputyo.controller;


import org.springframework.beans.factory.annotation.Autowired;
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

   

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
   

    @PostMapping("/addstudent")
    public String addStudent(@RequestParam String fname,@RequestParam String lname ){

        studentService.addStudent(new Student(fname,lname));

        return"New student added";
    }



    @GetMapping("/courses")
    public List<Course> getCourse(){
        return studentService.getCourse();
    }

    @PostMapping("/coursestudents")
    public List<Student> getCourseStudents(@RequestParam String coursename){

        return studentService.getCourseStudents(coursename);
    }

    @PostMapping("/studentcourses")
    public List<Course> getStudentsCourses(@RequestParam int studentid){

        return studentService.getStudentsCourses(studentid);
    }

    @PostMapping("/newcourse")
    public String newCourse(@RequestParam String name,@RequestParam String teacher){

        studentService.newCourse(new Course(name,teacher,new ArrayList<>()));
       
        return "New course was made";
    }
    
    @PostMapping("/addtocourse")
    public void addtocourse(@RequestParam int studentid,@RequestParam String course){

       studentService.addToCourse(studentid,course);
       
    }       
    }


    

