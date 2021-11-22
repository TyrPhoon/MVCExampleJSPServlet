package Model.Bo;

import java.util.ArrayList;

import Model.Bean.Phongban;
import Model.DAO.Dao_NV;
import Model.DAO.Dao_PB;

public class BO_PB {
	Dao_NV checklogindao = new Dao_NV();
	Dao_PB Daopb = new Dao_PB();

	public ArrayList<Phongban> GetAllPB() {
		return checklogindao.GetAllPB();
	}

	public Phongban GetPBbByIDPB(String IDPB) {
		return Daopb.GetPBByIDPB(IDPB);
	}

	public void UpdatePB(Phongban PB) {
		Daopb.UpdatePB(PB);
	}
}
