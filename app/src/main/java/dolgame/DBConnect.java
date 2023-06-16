package dolgame;
import java.sql.*;
public class DBConnect {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dolgameDB";
        String userId = "root";
        String userPassword = "1234";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userId, userPassword);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("DB 로딩 실패");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB 연결 실패");
        }
        System.out.println("성공");
    }
}