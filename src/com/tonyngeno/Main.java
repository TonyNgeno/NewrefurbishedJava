package com.tonyngeno;


import com.tonyngeno.view.CourseView;
import com.tonyngeno.view.StudentView;
import com.tonyngeno.view.TeacherView;

import javax.swing.text.TabExpander;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int option;
        StudentView studentView = new StudentView();
        TeacherView teacherView = new TeacherView();
        CourseView courseView = new CourseView();
        do {
            System.out.println("Welcome to School System:\n Please select an option:\n1. Manage Teachers\n2. Manage Students\n3. Manage Courses\n4. Exit");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    teacherView.menu();
                    break;
                case 2:
                    studentView.menu();
                    break;
                case 3:
                    courseView.menu();
                    break;
            }
        } while(option != 4);
        studentView = null;
        teacherView= null;
        courseView = null;
    }
}
