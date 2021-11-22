package Model.Bo;

import Model.DAO.Dao_User;

public class CheckLoginBo {

	Dao_User checklogindao = new Dao_User();

	public boolean isValidUser(String Username, String password) {
		return checklogindao.isExistUser(Username, password);
	}

}
