import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Properties;

public class DbTests {
    @Test
    public void mysqlcheck() throws SQLException {
        String url = "jdbc:mysql://qaguru.lv:3308/tickets";

        Properties props = new Properties();
        props.setProperty("user", "testing");
        props.setProperty("password", "testing");

        Connection conn = DriverManager.getConnection(url, props);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM reservation");

        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
    }
}