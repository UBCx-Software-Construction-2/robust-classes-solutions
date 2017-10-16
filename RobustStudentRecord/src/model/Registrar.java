package model;

import exceptions.CourseFullException;
import exceptions.GPATooLowException;
import exceptions.MissingPrereqException;
import exceptions.NoCoursesTakenException;

import java.util.LinkedList;
import java.util.List;

public class Registrar {

    private String name;
    private List<Transcript> students;

    public Registrar(String name) {
        this.name = name;
        this.students = new LinkedList<>();
    }

    // getters
    public String getName() { return name; }
    public List<Transcript> getStudents() { return students; }

    //MODIFIES: this
    //EFFECTS: returns true if the student (represented as a transcript) was successfully added to the Registrar's list
    public boolean addStudent(Transcript stu) {
        if (!students.contains(stu)) {
            students.add(stu);
            return true;
        } else {
            return false;
        }
    }


    //MODIFIES: the transcript object passed in as parameter
    //EFFECTS: if no exception is caught, the student represented by the transcript is registered in the given
    //         course, otherwise catches MissingPrereqException and CourseFullException
    public boolean registerStudent(Course c, Transcript tct) {
        try {
           return tct.addCourse(c);
        } catch (MissingPrereqException | CourseFullException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    //MODIFIES: this list of transcripts
    //EFFECTS: walks through the list, and promotes all eligible students represented by the list of
    //         transcripts this has. Catches GPATooLowException and NoCoursesTakenException.
    public void promoteAllStudents() {
        try {
            for (Transcript t : students) {
                t.promoteStudent();
            }
        } catch (GPATooLowException | NoCoursesTakenException e) {
            System.out.println(e.getMessage());
        }
    }


}

