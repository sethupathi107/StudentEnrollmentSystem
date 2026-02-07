package StudentCourseManagement.Controller;

import java.util.*;

import StudentCourseManagement.Model.CourseData;
import StudentCourseManagement.Model.EnrollData;
import StudentCourseManagement.Model.InstructorData;
import StudentCourseManagement.Model.StudentData;


public class Main {
    public static void main(String[] args) {
        while(true){
            Interface entity = new Interface();
            if(entity.pageinterface()) break;
        }
    }
}

class Interface{
    public boolean pageinterface(){
        System.out.println("Select your role");
        System.out.println("1-> Student\n2-> Instructor\n3-> Exit");
        Scanner sc = new Scanner(System.in);
        int role = sc.nextInt();

        switch (role) {
            case 1:
                User student = new User();
                student.login(true);
                return false;
            case 2:
                User instructor = new User();
                instructor.login(false);
                return false;
            case 3:
                System.out.println("Program is closed");
                return true;        
            default:
                System.out.println("Give me a proper input");
                return true;
        }
        
    }
}


class User {
    public void login(boolean user){
        System.out.println("1-> Sign-in\n2-> Sign-Up\n3-> Exit");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        Enroll enroll = new Enroll();
        if(user){

            StudentData std = student(key);

            if(std!=null){
            boolean flag = true;
            while (flag) {
                System.out.println("1-> Enroll into course  \n2-> Enrolled Course  \n3-> Complete Assignment  \n4-> Check Grades of your course  \n5-> Exit");
                int choice = sc.nextInt();
                
            
                switch (choice) {
                case 1:
                    enroll.enrollCourse(std.getSid(),std.getName());
                    break;
                case 2:
                    enroll.listEnrolledCourses(std.getSid());
                    break;
                case 3:
                    enroll.completeAssignment(std.getSid());
                    break;
                case 4:
                    enroll.isGraded(std.getSid());
                    break;
                default:
                    flag = false;
                    System.out.println("Exit from Student");
                    break;
            }
            }
        }
        else{
            System.out.println("Enter Correct user name and password");
        }



        }
        else{
            Enroll enrollment = new Enroll();
            InstructorData inst = instructor(key);

            if(inst!=null){
                boolean flag = true;
                while (flag) {
                    System.out.println("1-> Create Course  \n2-> Grade student  \n3-> List Available Course    \n4-> Exit");
                    int choice = sc.nextInt();
                    CreateCourse course = new CreateCourse();
                
                    switch (choice) {
                    case 1:
                        course.createCourse(inst.getIid());
                        break;
                    case 2:
                        enrollment.gradeAssignment(inst.getIid());
                        break;
                    case 3:
                        course.listCourse();
                        break;
    
                    default:
                        flag = false;
                        System.out.println("Exit from Instructor");
                        break;
                }
                }
            }
            else{
                System.out.println("Give me correct user name and password");
            }

            

        } 
    }
    public StudentData student(int key) {
            GetToStudent students = new GetToStudent();
            Scanner sc = new Scanner(System.in);
            StudentData std=null;
            switch (key) {
                case 1:
                    System.out.print("Enter the Username : ");
                    String uname = sc.next();
                    System.out.print("Enter the password : ");
                    String pass = sc.next();

                    std = students.signin(uname, pass);
                    return std;

                case 2:
                    System.out.print("Enter your Name     :");
                    String name = sc.next();
                    System.out.print("Enter your Email    :");
                    String email = sc.next();
                    System.out.print("Enter your Password :");
                    String password = sc.next();
                    std = students.NewStudent(name,email, password);
                    return std;
            
                default:
                    return std;
            
            }
        }

    public InstructorData instructor(int key){
            Scanner sc = new Scanner(System.in);
            GetToInstructor instructor = new GetToInstructor();
            InstructorData inst = null;
            switch (key) {
                case 1:
                    System.out.print("Enter the Username : ");
                    String uname = sc.next();
                    System.out.print("Enter the password : ");
                    String pass = sc.next();
                    inst = instructor.signin(uname,pass );
                    return inst;

                case 2:
                    System.out.print("Enter your Name     :");
                    String name = sc.next();
                    System.out.print("Enter your Email    :");
                    String email = sc.next();
                    System.out.print("Enter your Password :");
                    String password = sc.next();
                    inst = instructor.NewInstructor(name,email, password);
                    return inst;
            
                default:

                    break;
            }
            return inst;
        }
}

class GetUserDetails {
    
}



class GetToStudent extends GetUserDetails {
    static int sid=1;

    static ArrayList<StudentData> studentList = new ArrayList<>();

    public StudentData NewStudent(String name, String email, String password ){
        StudentData newUser = new StudentData();
        newUser.setSid(sid++);
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        studentList.add(newUser);
        return newUser;
    }

    public StudentData signin(String sname , String pass){
        for(StudentData student : studentList){
            if(student.getName().equals(sname) && student.getPassword().equals(pass) ){
                return student;
            }
        }
        return null;
    }
}



class GetToInstructor extends GetUserDetails {
    static int sid=1;

    static ArrayList<InstructorData> instructorDatas = new ArrayList<>();

    public InstructorData NewInstructor(String name, String email, String password ){
        InstructorData newUser = new InstructorData();
        newUser.setIid(sid++);
        newUser.setIname(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        instructorDatas.add(newUser);
        return newUser;
    }

    public InstructorData signin(String iname,String pass){
        for(InstructorData instructor : instructorDatas){
            if(instructor.getIname().equals(iname) && instructor.getPassword().equals(pass)){
                return instructor;
            }
        }
        return null;
    }


}




class CreateCourse {
    static int sid=1;

    public static ArrayList<CourseData> coursedatas = new ArrayList<>();

    public void createCourse(int iid){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Course Name : ");
        String cname = sc.nextLine();
        System.out.print("Enter the lesson      : ");
        String lesson = sc.nextLine();
        System.out.print("Enter the assignment  :");
        String assignment = sc.nextLine();
        CourseData newUser = new CourseData();
        newUser.setIid(iid);
        newUser.setCid(sid++);
        newUser.setCourseName(cname);
        newUser.setLesson(lesson);
        newUser.setAssignment(assignment);
        coursedatas.add(newUser);
    }

    public void listCourse(){
        for(CourseData course : coursedatas){
            System.out.println("Course ID   :"+ course.getCid());
            System.out.println("Course Name :"+course.getCourseName());
            // System.out.println("Lesson      :"+course.getLesson());
            // System.out.println("Assignment  :"+course.getAssignment());
            System.out.println();
        }
    }
}


class Enroll {
    static List<EnrollData> enrolls = new ArrayList<>();
    static Scanner sc  = new Scanner(System.in);

    public void enrollCourse(int sid,String sname ){
        EnrollData enroll = new EnrollData();
        Scanner sc = new Scanner(System.in);
        System.out.println("List of courses Available");
        CreateCourse course = new CreateCourse();
        course.listCourse();
        System.out.println("Enter the course No you want to Enroll");

        int cid = sc.nextInt();
        for(CourseData courses : CreateCourse.coursedatas){
            if(courses.getCid()==cid){
                enroll.setSid(sid);
                enroll.setName(sname);
                enroll.getCoursesEnroll().add(courses);
            }
        }
        enrolls.add(enroll);
    }
    
    public void listEnrolledCourses(int sid){
        for(EnrollData enroll : enrolls){
            if(enroll.getSid()==sid){
                for(CourseData course: enroll.getCoursesEnroll()){
                    System.out.println("Course ID         : "+course.getCid());
                    System.out.println("Course Name       : "+course.getCourseName());
                    System.out.println("Course Lesson     : "+course.getLesson());
                    System.out.println("Course Assignment : "+course.getAssignment());
                    System.out.println();
                }
            }            
        }
    }

    public void completeAssignment(int sid){
        listEnrolledCourses(sid);
        System.out.println("Enter the course id you want to complete Assignment");
        int cid = sc.nextInt();
        for(EnrollData enroll : enrolls){
            if(enroll.getSid()==sid){
                for(CourseData course: enroll.getCoursesEnroll()){
                    if(course.getCid()==cid){
                        System.out.println("Course ID"+course.getCid());
                        System.out.println("Course Name       :"+course.getCourseName());
                        System.out.println("Course Lesson     :"+course.getLesson());
                        System.out.println("Course Assignment : "+course.getAssignment());
                        System.out.println("Give me your Answer");
                        sc.nextLine();
                        String ans = sc.nextLine();
                        course.setAnswers(ans);
                        course.setStatus(true);
                    }
                }
            }            
        }
    }


    public void isGraded(int sid){
        listEnrolledCourses(sid);
        System.out.println("Give me the Course id you want to check is graded?");
        int cid = sc.nextInt();
        for(EnrollData enroll : enrolls){
            if(enroll.getSid()==sid){
                for(CourseData course: enroll.getCoursesEnroll()){
                    if(course.getCid()==cid){
                        if(course.isStatus()){
                            System.out.println("Course Name       : "+course.getCourseName());
                            System.out.println("Course Lesson     : "+course.getLesson());
                            System.out.println("Course Assignment : "+course.getAssignment());
                            System.out.println("Your Answer       : "+course.getAnswers());
                            System.out.println("Remark            : "+course.getRemark());
                            System.out.println();
                        }
                    }
                }
            }            
        }
    }


    public void gradeAssignment(int iid){
        for(CourseData course: CreateCourse.coursedatas){
            if(course.getIid()==iid){
                    System.out.println("Course ID         : "+course.getCid());
                    System.out.println("Course Name       : "+course.getCourseName());
                    System.out.println("Course Lesson     : "+course.getLesson());
                    System.out.println("Course Assignment : "+course.getAssignment());
                    System.out.println();
            }
        }
        System.out.println("Enter the course id you want to grade Assignment");
        int cid = sc.nextInt();
        for(EnrollData enroll : enrolls){
            for(CourseData course: enroll.getCoursesEnroll()){
                if(course.getCid()==cid){
                    System.out.println("Student id        : "+enroll.getSid());
                    System.out.println("Student name      : "+ enroll.getName());
                    System.out.println("Course Name       : "+course.getCourseName());
                    System.out.println("Course Lesson     : "+course.getLesson());
                    System.out.println("Course Assignment : "+course.getAssignment());
                    System.out.println("Student Answer    : "+course.getAnswers());
                    System.out.println("Correct the Answer");
                    sc.nextLine();
                    String ans = sc.nextLine();
                    course.setRemark(ans);
                    course.setStatus(true);
                    System.out.println();
                }
            }            
        }
    }
}