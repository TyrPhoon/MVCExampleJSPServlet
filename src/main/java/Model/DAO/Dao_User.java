package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao_User {

	private static Connection con;
	private ResultSet rs;
	private PreparedStatement ps;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dulieu";
			String user = "root";
			String p = "";
			con = (Connection) DriverManager.getConnection(url, user, p);
			return con;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isExistUser(String username, String password) {
		try {
			con = getConnection();
			PreparedStatement ps;
			String sql = "Select * from admin where username =? and password =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}

	}
}
