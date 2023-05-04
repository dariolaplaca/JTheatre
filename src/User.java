import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phoneNumber;

    public User(int id, String name, String surname, String address, String email, String phone_number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phoneNumber = phone_number;
    }

    public User(int id, String name, String surname, String address, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
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

    public void buyATicket(Spectacle spectacle, Seat seat) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        Statement statement1 = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM PERFORMANCE WHERE ID = " + spectacle.getId());
        ResultSet resultSet2 = statement1.executeQuery("SELECT COUNT(*) FROM SEAT WHERE ID = " + seat.getId());
        resultSet.next();
        resultSet2.next();
        if(resultSet.getInt(1) == 0 || resultSet2.getInt(1) == 0){
            throw new NullPointerException("No Seat or Spectacle found");
        }
        resultSet = statement.executeQuery("SELECT COUNT(*) FROM TICKET JOIN PERFORMANCE ON TICKET.SPECTACLE_ID = PERFORMANCE.ID JOIN SEAT ON TICKET.SEAT_ID = SEAT.ID WHERE PERFORMANCE.ID = " + spectacle.getId() + " AND SEAT.ID = " + seat.getId());
        resultSet.next();
        if(resultSet.getInt(1) > 0) {
            throw new IllegalArgumentException("Seat is already booked");
        }
        resultSet = statement.executeQuery("SELECT COUNT(*) FROM USER JOIN TICKET ON TICKET.USER_ID = USER.ID JOIN PERFORMANCE ON TICKET.SPECTACLE_ID = PERFORMANCE.ID WHERE USER.ID = " + getId() + " AND PERFORMANCE.ID = " + spectacle.getId());
        resultSet.next();
        if(resultSet.getInt(1) >= 4){
            throw new IllegalArgumentException("You have already bought 4 seats");
        }
        resultSet = statement.executeQuery("SELECT SCHEDULE FROM PERFORMANCE WHERE ID = " + spectacle.getId());
        resultSet.next();
        Timestamp timestamp = resultSet.getTimestamp("schedule");
        if(timestamp.before(Timestamp.valueOf(LocalDateTime.now()))){
            throw new IllegalArgumentException("You cannot book a seat for an expired performance");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TICKET(SEAT_ID, USER_ID, SPECTACLE_ID) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, seat.getId());
        preparedStatement.setInt(2, this.getId());
        preparedStatement.setInt(3, spectacle.getId());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void printInfo(){
        System.out.println(name + " " + surname + " " + address + " " + email + " " + phoneNumber);
    }
}
