package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.lithie.matchup.entities.Administrator;
import fr.lithie.matchup.entities.Role;
import fr.lithie.matchup.entities.Validity;
import fr.lithie.matchup.entities.base.BaseEntity;

public class AdministratorDAO extends UserDAO {
	
	public static final String TABLE ="administrator";
	public static final String ID ="id_admin";
	public static final String LASTNAME = "lastname_admin";
	public static final String FIRSTNAME = "firstname_admin";
	public static final String MAIL = "mail_admin";
	public static final String PHONE = "phone_admin";
	public static final String AVATAR = "logo_admin";
	public static final String ROLE = "role_admin";
	public static final String LOGIN = "login_admin";
	public static final String PASSWORD = "password_admin";
	public static final String VALID = "valid";
	
	
	public AdministratorDAO() {
		super(TABLE, ID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		Administrator admin = new Administrator();
		
		try {
			admin.setId(resultSet.getDouble(ID));
			admin.setLastname(resultSet.getString(LASTNAME));
			admin.setFirstname(resultSet.getString(FIRSTNAME));
			admin.setEmail(resultSet.getString(MAIL));
			admin.setPhone(resultSet.getString(PHONE));
			admin.setAvatar(resultSet.getBlob(AVATAR));
			if (resultSet.getString(ROLE).equals("admin")) {
				admin.setRole(Role.ADMIN);
			} else {
				admin.setRole(Role.valueOf(resultSet.getString(ROLE)));
			}
			admin.setLogin(resultSet.getString(LOGIN));
			admin.setPassword(resultSet.getString(PASSWORD));
			admin.setName(admin.getFirstname() + " " + admin.getLastname());
			admin.setValid(Validity.valueOf(resultSet.getString(VALID)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			admin = null;
		}
		
		return admin;
	}

	@Override
	public String parseToString(BaseEntity item) {
		String res = "null,";
		Administrator admin = (Administrator) item;
		
		res += "'"+admin.getLastname()+"',";
		res += "'"+admin.getFirstname()+"',";
		res += "'"+admin.getEmail()+"',";
		res += "'"+admin.getPhone()+"',";
		res += "'"+admin.getRole()+"',";
		res += "'"+admin.getLogin()+"',";
		res += "'"+admin.getPassword()+"',";
		res += "'"+admin.getValid()+"'";

		return res;
	}

	@Override
	public String parseUpdateToString(BaseEntity item) {
		String res = "";
		Administrator admin = (Administrator) item;
		
		res += FIRSTNAME + " = '"+admin.getFirstname()+"',";
		res += LASTNAME + " = '"+admin.getLastname()+"',";
		res += MAIL + " = '"+admin.getEmail()+"',";
		res += PHONE + " = '"+admin.getPhone()+"',";
		res += ROLE + " = '"+admin.getRole()+"',";
		res += LOGIN + " = '"+admin.getLogin()+"',";
		res += PASSWORD + " = '"+admin.getPassword()+"',";
		res += VALID + " = '"+admin.getValid()+"'";

		return res;
	}
	
	
}
