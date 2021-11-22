package Model.Bean;

public class Phongban {
	private String IDPB;
	private String Name;
	private String Mota;

	public Phongban() {

	}

	public Phongban(String idpb, String name, String mota) {
		this.IDPB = idpb;
		this.Name = name;
		this.Mota = mota;
	}

	public String getMota() {
		return Mota;
	}

	public void setMota(String mota) {
		Mota = mota;
	}

	public String getIDPB() {
		return IDPB;
	}

	public void setIDPB(String iDPB) {
		IDPB = iDPB;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
