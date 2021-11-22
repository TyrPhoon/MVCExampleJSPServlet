package Model.Bo;

import java.util.ArrayList;

import Model.Bean.Nhanvien;
import Model.DAO.Dao_NV;

public class BO_NV {
	Dao_NV checklogindao = new Dao_NV();

	public ArrayList<Nhanvien> GetAllNV() {
		return checklogindao.GetListNV();
	}

	public Nhanvien GetNVByID(String IDNV) {
		return checklogindao.GetNVByID(IDNV);
	}

	public void AddNV(Nhanvien nv) {
		checklogindao.AddNV(nv);
	}

	public void UpdateNV(Nhanvien nv) {
		checklogindao.UPdateNV(nv);
	}

	public void DeleteNV(String IDNV) {
		checklogindao.DeleteNV(IDNV);
	}

	public ArrayList<Nhanvien> SearchNV(String query) {
		return checklogindao.SearchNV(query);
	}

	public void DeleteNVMulti(String[] IDNV) {
		checklogindao.DeleteMulptiNV(IDNV);
	}

	public ArrayList<Nhanvien> GetNVByIDPB(String IDPB) {
		return checklogindao.GetNVByIDPB(IDPB);
	}
}
