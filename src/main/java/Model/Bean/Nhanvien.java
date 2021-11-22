package Model.Bean;

public class Nhanvien {
	private String IDNV;
	private String Name;
	private String IDPB;
	private String DiaChi;

	public Nhanvien() {

	}

	public Nhanvien(String id, String name, String idpb, String DC) {
		this.IDNV = id;
		this.Name = name;
		this.IDPB = idpb;
		this.DiaChi = DC;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getIDPB() {
		return IDPB;
	}

	public void setIDPB(String iDPB) {
		IDPB = iDPB;
	}

	public String getIDNV() {
		return IDNV;
	}

	public void setIDNV(String iDNV) {
		IDNV = iDNV;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
