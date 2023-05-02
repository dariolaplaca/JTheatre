public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/teatro";
    private static final String username = "root";
    private static final String password = "password";

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }

    public static String getUrl() {
        return url;
    }

}
