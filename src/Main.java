import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        JTheatre tuttiATeatro = new JTheatre();
        tuttiATeatro.addSite("Teatro Massimo", "Piazza Giuseppe Verdi", "Palermo", false);
        tuttiATeatro.addSite("Teatro greco di Siracusa", "Via Luigi Bernabò Brea", "Siracusa", true);
        tuttiATeatro.addSite("Arena di Verona", "Piazza Bra", "Verona", true);

        Connection connection = DriverManager.getConnection(DBConnection.getUrl(), DBConnection.getUsername(), DBConnection.getPassword());
        User donald = tuttiATeatro.getUserById(connection, 2);
        User dario = tuttiATeatro.getUserById(connection, 1);


        donald.printInfo();
        dario.printInfo();

        connection.close();

        //statement.executeUpdate();
        //PreparedStatement //SCHELETRO DI UNA QUERY
    }
}
