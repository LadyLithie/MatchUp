/**
 * 
 */

package fr.lithie.matchup.database;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import fr.lithie.matchup.entities.Enterprise;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.Role;
import fr.lithie.matchup.entities.Validity;
import fr.lithie.matchup.entities.base.BaseEntity;

public class EnterpriseDAO extends UserDAO {

	public static final String TABLE = "enterprise";
	public static final String ID = "id_enterprise";
	public static final String NAME = "name_enterprise";
	public static final String PHONE = "phone_enterprise";
	public static final String ADDRESS = "address_enterprise";
	public static final String CITY = "city_enterprise";
	public static final String WEBSITE = "website_enterprise";
	public static final String MAIL = "mail_enterprise";
	public static final String PRESENTATION ="presentation_enterprise";
	public static final String LOGO ="logo_enterprise";
	public static final String TWITTER ="twitter_enterprise";
	public static final String LINKEDIN ="linkedin_enterprise";
	public static final String ACTIVITY ="activityfield_enterprise";
	public static final String ROLE ="role_enterprise";
	public static final String LOGIN ="login_enterprise";
	public static final String PASSWORD="password_enterprise";
	public static final String VALID="valid";
	
	public static final String ENTERPRISE_HEADHUNTER ="headhunter_enterprise";
	public static final String ID_ENTERPRISE ="enterprise_id";
	public static final String ID_HEADHUNTER ="headhunter_id";
	
	public EnterpriseDAO() {
		super(TABLE, ID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		Enterprise e = new Enterprise();

		try {
			e.setId(resultSet.getDouble(ID));
			e.setName(resultSet.getString(NAME));
			e.setPhone(resultSet.getString(PHONE));
			e.setAddress(resultSet.getString(ADDRESS));
			e.setCity(resultSet.getString(CITY));
			e.setWebsite(resultSet.getString(WEBSITE));
			e.setEmail(resultSet.getString(MAIL));
			e.setPresentation(resultSet.getString(PRESENTATION));
//			e.setAvatar((Blob) resultSet.getBinaryStream(LOGO));
			e.setAvatar(resultSet.getBlob(LOGO));
			e.setTwitter(resultSet.getString(TWITTER));
			e.setLinkedin(resultSet.getString(LINKEDIN));
			e.setActivity(resultSet.getString(ACTIVITY));
			if (resultSet.getString(ROLE).equals("enterprise")) {
				e.setRole(Role.COMPANY);
			} else {
				e.setRole(Role.valueOf(resultSet.getString(ROLE)));
			}
			e.setLogin(resultSet.getString(LOGIN));
			e.setPassword(resultSet.getString(PASSWORD));
			e.setValid(Validity.valueOf(resultSet.getString(VALID)));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			e = null;
		}

		return e;
	}

	@Override
	public String parseToString(BaseEntity item) {
		String res = "null,";
		Enterprise enterprise = (Enterprise) item;
		
		res += "'"+enterprise.getName()+"',";
		res += "'"+enterprise.getPhone()+"',";
		res += "'"+enterprise.getAddress()+"',";
		res += "'"+enterprise.getCity()+"',";
		res += "'"+enterprise.getWebsite()+"',";
		res += "'"+enterprise.getEmail()+"',";
		res += "'"+enterprise.getPresentation()+"',";
		res += "'"+enterprise.getAvatar()+"',";
		res += "'"+enterprise.getTwitter()+"',";
		res += "'"+enterprise.getLinkedin()+"',";
		res += "'"+enterprise.getActivity()+"',";
		res += "'"+enterprise.getRole()+"',";
		res += "'"+enterprise.getLogin()+"',";
 		res += "'"+enterprise.getPassword()+"',";
		res += (enterprise.getValid() == null ? "'FALSE'" : "'" + enterprise.getValid() + "'" );
		
		return res;
	}

	@Override
	public String parseUpdateToString(BaseEntity item) {
		String res = "";
		Enterprise enterprise = (Enterprise) item;
		
		res += NAME + " = '"+enterprise.getName()+"',";
		res += PHONE + " = '"+enterprise.getPhone()+"',";
		res += ADDRESS + " = '"+enterprise.getAddress()+"',";
		res += CITY + " = '"+enterprise.getCity()+"',";
		res += WEBSITE + " = '"+enterprise.getWebsite()+"',";
		res += MAIL + " = '"+enterprise.getEmail()+"',";
		res += PRESENTATION + " = '"+enterprise.getPresentation()+"',";
		res += LOGO + " = '"+enterprise.getAvatar()+"',";
		res += TWITTER + " = '"+enterprise.getTwitter()+"',";
		res += LINKEDIN + " = '"+enterprise.getLinkedin()+"',";
		res += ACTIVITY + " = '"+enterprise.getActivity()+"',";
		res += ROLE + " = '"+enterprise.getRole()+"',";
		res += LOGIN + " = '"+enterprise.getLogin()+"',";
		res += PASSWORD + " = '"+enterprise.getPassword()+"',";
		res += VALID + " = "+ (enterprise.getValid()!=null ? "'"+enterprise.getValid() + "'" : "'FALSE'");
		
		return res;
	}

	/**
	 * Retrieve the headhunters working with the company and add them to the entity
	 * @param enterprise
	 * @return the modified enterprise entity
	 */
	public Enterprise getHeadhunters(Enterprise enterprise) {
		//Search all rows where ID_ENTERPRISE = enterprise ID
		ResultSet rs = executeRequest(
				"SELECT * FROM " + ENTERPRISE_HEADHUNTER + " WHERE " + ID_ENTERPRISE + " = " + enterprise.getId());
		
		List<Double> headhuntersId = new ArrayList<Double>();
		//Create the list of ID_HEADHUNTER
		try {
			while (rs.next()) {
				headhuntersId.add(rs.getDouble(ID_HEADHUNTER));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Retrieve for each id of the list the representation of the entity
		HeadhunterDAO hDao = new HeadhunterDAO();

		for (Double id : headhuntersId) {
			enterprise.getAssociates().add((Headhunter) hDao.get(id));
		}

		return enterprise;
	}

	/**
	 * Add all the associates of enterprise to the DB
	 * @param enterprise
	 * @return int = 
	 * 				number of inserted headhunters
	 */
	public int insertHeadhunter(Enterprise enterprise) {
		int result = 0;
		deleteHeadhunter(enterprise);
		for (Headhunter headhunter : enterprise.getAssociates()) {
			result += executeRequestUpdate("INSERT INTO " + ENTERPRISE_HEADHUNTER + " VALUES(" + enterprise.getId()
					+ "," + headhunter.getId() + ")");
		}
		return result;
	}

	/**
	 * Delete all the associates of enterprise
	 * @param enterprise
	 * @return
	 */
	public int deleteHeadhunter(Enterprise enterprise) {
		return executeRequestUpdate(
				"DELETE FROM " + ENTERPRISE_HEADHUNTER + " WHERE " + ID_ENTERPRISE + " = " + enterprise.getId());
	}

}
