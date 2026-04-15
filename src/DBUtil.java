import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3308/edutrack_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "rama@1982"; // use your own password

    private DBUtil() {
        // prevent object creation
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}