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

    public Spectacle getSpectacleById(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM PERFORMANCE WHERE ID = " + id);
        Spectacle spectacle = null;

        while(resultSet.next()){
            String name = resultSet.getString("name");
            Timestamp schedule = resultSet.getTimestamp("schedule");
            int duration = resultSet.getInt("duration");
            double price = resultSet.getDouble("price");
            String genre = resultSet.getString("genre");
            spectacle = new Spectacle(id, name, schedule, duration, price, genre);
        }
        connection.close();
        return spectacle;
    }

    public Seat getSeatById(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM SEAT WHERE ID = " + id);
        Seat seat = null;
        while(resultSet.next()){
            int number = resultSet.getInt("seat_number");
            int row = resultSet.getInt("seat_row");
            int hall_id = resultSet.getInt("hall_id");
            seat = new Seat(id, number, row, hall_id);
        }
        connection.close();
        return seat;
    }

    public void addSeatsToHall(int numberOfSeatPerRow, int numberOfRow, int hall_id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        for(int i = 1; i <= numberOfRow; i++){
            for(int j = 1; j <= numberOfSeatPerRow; j++){
                statement.executeUpdate("INSERT INTO SEAT(HALL_ID, SEAT_ROW, SEAT_NUMBER) VALUES(" + hall_id +", " + i + ", " + j + ")");
            }
        }
        connection.close();
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
