import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class JTheatre {

    public void addUser(String name, String surname, String address, String email, Optional<String> phone_number) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER(NAME, SURNAME, ADDRESS, EMAIL, PHONE) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, address);
        preparedStatement.setString(4, email);
        if(phone_number.isPresent()){
            preparedStatement.setString(5, phone_number.get());
        } else {
            preparedStatement.setNull(5, Types.VARCHAR);
        }
        preparedStatement.executeUpdate();
        connection.close();
    }
    
    public User getUserById(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USER WHERE ID = " + id);
        User user = null;
        while(resultSet.next()){
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            user = new User(id, name, surname, address, email, phone);
        }
        connection.close();
        return user;
    }

    public void addSite(String name, String address, String city, boolean isOutdoor){
        Site newSite = new Site(name, address, city, isOutdoor);
    }

    public void addHall(String name, Site site){
        Hall newHall = new Hall(name);
        site.addHall(newHall);
    }

    public void addSpectacle(String name, LocalDate schedule, int duration, double price, String genre, Hall hall){
        Spectacle newSpectacle = new Spectacle(name, schedule, duration, price, genre);
        hall.addSpectacle(newSpectacle);
    }

    public void addSeat(Hall hall, int number, int row){
        hall.addSeat(new Seat(number, row));
    }

    public Set<Spectacle> suggestSpectacles(User u) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeQuery("""
                SELECT SITE.CITY, COUNT(SITE_ID) FROM USER
                JOIN TICKET ON TICKET.USER_ID = USER.ID
                JOIN SEAT ON TICKET.SEAT_ID = SEAT.ID
                JOIN HALL ON HALL.ID = SEAT.HALL_ID
                JOIN SITE ON SITE.ID = HALL.SITE_ID
                GROUP BY SITE.CITY;
                """);
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            System.out.println(resultSet.next());
        }
        connection.close();
        return null;
    }


}
