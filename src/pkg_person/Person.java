package pkg_person;

abstract public class Person {
    protected String name;
    protected String emailId;
    protected String phoneNumber;
    protected String address;
    protected String dob;

    public Person() {
    }

    public Person(String name, String emailId, String phoneNumber, String address, String dob) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        this.dob = dob;
    }
}
