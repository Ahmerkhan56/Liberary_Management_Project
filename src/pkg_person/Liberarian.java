package pkg_person;

public class Liberarian extends Person{
    private int id;
    private String doj;

    public Liberarian() {
        super();
    }

    public Liberarian(String name, String emailId, String phoneNumber, String address, String dob, int id, String doj) {
        super(name, emailId, phoneNumber, address, dob);
        this.id = id;
        this.doj = doj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Liberarian{" +
                "id=" + id +
                ", doj='" + doj + '\'' +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
