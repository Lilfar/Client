package sample.clientClasses;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class clientCourse {
    public String name;
    public int id;
    public int online;

    public ArrayList<clientUser> students = new ArrayList<>();

    public Double average;

    public clientCourse(String name, int id, int online) {
        this.name = name;
        this.id = id;
    }

    public clientCourse(String name, int id, int online, Double  average) {
        this.name = name;
        this.id = id;
        this.online = online;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public ArrayList<clientUser> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<clientUser> students) {
        this.students = students;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}
