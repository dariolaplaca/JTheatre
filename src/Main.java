import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        JTheatre tuttiATeatro = new JTheatre();

        tuttiATeatro.getUserById(1).buyATicket(tuttiATeatro.getSpectacleById(1), tuttiATeatro.getSeatById(1));

        //statement.executeUpdate();
        //PreparedStatement //SCHELETRO DI UNA QUERY
    }
}
