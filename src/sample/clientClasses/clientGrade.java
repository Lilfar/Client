package sample.clientClasses;

import java.util.ArrayList;

public class clientGrade {
    public clientUser student;
    public String studentname;
    public double grade;
    public clientCourse course;
    public String courseName;
    public int online;
    public ArrayList<clientAnswer> answers = new ArrayList<>();
    public byte[] file;

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int confirmed;

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

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
