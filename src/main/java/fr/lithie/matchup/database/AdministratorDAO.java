package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.lithie.matchup.entities.Administrator;
import fr.lithie.matchup.entities.Role;
import fr.lithie.matchup.entities.Validity;
import fr.lithie.matchup.entities.base.BaseEntity;

public class AdministratorDAO extends UserDAO {
	
	public static final String TABLE ="administrator";
	public static final String ID ="id";
	public static final String LASTNAME = "lastname";
	public static final String FIRSTNAME = "firstname";
	public static final String MAIL = "mail";
	public static final String PHONE = "phone";
	public static final String AVATAR = "image";
	private UserDAO uDao = new UserDAO();
	
	public AdministratorDAO() {
		super(TABLE, ID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		Administrator admin = new Administrator();
		UserDAO uDao = new UserDAO();
		
		try {
			admin = (Administrator) uDao.get(resultSet.getDouble(ID));
			admin.setLastname(resultSet.getString(LASTNAME));
			admin.setFirstname(resultSet.getString(FIRSTNAME));
			admin.setEmail(resultSet.getString(MAIL));
			admin.setPhone(resultSet.getString(PHONE));
			admin.setAvatar(resultSet.getBlob(AVATAR));
			admin.setName(admin.getFirstname() + " " + admin.getLastname());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			admin = null;
		}
		
		return admin;
	}

	@Override
	public String parseToString(BaseEntity item) {
		Administrator admin = (Administrator) item;

		uDao.insert(admin);
		//might need test to confirm user insertion?
		String res = ""+admin.getId()+",";
		
		res += "'"+admin.getLastname()+"',";
		res += "'"+admin.getFirstname()+"',";
		res += "'"+admin.getEmail()+"',";
		res += "'"+admin.getPhone()+"',";
		res += "null";

		return res;
	}

	@Override
	public String parseUpdateToString(BaseEntity item) {
		String res = "";
		uDao.update(item);

		Administrator admin = (Administrator) item;
				
		res += FIRSTNAME + " = '"+admin.getFirstname()+"',";
		res += LASTNAME + " = '"+admin.getLastname()+"',";
		res += MAIL + " = '"+admin.getEmail()+"',";
		res += PHONE + " = '"+admin.getPhone()+"',";
		res += AVATAR + " = '"+admin.getAvatar()+"'";

		return res;
	}
	
	
}
