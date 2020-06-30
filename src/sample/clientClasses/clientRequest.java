package sample.clientClasses;

public class clientRequest {
    public String course;
    public String teacher;
    public int timeAdded;
    public String explanation;
    public int id;

    public clientRequest(int timeAdded, String explanation, int id) {
        this.timeAdded = timeAdded;
        this.explanation = explanation;
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(int timeAdded) {
        this.timeAdded = timeAdded;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
