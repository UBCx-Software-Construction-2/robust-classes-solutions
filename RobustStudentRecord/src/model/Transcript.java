package model;

import exceptions.CourseFullException;
import exceptions.GPATooLowException;
import exceptions.MissingPrereqException;
import exceptions.NoCoursesTakenException;

import java.util.LinkedList;
import java.util.List;

public class Transcript {

    private String name;
    private int year;
    private int id;
    private List<Course> currentCourses;
    private List<Course> pastCourses;

    public Transcript(String studentName, int academicYear, int studentID) {
        name = studentName;
        year = academicYear;
        id = studentID;
        currentCourses = new LinkedList<>();
        pastCourses = new LinkedList<>();
    }

    // getters
    public String getName() { return name; }
    public int getAcademicYear() { return year; }
    public int getId() { return id; }
    public List<Course> getCurrentCourses() { return currentCourses; }
    public List<Course> getPastCourses() { return pastCourses; }

    // helper for computeGPA
    private double percentToGPA(double pcnt) {
        return (pcnt / 20) - 1;
    }

    // EFFECTS: computes cGPA. In this case, we take it to mean that it is the total grades received so far, divided
    //          by the number of past courses taken.
    public double computeGPA() throws NoCoursesTakenException {
        if (this.pastCourses.isEmpty()) {
            throw new NoCoursesTakenException("No courses taken, cannot compute GPA");
        } else {
            double totalGradeSum = 0;

            for (Course c : pastCourses) {
                totalGradeSum += c.getGrade();
            }
            return percentToGPA(totalGradeSum / pastCourses.size());
        }
    }

    // EFFECTS: promotes the student to the next academic year. If successful, return true, else return false
    public boolean promoteStudent() throws GPATooLowException, NoCoursesTakenException {
        try {
            double thisGPA = this.computeGPA();
            if (thisGPA < 2.6) {
                throw new GPATooLowException("Cannot promote " + this.getName() + ": GPA too low.");
            } else {
                this.year++;
                return true;
            }
        } catch (NoCoursesTakenException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //REQUIRES: the transcript's past courses must not already contain the course you want to add
    //MODIFIES: this
    //EFFECTS: adds the given course to the list of past courses
    public boolean addToPastCourses(Course c) {
        if (!pastCourses.contains(c)) {
            pastCourses.add(c);
            return true;
        } else {
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a course (c) into the record
    public boolean addCourse(Course course) throws MissingPrereqException, CourseFullException {
        if (pastCourses.isEmpty() && !course.getPrereq().isEmpty()) {
            throw new MissingPrereqException("You do not have the necessary prerequisites.");

        } else if (course.isCourseFull()) {
            throw new CourseFullException("This course is currently full.");

        } else if (course.getPrereq().isEmpty()) {
            currentCourses.add(course);
            course.addStudent();
            return true;

        } else for (Course c : course.getPrereq()) {
            if (!pastCourses.contains(c)) {
                return false;
            }
        }
        currentCourses.add(course);
        course.addStudent();
        return true;
    }


}

