package com.lopputyo.lopputyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lopputyo.lopputyo.data.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.lopputyo.lopputyo.data.Course;

@Service
public class StudentService {

    @Autowired

    StudentFileService studentFileService;

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

 

    // Call update to retrieve lastest data from file and returns list of students
    public List<Student> getStudents() {
        update();
        return new ArrayList<>(students);
    }

    // Same for courses
    public List<Course> getCourse() {
        update();
        return new ArrayList<>(courses);
    }

    // Add new student to students list and write list into file
    public void addStudent(Student student) {
        students.add(student);
        studentFileService.writeStudent(students);
    }
    //same for courses
    public void newCourse(Course course) {

        courses.add(course);
        studentFileService.writeCourse(courses);
    }
    // Add studentid to given course
    public void addToCourse(int studentid, String courseName) { 

        for (Course course2 : courses) {

            if (course2.getName().equals(courseName)) {

                System.out.println(courseName);
                List<Integer> courseStudents = course2.getCoursestudents();
                for (Student stu : students) {
                    if (studentid == stu.getStudentid())
                        courseStudents.add(studentid);
                    course2.setCoursestudents(courseStudents);
                    studentFileService.writeCourse(courses);

                }
            }

        }

    }
    //Search for course by name and return students from that course
    public List<Student> getCourseStudents(String coursename) {
        update();
        List<Integer> courseStudents = new ArrayList<>();
        List<Student> courseStudents2 = new ArrayList<>();
        for (Course course : courses) {
            if (course.getName().equals(coursename)) {
                courseStudents = course.getCoursestudents();
                for (int integer : courseStudents) {
                    for (Student student : students) {
                        if (integer == student.getStudentid()) {
                            courseStudents2.add(student);
                            System.out.println(student.getFname());
                            System.out.println(student.getLname());
                            System.out.println(student.getStudentid());
                        }
                    }

                }
            }
        }

        return new ArrayList<>(courseStudents2);
    }
    //Search which courses the student is enrolled to
    public List<Course> getStudentsCourses(int studentid) {
        update();
        List<Integer> courseStudents = new ArrayList<>();
        List<Course> courses2 = new ArrayList<>();
        for (Course course : courses) {
            courseStudents = course.getCoursestudents();
          
                for (int integer : courseStudents) {
                    if(integer==studentid){
                        courses2.add(course);
                        System.out.println(course.getName());
                    }
                   
                    }

                }
            
        

        return new ArrayList<>(courses2);
    }
    //read data from files to list's
    public void update() {

        try {
            courses = studentFileService.readCourse();
            students = studentFileService.readStudent();

        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

}