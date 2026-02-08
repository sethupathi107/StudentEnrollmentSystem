package StudentCourseManagement.Controller;

import java.util.*;

import StudentCourseManagement.Service.Instructor;
import StudentCourseManagement.Service.Student;
public class Main {
    public static void main(String[] args) {
        boolean flag=true;
        while(flag){
            System.out.println("Select your role");
            System.out.println("1-> Student\n2-> Instructor\n3-> Exit");
            Scanner sc = new Scanner(System.in);
            try{
                int role = sc.nextInt();
    
                switch (role) {
                    case 1:
                        Student student = new Student();
                        student.login();
                        break;
                    case 2:
                        Instructor instructor = new Instructor();
                        instructor.login();
                        break;
                    case 3:
                        System.out.println("Program is closed");    
                        flag=false;    
                        break;
                    default:
                        System.out.println("Give me a proper input");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input");
            }
            
        }
    }
}

