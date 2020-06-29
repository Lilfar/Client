package sample.clientClasses;

import java.util.ArrayList;

public class clientGrade {
    public clientUser student;
    public double grade;
    public clientCourse course;
    public String courseName;
    public int online;
    public ArrayList<clientAnswer> answers = new ArrayList<>();

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
