package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Bean.Nhanvien;
import Model.Bean.Phongban;

public class Dao_NV {
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

	public ArrayList<Nhanvien> GetListNV() {
		ArrayList<Nhanvien> arraynv = new ArrayList<>();
		try {
			con = getConnection();
			Statement st = con.createStatement();
//			PreparedStatement ps;
			String sql = "Select * from nhanvien";
//			ps = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Nhanvien w = new Nhanvien();
				w.setName(rs.getString("HoTen"));
				w.setDiaChi(rs.getString("DiaChi"));
				w.setIDNV(rs.getString("IDNV"));
				w.setIDPB(rs.getString("IDPB"));
				arraynv.add(w);
			}

		} catch (Exception e) {

		}
		return arraynv;
	}

	public Nhanvien GetNVByID(String IDNV) {
		try {
			con = getConnection();
			// Statement st = con.createStatement();
			PreparedStatement ps;
			String sql = "Select * from nhanvien where IDNV = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, IDNV);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Nhanvien w = new Nhanvien();
				w.setName(rs.getString("HoTen"));
				w.setDiaChi(rs.getString("DiaChi"));
				w.setIDNV(rs.getString("IDNV"));
				w.setIDPB(rs.getString("IDPB"));
				return w;
			} else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	public void AddNV(Nhanvien nv) {
		try {
			con = getConnection();
			PreparedStatement ps;
			String sql = "insert into nhanvien value (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, nv.getIDNV());
			ps.setString(2, nv.getName());
			ps.setString(3, nv.getIDPB());
			ps.setString(4, nv.getDiaChi());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void UPdateNV(Nhanvien nv) {
		try {
			con = getConnection();
			PreparedStatement ps;
			String sql = "update nhanvien set Hoten =?, IDPB = ?, DiaChi = ? where IDNV =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, nv.getName());
			ps.setString(2, nv.getIDPB());
			ps.setString(3, nv.getDiaChi());
			ps.setString(4, nv.getIDNV());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void DeleteNV(String idnv) {
		try {
			con = getConnection();
			PreparedStatement ps;
			String sql = "delete from nhanvien where IDNV = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, idnv);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public ArrayList<Nhanvien> SearchNV(String query) {
		ArrayList<Nhanvien> arraynv = new ArrayList<>();
		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Nhanvien w = new Nhanvien();
				w.setName(rs.getString("HoTen"));
				w.setDiaChi(rs.getString("DiaChi"));
				w.setIDNV(rs.getString("IDNV"));
				w.setIDPB(rs.getString("IDPB"));
				arraynv.add(w);
			}
		} catch (Exception e) {

		}
		return arraynv;
	}

	public void DeleteMulptiNV(String[] idnv) {
		try {
			con = getConnection();
			PreparedStatement ps;
			for (String s : idnv) {
				String sql = "delete from nhanvien where IDNV = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, s);
				ps.executeUpdate();
			}
		} catch (Exception e) {

		}
	}

	public ArrayList<Phongban> GetAllPB() {
		ArrayList<Phongban> arraypb = new ArrayList<>();
		try {
			con = getConnection();
			Statement st = con.createStatement();
//			PreparedStatement ps;
			String sql = "Select * from phongban";
//			ps = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Phongban w = new Phongban();
				w.setIDPB(rs.getString("IDPB"));
				w.setName(rs.getString("TenPB"));
				w.setMota(rs.getString("Mota"));
				arraypb.add(w);
			}

		} catch (Exception e) {

		}
		return arraypb;
	}

	public ArrayList<Nhanvien> GetNVByIDPB(String IDPB) {
		ArrayList<Nhanvien> arraynv = new ArrayList<>();
		try {
			con = getConnection();
			// Statement st = con.createStatement();
			PreparedStatement ps;
			String sql = "Select * from nhanvien where IDPB = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, IDPB);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Nhanvien w = new Nhanvien();
				w.setName(rs.getString("HoTen"));
				w.setDiaChi(rs.getString("DiaChi"));
				w.setIDNV(rs.getString("IDNV"));
				w.setIDPB(rs.getString("IDPB"));
				arraynv.add(w);
			}
		} catch (Exception e) {

		}
		return arraynv;
	}
}
