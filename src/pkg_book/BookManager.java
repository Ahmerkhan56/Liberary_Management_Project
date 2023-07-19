package pkg_book;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class BookManager {
    ObjectOutputStream oos_book=null;
    ObjectInputStream ois_book=null;
    File book_file=new File("Books.dat");
    ArrayList<Book> book_list=null;
    public BookManager(){
        book_list=new ArrayList<>();
        if(book_file.exists()){
            try {
                ois_book=new ObjectInputStream(new FileInputStream(book_file));
                book_list=(ArrayList<Book>) ois_book.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void addABook(Book book){
        book_list.add(book);
    }
    public void viewAllBooks(){
        for(Book book:book_list){
            System.out.println(book);
        }
    }
    public Book searchBookbyIsbn(int search_isbn){
        for(Book book:book_list){
            if(book.getIsbn()==search_isbn)
                 return book;
        }
        return null;
    }
    public boolean deleteBook(int delete_isbn){
        ListIterator<Book> book_iterator= (ListIterator<Book>) book_list.iterator();
        while (book_iterator.hasNext()){
            Book book=book_iterator.next();
            if(book.getIsbn()==delete_isbn){
                book_list.remove(book);
                return true;
            }
        }
        return false;

    }
}
