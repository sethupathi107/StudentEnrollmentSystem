package StudentCourseManagement.Model;

import java.util.ArrayList;

public class StudentData {
    private int sid;
    private String name;
    private String email;
    private String password;

    private ArrayList<CourseData> courses = new ArrayList<>();

    public ArrayList<CourseData> getCourses() {
        return courses;
    }
    public void setCourses(ArrayList<CourseData> courses) {
        this.courses = courses;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
}
