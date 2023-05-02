import java.util.HashSet;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phoneNumber;
    private Set<Ticket> tickets;

    public User(int id, String name, String surname, String address, String email, String phone_number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phoneNumber = phone_number;
        this.tickets = new HashSet<>();
    }

    public User(int id, String name, String surname, String address, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.tickets = new HashSet<>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void buyATicket(){

    }

    public void printInfo(){
        System.out.println(name + " " + surname + " " + address + " " + email + " " + phoneNumber);
    }
}
