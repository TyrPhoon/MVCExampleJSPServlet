package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Bean.Nhanvien;
import Model.Bean.Phongban;

public class Dao_PB {
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

	public Phongban GetPBByIDPB(String IDPB) {
		try {
			con = getConnection();
			// Statement st = con.createStatement();
			PreparedStatement ps;
			String sql = "Select * from phongban where IDPB = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, IDPB);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Phongban w = new Phongban();
				w.setName(rs.getString("TenPB"));
				w.setIDPB(rs.getString("IDPB"));
				w.setMota(rs.getString("Mota"));
				return w;
			} else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	public void UpdatePB(Phongban pb) {

		try {
			con = getConnection();
			PreparedStatement ps;
			String sql = "update phongban set TenPB =?, Mota = ? where IDPB =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getMota());
			ps.setString(3, pb.getIDPB());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}
}
