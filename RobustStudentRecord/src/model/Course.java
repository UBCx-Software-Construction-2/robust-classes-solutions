package model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private int DEFAULT_MAX_ENROLLMENT = 50;
    private String faculty;
    private String name;
    private List<Course> prereq;
    private int enrollment;
    private double percentage;

    public Course(String faculty, String name,  int enrollment, double pcnt) {
        this.faculty = faculty;
        this.name = name;
        prereq = new ArrayList<>();
        this.enrollment = enrollment;
        percentage = pcnt;
    }

    //getters
    public String getFaculty() { return faculty; }
    public String getName() { return name; }
    public List<Course> getPrereq() { return prereq; }
    public double getGrade() { return percentage; }
    public int getEnrollment() { return enrollment; }
    public boolean isCourseFull() { return enrollment == DEFAULT_MAX_ENROLLMENT; }

    public void addStudent() { enrollment++; }
    public void addPrereq(Course c) { prereq.add(c); }


}
