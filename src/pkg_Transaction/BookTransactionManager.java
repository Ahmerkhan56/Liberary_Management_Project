package pkg_Transaction;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookTransactionManager {
    ObjectOutputStream oos_bookTransaction=null;
    ObjectInputStream ois_bookTransaction=null;
    File bookTransaction_file=null;
    ArrayList<BookTransaction> book_transaction_list=null;
    public BookTransactionManager(){
       bookTransaction_file=new File("book_transaction.dat");
       book_transaction_list=new ArrayList<>();
       if(bookTransaction_file.exists()){
           try {
               ois_bookTransaction=new ObjectInputStream(new FileInputStream(bookTransaction_file));
               book_transaction_list= (ArrayList<BookTransaction>) ois_bookTransaction.readObject();
           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
       }
    }
    public boolean issueBook(int rollNo, int isbn){
        int total_Book_issued=0;
        for(BookTransaction book_transaction: book_transaction_list) {
            if ((book_transaction.getRollNo() == rollNo) && (book_transaction.getReturnDate() == null))
                total_Book_issued += 1;
            if (total_Book_issued >= 3)
                return false;
        }
        String issueDate=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        BookTransaction bookTransaction=new BookTransaction(isbn,rollNo,issueDate,null);
        book_transaction_list.add(bookTransaction);
        return true;
    }
    public boolean returnBook(int rollNo,int isbn){
        for(BookTransaction book_transaction: book_transaction_list) {
            if ((book_transaction.getRollNo() == rollNo) && (book_transaction.getReturnDate() == null)&&(book_transaction.getIsbn()==isbn)) {
                String returnDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                book_transaction.setReturnDate(returnDate);
                return true;
            }
        }
        return false;
    }
    public void showAll(){
        for(BookTransaction book_tans_list:book_transaction_list){
            System.out.println(book_tans_list);
        }
    }
    public void writeToFile(){
        try {
            oos_bookTransaction=new ObjectOutputStream(new FileOutputStream(bookTransaction_file));
            oos_bookTransaction.writeObject(book_transaction_list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
