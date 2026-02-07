package StudentCourseManagement.Service;

public class StudentDetails {
    Long sid;
    String name;
    String email;
    String password;
    public void AddStudent(Long sid, String name, String email, String password ){
        this.sid=sid;
        this.name=name;
        this.email=email;
        this.password=password;
    }
}