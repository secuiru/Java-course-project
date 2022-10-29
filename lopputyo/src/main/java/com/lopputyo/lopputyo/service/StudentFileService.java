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

import com.lopputyo.lopputyo.data.Course;
import com.lopputyo.lopputyo.data.Student;

@Service
public class StudentFileService {


    //Write students list to file
    public void writeStudent(List<Student> students) {
        try {

            FileOutputStream f = new FileOutputStream(new File("C:\\temp\\students.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(students);

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    //Read students list from file 
    public List<Student> readStudent() throws IOException, FileNotFoundException, ClassNotFoundException {

        List<Student> students = new ArrayList<>();

        try {

            FileInputStream fi = new FileInputStream(new File("C:\\temp\\students.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            List<Student> studentObject = null;

            try {
                studentObject = (List<Student>) oi.readObject();

            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (EOFException e) {
                System.out.println(e);
            }
            if (studentObject != null) {
                for (Student student : studentObject) {
                    students.add(student);

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

    /////////////////////////////////////////////////////////////////////////////
    //Write courses list to file
    public void writeCourse(List<Course> courses) {

        try {

            FileOutputStream f = new FileOutputStream(new File("C:\\temp\\courses.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(courses);

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    //Read courses list from file
    public List<Course> readCourse() throws IOException, FileNotFoundException, ClassNotFoundException {

        List<Course> courses = new ArrayList<>();

        try {

            FileInputStream fi = new FileInputStream(new File("C:\\temp\\courses.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            List<Course> coursesObject = null;

            try {
                coursesObject = (List<Course>) oi.readObject();

            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (EOFException e) {
                System.out.println(e);
            }
            if (coursesObject != null) {
                for (Course course : coursesObject) {
                    courses.add(course);

                }

            }

            else

                fi.close();
            oi.close();

        } catch (Exception e) {
            System.out.println(e);

        }

        return courses;
    }
}