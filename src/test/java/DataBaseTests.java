import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DataBaseTests {
    @Test
    public void checkDataBaseConection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/zhzh";

        Properties props = new Properties();
        props.setProperty("user", "web");
        props.setProperty("password", "kpo7gcp");

        Connection connection = DriverManager.getConnection(url, props);

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            System.out.println(rs.getString("username"));
            //mapperi
        }
// http://qaguru.lv:8089/tickets/
        User user = new User();
        user.setEmail("qa@java.lv");
        user.setUsername("QA3");
        user.setPassword("QA3pass");

        PreparedStatement pst = connection.prepareStatement("INSERT INTO users (email,username,password) VALUES (?,?,?)");
        pst.setString(1,user.getEmail());
        pst.setString(2,user.getUsername());
        pst.setString(3,user.getPassword());

        System.out.println(pst.executeUpdate());
        rs.close();
        st.close();
    }
}