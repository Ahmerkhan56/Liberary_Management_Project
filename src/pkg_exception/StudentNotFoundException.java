package pkg_exception;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(){}

    @Override
    public String toString() {
        return "StudentNotFoundException is Generated";
    }
}
