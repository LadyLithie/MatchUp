package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.lithie.matchup.entities.Enterprise;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.Role;
import fr.lithie.matchup.entities.Validity;
import fr.lithie.matchup.entities.base.BaseEntity;

public class HeadhunterDAO extends UserDAO {
	
	public static final String TABLE = "headhunter";
	public static final String ID = "id_headhunter";
	public static final String LASTNAME = "lastname_headhunter";
	public static final String FIRSTNAME = "firstname_headhunter";
	public static final String PHONE = "phone_headhunter";
	public static final String MAIL = "mail_headhunter";
	public static final String PICTURE = "picture_headhunter";
	public static final String TWITTER = "twitter_headhunter";
	public static final String LINKEDIN = "linkedin_headhunter";
	public static final String PRESENTATION ="presentation_headhunter";
	public static final String ROLE ="role_headhunter";
	public static final String LOGIN ="login_headhunter";
	public static final String PASSWORD="password_headhunter";
	public static final String VALID = "valid";
	
	public static final String ENTERPRISE_HEADHUNTER ="headhunter_enterprise";
	public static final String ID_ENTERPRISE ="enterprise_id";
	public static final String ID_HEADHUNTER ="headhunter_id";

	/**
	 * Constructor
	 */
	public HeadhunterDAO() {
		super(TABLE, ID);
	}

	/*
	 * (non-Javadoc)
	 * @see fr.yas.matchup.database.RegisteredUserDAO#parseToObject(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parseToObject(ResultSet rs) {
		Headhunter headhunter = new Headhunter();

		try {
			headhunter.setId(rs.getDouble(ID));
			headhunter.setLastname(rs.getString(LASTNAME));
			headhunter.setFirstname(rs.getString(FIRSTNAME));
			headhunter.setPhone(rs.getString(PHONE));
			headhunter.setEmail(rs.getString(MAIL));
			headhunter.setTwitter(rs.getString(TWITTER));
			headhunter.setLinkedin(rs.getString(LINKEDIN));
			headhunter.setPresentation(rs.getString(PRESENTATION));
			if (rs.getString(ROLE).equals("headhunter")) {
				headhunter.setRole(Role.HEADHUNTER);
			} else {
				headhunter.setRole(Role.valueOf(rs.getString(ROLE)));
			}
			headhunter.setLogin(rs.getString(LOGIN));
			headhunter.setPassword(rs.getString(PASSWORD));
			headhunter.setName(headhunter.getFirstname() + " " + headhunter.getLastname());
			headhunter.setValid(Validity.valueOf(rs.getString(VALID)));
		} catch (SQLException e) {
			e.printStackTrace();
			headhunter = null;
		}

		return headhunter;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.yas.matchup.database.RegisteredUserDAO#parseToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseToString(BaseEntity item) {
		String result = "null,";
		Headhunter headhunter = (Headhunter) item;

		result += "'" + headhunter.getLastname() + "',";
		result += "'" + headhunter.getFirstname() + "',";
		result += "'" + headhunter.getPhone() + "',";
		result += "'" + headhunter.getEmail() + "',";
		result += "'" + headhunter.getAvatar() + "',";
		result += "'" + headhunter.getTwitter() + "',";
		result += "'" + headhunter.getLinkedin() + "',";
		result += "'" + headhunter.getPresentation() +"',";
		result += "'" + headhunter.getLogin() + "',";
		result += "'" + headhunter.getPassword() + "',";
		result += "'" + headhunter.getRole() + "',";
		result += "'" + headhunter.getValid() + "'";

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.yas.matchup.database.RegisteredUserDAO#parseUpdateToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseUpdateToString(BaseEntity item) {
		String res = "";
		Headhunter headhunter = (Headhunter) item;
		
		res += LASTNAME + " = '" + headhunter.getLastname() + "',";
		res += FIRSTNAME + " = '" + headhunter.getFirstname() + "',";
		res += PHONE + " = '"+ headhunter.getPhone()+"',";
		res += MAIL + " = '"+ headhunter.getEmail()+"',";
		res += PICTURE + " = '"+ headhunter.getAvatar()+"',";
		res += TWITTER + " = '"+ headhunter.getTwitter()+"',";
		res += LINKEDIN + " = '"+ headhunter.getLinkedin()+"',";
		res += PRESENTATION + " = '"+ headhunter.getPresentation()+"',";
		res += LOGIN + " = '"+ headhunter.getLogin()+"',";
		res += PASSWORD + " = '"+ headhunter.getPassword()+"',";
		res += ROLE + " = '"+ headhunter.getRole()+"',";
		res += ROLE + " = '"+ headhunter.getValid()+"'";
		
		return res;
	}
	
//	@Override
//	public List<BaseEntity> get() {
//		List<BaseEntity> associates = new ArrayList<BaseEntity>();
//		ResultSet rSet = executeRequest("SELECT * FROM HEADHUNTER_ENTERPRISE WHERE HEADHUNTER_ID " + " = " + ID);
//		
//		try {
//			while (rSet.next()) {
//				associates.add(parseToObject(rSet));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return associates;
//	}

	/**
	 * Retrieve the companies which whom the headhunter works and add them to the entity
	 * @param headhunter
	 * @return the modified headhunter entity
	 */
	public Headhunter getAssociates(Headhunter headhunter) {
		ResultSet rs = executeRequest(
				"SELECT * FROM " + ENTERPRISE_HEADHUNTER + " WHERE " + ID_HEADHUNTER + " = " + headhunter.getId());
		List<Double> enterpriseId = new ArrayList<Double>();
		try {
			while (rs.next()) {
				enterpriseId.add(rs.getDouble(ID_ENTERPRISE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		EnterpriseDAO enterpriseDAO = new EnterpriseDAO();

		for (Double id : enterpriseId) {
			headhunter.getAssociates().add((Enterprise) enterpriseDAO.get(id));
		}

		return headhunter;
	}

	/**
	 * Add all the associates of headhunter to the DB
	 * @param headhunter
	 * @return int = 
	 * 				number of inserted associates
	 */
	public int insertAssociates(Headhunter headhunter) {
		int result = 0;
		deleteAssociates(headhunter);
		for (Enterprise enterprise : headhunter.getAssociates()) {
			result += executeRequestUpdate("INSERT INTO " + ENTERPRISE_HEADHUNTER + " VALUES(" + enterprise.getId()
					+ "," + headhunter.getId() + ")");
		}
		return result;
	}

	/**
	 * Delete all the associates of headhunter from the DB
	 * @param headhunter
	 * @return
	 */
	public int deleteAssociates(Headhunter headhunter) {
		return executeRequestUpdate(
				"DELETE FROM " + ENTERPRISE_HEADHUNTER + " WHERE " + ID_ENTERPRISE + " = " + headhunter.getId());
	}

}
