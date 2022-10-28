package com.lopputyo.lopputyo.data;

import java.util.List;

public class Course {

    private String name;
    private String teacher;
    private List <Integer> coursestudents;



    public Course(String name, String teacher, List<Integer> coursestudents){
        this.name =name;
        this.teacher=teacher;
        this.coursestudents=coursestudents;
        
    }

     

    
    public List<Integer> getCoursestudents() {
        return this.coursestudents;
    }

    public void setCoursestudents(List<Integer> coursestudents) {
        this.coursestudents = coursestudents;
    }
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

 
}