package maven.project.JavaRoadmap;

import java.sql.*;


public class JDBCTry {

	public static void main(String... s) {
		try {
			Connection conn = null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/freedb_carsrent","root", "");
			Statement stmt =conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		try {
			Connection conn = null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/freedb_carsrent","root", "");
			
			String sql = "INSERT INTO user (user_role_id,first_name, last_name, password, email, phone) VALUES ((select user_role_id from user_roles where user_role='Guest'), ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "Oleg");
			preparedStatement.setString(2, "Ungur");
			preparedStatement.setString(3, "1233567890");
			preparedStatement.setString(4, "Oleg@gmail.com");
			preparedStatement.setString(5, "065534234");
			
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
