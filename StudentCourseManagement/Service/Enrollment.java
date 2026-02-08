package StudentCourseManagement.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import StudentCourseManagement.Model.CourseData;
import StudentCourseManagement.Model.EnrollData;
import StudentCourseManagement.Repo.CourseRepo;

public class Enrollment {
    static List<EnrollData> enrolls = new ArrayList<>();
    static Scanner sc  = new Scanner(System.in);

    public void enrollCourse(int sid,String sname ){
        EnrollData enroll = new EnrollData();
        Scanner sc = new Scanner(System.in);
        System.out.println("List of courses Available");
        Instructor course = new Instructor();
        course.listCourse();
        System.out.println("Enter the course No you want to Enroll");

        int cid = sc.nextInt();
        for(CourseData courses : CourseRepo.coursedatas){
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
                        System.out.println("Course Name       : "+course.getCourseName());
                        System.out.println("Course Lesson     : "+course.getLesson());
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
        for(CourseData course: CourseRepo.coursedatas){
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

