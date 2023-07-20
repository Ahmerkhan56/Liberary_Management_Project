package pkg_person;
import java.util.regex.Pattern;
abstract public class Person {
    protected String name;
    protected String emailId;
    protected String phoneNumber;
    protected String address;
    protected String dob;

    public Person() {
    }

    public Person(String name, String emailId, String phoneNumber, String address, String dob) {
        //this.name = name;
        this.setName(name);
        this.setEmailId(emailId);
        //this.emailId = emailId;
        this.setPhoneNumber(phoneNumber);
        //this.phoneNumber = phoneNumber;
        this.address = address;
        //this.dob = dob;
        this.setDob(dob);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean isValidName= Pattern.matches("[a-zA-Z]+",name);
        if(isValidName)
           this.name = name;
        else
            this.name="default_Name";
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        boolean isValidEmailId=Pattern.matches("^(.+)@(.+)$",emailId);
        if(isValidEmailId)
          this.emailId = emailId;
        else
            this.emailId="abc@gmail.com";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        boolean isValidPhoneNumber=Pattern.matches("^((\\+92)?(0092)?(92)?(0)?)(3)([0-9]{9})$",phoneNumber);
        if(isValidPhoneNumber)
           this.phoneNumber = phoneNumber;
        else
            this.phoneNumber="XXXXXXXXXXX";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        boolean isValidDob=Pattern.matches("\\d{2}-\\d{2}-\\d{4}",dob);
        if(isValidDob)
            this.dob = dob;
        else
            this.dob="01-06-2005";
    }
}
