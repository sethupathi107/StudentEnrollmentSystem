package StudentCourseManagement.Model;

public class InstructorData {
    int Iid;
    String Iname;
    String Email;
    String password;
    public int getIid() {
        return Iid;
    }
    public void setIid(int iid) {
        Iid = iid;
    }
    public String getIname() {
        return Iname;
    }
    public void setIname(String iname) {
        Iname = iname;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
