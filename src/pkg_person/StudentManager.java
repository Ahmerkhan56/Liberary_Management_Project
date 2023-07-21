package pkg_person;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class StudentManager {
    ObjectOutputStream oos_student=null;
    ObjectInputStream ois_student=null;
    File student_file=null;
    ArrayList<Student> student_list=null;
    public StudentManager(){
        student_file=new File("Students.dat");
        student_list=new ArrayList<>();
        if(student_file.exists()){
            try {
                ois_student=new ObjectInputStream(new FileInputStream(student_file));
                student_list= (ArrayList<Student>) ois_student.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void addAStudent(Student student){
        student_list.add(student);
    }
    public Student get(int rollNo){
        for(Student student: student_list) {
            if (student.getRollNo()==rollNo){
                return student;
            }
        }
        return null;

    }
    public void viewAllStudents(){
        for(Student student:student_list){
            System.out.println(student);
        }
    }
    public boolean deleteStudent(int delete_rollNo){
        ListIterator<Student> student_Iterator= (ListIterator<Student>) student_list.listIterator();
        while (student_Iterator.hasNext()){
            Student student=student_Iterator.next();
            if(student.getRollNo()==delete_rollNo){
                student_list.remove(student);
                return true;
            }
        }
        return false;
    }
    public boolean updateStudent(int update_roll_number,String name, String emailId, String phoneNumber, String address, String dob, int std, String division){
        ListIterator<Student> student_Iterator= (ListIterator<Student>) student_list.listIterator();
        while (student_Iterator.hasNext()){
            Student student=student_Iterator.next();
            if(student.getRollNo()==update_roll_number){
                student.setName(name);
                student.setAddress(address);
                student.setStd(std);
                student.setDivision(division);
                student.setEmailId(emailId);
                student.setPhoneNumber(phoneNumber);
                return true;
            }
        }
        return false;
    }
    public void writeToFile(){
        try{
            oos_student=new ObjectOutputStream(new FileOutputStream(student_file));
            oos_student.writeObject(student_list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
