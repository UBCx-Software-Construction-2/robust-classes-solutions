package model;

public class PastCourse {
    private double grade;
    private Course course;

    public PastCourse(double grade, Course course){
        this.course = course;
        this.grade = grade;
    }

    public double getGrade(){
        return this.grade;
    }
}
