package StudentCourseManagement.Service;

import java.util.Scanner;

import StudentCourseManagement.Model.CourseData;
import StudentCourseManagement.Model.InstructorData;
import StudentCourseManagement.Repo.CourseRepo;
import StudentCourseManagement.Repo.InstructorRepo;

public class Instructor {
    static int iid=1;
    
    public void login() {
        System.out.println("1-> Sign-in\n2-> Sign-Up\n3-> Exit");
        Scanner sc = new Scanner(System.in);
        try{
            int key = sc.nextInt();
            Enrollment enrollment = new Enrollment();
            InstructorData inst = instructor(key);
    
            if(inst!=null){
                boolean flag = true;
                while (flag) {
                    System.out.println("1-> Create Course  \n2-> Grade student  \n3-> List Available Course    \n4-> Exit");
                    try{
                        sc.nextLine();
                        int choice = sc.nextInt();
                    
                        switch (choice) {
                        case 1:
                            createCourse(inst.getIid());
                            break;
                        case 2:
                            enrollment.gradeAssignment(inst.getIid());
                            break;
                        case 3:
                            listCourse();
                            break;
        
                        default:
                            flag = false;
                            System.out.println("Exit from Instructor");
                            break;
                        }
                    }
                    catch(Exception e){
                        System.out.println("Invalid Input" );
                    }

                }
            }
            else{
                System.out.println("Give me correct user name and password");
            }
        }
        catch(Exception e){
            System.out.println("Invalid Input");
        }
    }

    public InstructorData instructor(int key){
        Scanner sc = new Scanner(System.in);
        InstructorData inst = null;
        switch (key) {
            case 1:
                System.out.print("Enter the Username : ");
                String uname = sc.next();
                System.out.print("Enter the password : ");
                String pass = sc.next();
                inst = signin(uname,pass );
                return inst;

            case 2:
                System.out.print("Enter your Name     : ");
                String name = sc.next();
                System.out.print("Enter your Email    : ");
                String email = sc.next();
                System.out.print("Enter your Password : ");
                String password = sc.next();
                inst = newInstructor(name,email, password);
                return inst;
        }
        return inst;
    }
    public InstructorData newInstructor(String name, String email, String password ){
        InstructorData newUser = new InstructorData();
        newUser.setIid(iid++);
        newUser.setIname(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        InstructorRepo.instructorDatas.add(newUser);
        return newUser;
    }

    public InstructorData signin(String iname,String pass){
        for(InstructorData instructor : InstructorRepo.instructorDatas){
            if(instructor.getIname().equals(iname) && instructor.getPassword().equals(pass)){
                return instructor;
            }
        }
        return null;
    }

    static int cid=1;
    public void createCourse(int iid){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Course Name : ");
        String cname = sc.nextLine();
        System.out.print("Enter the lesson      : ");
        String lesson = sc.nextLine();
        System.out.print("Enter the assignment  : ");
        String assignment = sc.nextLine();
        CourseData newUser = new CourseData();
        newUser.setIid(iid);
        newUser.setCid(cid++);
        newUser.setCourseName(cname);
        newUser.setLesson(lesson);
        newUser.setAssignment(assignment);
        CourseRepo.coursedatas.add(newUser);
    }

    public void listCourse(){
        for(CourseData course : CourseRepo.coursedatas){
            System.out.println("Course ID   :"+ course.getCid());
            System.out.println("Course Name :"+course.getCourseName());
            // System.out.println("Lesson      :"+course.getLesson());
            // System.out.println("Assignment  :"+course.getAssignment());
            System.out.println();
        }
    }
}
