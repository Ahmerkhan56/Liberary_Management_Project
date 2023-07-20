package com.practice;
import pkg_Transaction.BookTransactionManager;
import pkg_book.BookManager;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int choice;
        Scanner sc=new Scanner(System.in);
        BookManager bm=new BookManager();
        StudentManager sm=new StudentManager();
        BookTransactionManager btm=new BookTransactionManager();
        do{
            System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if want to exit");
            choice=sc.nextInt();
            if(choice==1)//if user is student
            {
                System.out.println("Enter your Roll Number");
                int rollNo=sc.nextInt();
                try{
                    Student s=sm.get(rollNo);
                    if(s==null)
                        throw new StudentNotFoundException();
                    int std_choice;
                    do{
                        System.out.println("Enter 1 to View All Books\nEnter 2 to search Book by isbn\nEnter 3 to list Book by Subject\nEnter 4 to issue a Book\nEnter 5 to return a Book\nEnter 99 to exit");
                        std_choice=sc.nextInt();
                        switch (std_choice){
                           case 1:
                               System.out.println("View all selected");
                               break;
                           case 2:
                               System.out.println("Search by ISBN selected");
                               break;
                           case 3:
                               System.out.println("Search by Subject selected");
                               break;
                           case 4:
                               System.out.println("Issue of Book selected");
                               break;
                           case 5:
                               System.out.println("Return of Book selected");
                               break;
                           case 99:
                               System.out.println("Thanks for using Library");
                               break;
                           default:
                               System.out.println("invalid Choice");
                       }
                    }while(std_choice!=99);
                } catch (StudentNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }while (choice!=3);
    }
}
