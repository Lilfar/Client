package sample.clientClasses;

import java.util.ArrayList;

public class clientExam {
    public ArrayList<clientQuestion> questions = new ArrayList<>();
    public String teacher;
    public int id;
    public ArrayList<Integer> questionIds = new ArrayList<Integer>();
    public String subjectName;
    public int online;
    public int courseID;
    public byte[] file;
    public String note;
    public String teacherNote;

    public clientExam(int id, String teacher) {
        this.id = id;
        this.teacher = teacher;
        this.courseID = courseID;
    }

    public clientExam() {
    }

    public ArrayList<clientQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<clientQuestion> questions) {
        this.questions = questions;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(ArrayList<Integer> questionIds) {
        this.questionIds = questionIds;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subject) {
        this.subjectName = subject;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getCourseID() {

        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
