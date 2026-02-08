package StudentCourseManagement.Service;

import java.util.ArrayList;
import java.util.Scanner;


import StudentCourseManagement.Model.StudentData;

public class Student {
    static int sid=1;
    static ArrayList<StudentData> studentList = new ArrayList<>();

    public void login(){
        System.out.println("1-> Sign-in\n2-> Sign-Up\n3-> Exit");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        Enrollment enroll = new Enrollment();
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
    public StudentData student(int key) {
        Scanner sc = new Scanner(System.in);
        StudentData std=null;
        switch (key) {
            case 1:
                System.out.print("Enter the Username : ");
                String uname = sc.next();
                System.out.print("Enter the password : ");
                String pass = sc.next();

                std = signin(uname, pass);
                return std;

            case 2:
                System.out.print("Enter your Name     :");
                String name = sc.next();
                System.out.print("Enter your Email    :");
                String email = sc.next();
                System.out.print("Enter your Password :");
                String password = sc.next();
                std = newStudent(name,email, password);
                return std;
        
            default:
                return std;
        
        }
    }

    

    public StudentData newStudent(String name, String email, String password ){
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

