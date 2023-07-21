package com.practice;
import pkg_Transaction.BookTransactionManager;
import pkg_book.Book;
import pkg_book.BookManager;
import pkg_exception.BookNotFoundException;
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
                               System.out.println("The Following are the Books Details");
                               bm.viewAllBooks();
                               break;
                           case 2:
                               System.out.println("Search by ISBN selected");
                               int book_isbn=sc.nextInt();
                               Book st_book=bm.searchBookbyIsbn(book_isbn);
                               try {
                                       if(st_book==null)
                                       throw new BookNotFoundException();
                                       System.out.println(st_book);
                                   } catch (BookNotFoundException e) {
                                       e.printStackTrace();
                                   }
                               break;
                           case 3:
                               System.out.println("Search by Subject selected");
                               String book_subject=sc.nextLine();
                               bm.listBookBySubject(book_subject);
                               break;
                           case 4:
                               System.out.println("Enter Book-ISBN in integer for Issuing");
                               book_isbn=sc.nextInt();
                               st_book=bm.searchBookbyIsbn(book_isbn);
                               try {
                                  if(st_book==null)
                                       throw new BookNotFoundException();
                                   if(st_book.getAvailable_quantity()>0){
                                   if(btm.issueBook(rollNo,book_isbn)){
                                       st_book.setAvailable_quantity(st_book.getAvailable_quantity()-1);
                                       System.out.println("Book issue Successfully");}
                                   else{
                                           System.out.println("More then 3 Books are Issued");}
                                   }else{
                                       System.out.println("Sorry Book is unavailable");
                                   }
                               } catch (BookNotFoundException e) {
                                   e.printStackTrace();
                               }
                               break;
                           case 5:
                               System.out.println("Enter Book-ISBN in integer For return");
                               book_isbn=sc.nextInt();
                               st_book=bm.searchBookbyIsbn(book_isbn);
                               try {
                                   if(st_book==null)
                                       throw new BookNotFoundException();
                                       if(btm.returnBook(rollNo,book_isbn)){
                                           st_book.setAvailable_quantity(st_book.getAvailable_quantity()+1);
                                           System.out.println("Book Return Successfully");}
                                       else{
                                           System.out.println("Could not return the book");
                                       }

                               } catch (BookNotFoundException e) {
                                   e.printStackTrace();
                                   System.out.println("Book with this ISBN Does not exist");
                               }
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
            }else if(choice==2)//user is librarian
            {
             int lib_choice;
             do{
                 System.out.println("Enter 11 to view all students\nEnter 12 to print a student by Roll Number\nEnter 13 to Register a student\nEnter 14 to update a student\nEnter 15 to delete a Student");
                 System.out.println("Enter 21 to view all Books\nEnter 22 to print a Book by isbn Number\nEnter 23 to Add a new Book\nEnter 24 to update a Book\nEnter 25 to delete a Book");
                 System.out.println("Enter 31 to view all Transactions");
                 System.out.println("Enter 99 to Exit");
                 lib_choice=sc.nextInt();
                 switch (lib_choice){
                     case 11://view All Students
                         System.out.println("Print All Students Record");
                         sm.viewAllStudents();
                         break;
                     case 12://search student based on roll number
                         System.out.println("Enter Roll Number to fetch Student's Record");
                         int get_rollNo= sc.nextInt();
                         Student student=sm.get(get_rollNo);
                         try {
                             if(student==null)
                             {
                                 throw new StudentNotFoundException();

                             }
                             System.out.println(student);
                         }catch (StudentNotFoundException e){
                             e.printStackTrace();
                             System.out.println("No Record Matches this Roll Number");
                         }
                         break;
                     case 13://Add student
                         System.out.println("Enter Student Details to Add");
                         String name;
                         String emailId;
                         String phoneNumber;
                         String address;
                         String dob;
                         int rollNo;
                         int std;
                         String division;
                         sc.nextLine();
                         System.out.println("Name");
                         name=sc.nextLine();
                         System.out.println("Email Id");
                         emailId=sc.nextLine();
                         System.out.println("PhoneNumber");
                         phoneNumber=sc.nextLine();
                         System.out.println("Address");
                         address=sc.nextLine();
                         System.out.println("Date Of Birth");
                         dob=sc.nextLine();
                         System.out.println("Roll Number as Integer");
                         rollNo=sc.nextInt();
                         System.out.println("standard as Integer");
                         std=sc.nextInt();
                         sc.nextLine();
                         System.out.println("Division");
                         division=sc.nextLine();
                         student=new Student(name,emailId,phoneNumber,address,dob,rollNo,std,division);
                         sm.addAStudent(student);
                         System.out.println("Student Add Successfully");
                         break;
                     case 14://update student
                         System.out.println("Enter a roll Number to update or Modify Record");
                         int modify_rollNo= sc.nextInt();
                         student=sm.get(modify_rollNo);
                         try {
                             if(student==null)
                             {
                                 throw new StudentNotFoundException();

                             }
                             sc.nextLine();
                             System.out.println("Name");
                             name=sc.nextLine();
                             System.out.println("Email Id");
                             emailId=sc.nextLine();
                             System.out.println("PhoneNumber");
                             phoneNumber=sc.nextLine();
                             System.out.println("Address");
                             address=sc.nextLine();
                             System.out.println("Date Of Birth");
                             dob=sc.nextLine();
                             System.out.println("standard as Integer");
                             std=sc.nextInt();
                             sc.nextLine();
                             System.out.println("Division");
                             division=sc.nextLine();
                             sm.updateStudent(modify_rollNo,name,emailId,phoneNumber,address,dob,std,division);
                             System.out.println("Student Record updated Successfully");

                         }catch (StudentNotFoundException e){
                             e.printStackTrace();
                             System.out.println("No Record Matches this Roll Number");
                         }
                         break;
                     case 15://delete a student
                         System.out.println("Enter a Roll Number in integer to delete a Student");
                         int delete_rollNo= sc.nextInt();
                         if(sm.deleteStudent(delete_rollNo))
                           System.out.println("Student Record is Removed Successfully");
                         else
                            System.out.println("Student Record not Found");
                         break;
                     case 21://view all books
                         System.out.println("View all Books");
                         bm.viewAllBooks();
                         break;
                     case 22://search Book by isbn
                         System.out.println("Enter Book-ISBN to Fetch Record ");
                         int book_sibn=sc.nextInt();
                         Book book=bm.searchBookbyIsbn(book_sibn);
                             try {
                                 if(book==null)
                                 throw new BookNotFoundException();
                                System.out.println(book);
                             } catch (BookNotFoundException e) {
                                 e.printStackTrace();
                                 System.out.println("Book Not Found");
                             }

                         break;
                     case 23://add a Book
                         System.out.println("Please Enter Book Details to add");
                         int isbn;
                         String title;
                         String author;
                         String publisher;
                         int edition;
                         String subject;
                         int available_quantity;
                         sc.nextLine();
                         System.out.println("ISBN");
                         isbn=sc.nextInt();
                         sc.nextLine();
                         System.out.println("Title");
                         title=sc.nextLine();
                         System.out.println("Publisher");
                         publisher=sc.nextLine();
                         System.out.println("Author");
                         author=sc.nextLine();
                         System.out.println("Subject");
                         subject=sc.nextLine();
                         System.out.println("Edition");
                         edition=sc.nextInt();
                         System.out.println("Available Quantity");
                         available_quantity=sc.nextInt();
                         book=new Book(isbn,title,author,publisher,edition,subject,available_quantity);
                         bm.addABook(book);
                         System.out.println("A book record is Added Successfully");
                         break;
                     case 24:
                         System.out.println("Enter Book-ISBN to update Record");
                         int update_isbn=sc.nextInt();
                         book=bm.searchBookbyIsbn(update_isbn);
                         try {
                             if(book==null)
                                 throw new BookNotFoundException();
                             sc.nextLine();
                             System.out.println("Title");
                             title = sc.nextLine();
                             System.out.println("Author");
                             author = sc.nextLine();
                             System.out.println("Publisher");
                             publisher = sc.nextLine();
                             System.out.println("Subject");
                             subject = sc.nextLine();
                             System.out.println("Edition");
                             edition = sc.nextInt();
                             System.out.println("Available Quantity");
                             available_quantity = sc.nextInt();
                             bm.updateBook(update_isbn, title, author, publisher, edition, subject, available_quantity);
                             System.out.println("Issue of Book selected");
                         } catch (BookNotFoundException e) {
                             e.printStackTrace();
                             System.out.println("Book not Found based on isbn");
                         }
                         break;
                     case 25://delete Book
                         System.out.println("Enter Book-ISBN which ypu ant to Delete ");
                         int delete_isbn=sc.nextInt();
                         if(bm.deleteBook(delete_isbn))
                         {
                             System.out.println("Book deleted Successfully");
                         }else{
                             System.out.println("Book not found");
                         }
                         break;
                     case 99:
                         System.out.println("Thanks for using Library");
                         break;
                     default:
                         System.out.println("invalid Choice");
                 }
             }while(lib_choice!=99);


            }
        }while (choice!=3);
        sm.writeToFile();
        bm.writeToFile();
    }
}
