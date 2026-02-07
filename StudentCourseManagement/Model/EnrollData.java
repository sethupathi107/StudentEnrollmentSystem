package StudentCourseManagement.Model;

import java.util.ArrayList;
import java.util.List;

public class EnrollData {
    private int sid;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private List<CourseData> coursesEnroll = new ArrayList<>();

    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public List<CourseData> getCoursesEnroll() {
        return coursesEnroll;
    }
    public void setCoursesEnroll(List<CourseData> coursesEnroll) {
        this.coursesEnroll = coursesEnroll;
    }
}
