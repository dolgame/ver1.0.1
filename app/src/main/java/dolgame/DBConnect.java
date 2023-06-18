package dolgame;

import java.sql.*;

public class DBConnect {
	public static Connection connection;
	public static PreparedStatement preparedStatement;
	public static ResultSet resultSet;
	public static Statement statement;
	public static int cc = 0;

	public static void dbChecking() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dolgameDB";
		String userId = "root";
//		String userPassword = "1234";
		String userPassword = "root"; //집에서 할때
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
		System.out.println("DB 연결 성공"); //테스트용 코드
	}
	public static int cardCount(){
		String sql = "select count(*) from cards";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			cc = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cc;
	}


}
