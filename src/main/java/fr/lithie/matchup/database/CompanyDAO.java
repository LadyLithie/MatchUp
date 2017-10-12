/**
 * 
 */

package fr.lithie.matchup.database;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import fr.lithie.matchup.entities.Company;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.Role;
import fr.lithie.matchup.entities.Validity;
import fr.lithie.matchup.entities.base.BaseEntity;

public class CompanyDAO extends UserDAO {

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
	
	public CompanyDAO() {
		super(TABLE, ID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		Company e = new Company();

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
		Company company = (Company) item;
		
		res += "'"+company.getName()+"',";
		res += "'"+company.getPhone()+"',";
		res += "'"+company.getAddress()+"',";
		res += "'"+company.getCity()+"',";
		res += "'"+company.getWebsite()+"',";
		res += "'"+company.getEmail()+"',";
		res += "'"+company.getPresentation()+"',";
		res += "'"+company.getAvatar()+"',";
		res += "'"+company.getTwitter()+"',";
		res += "'"+company.getLinkedin()+"',";
		res += "'"+company.getActivity()+"',";
		res += "'"+company.getRole()+"',";
		res += "'"+company.getLogin()+"',";
 		res += "'"+company.getPassword()+"',";
		res += (company.getValid() == null ? "'FALSE'" : "'" + company.getValid() + "'" );
		
		return res;
	}

	@Override
	public String parseUpdateToString(BaseEntity item) {
		String res = "";
		Company company = (Company) item;
		
		res += NAME + " = '"+company.getName()+"',";
		res += PHONE + " = '"+company.getPhone()+"',";
		res += ADDRESS + " = '"+company.getAddress()+"',";
		res += CITY + " = '"+company.getCity()+"',";
		res += WEBSITE + " = '"+company.getWebsite()+"',";
		res += MAIL + " = '"+company.getEmail()+"',";
		res += PRESENTATION + " = '"+company.getPresentation()+"',";
		res += LOGO + " = '"+company.getAvatar()+"',";
		res += TWITTER + " = '"+company.getTwitter()+"',";
		res += LINKEDIN + " = '"+company.getLinkedin()+"',";
		res += ACTIVITY + " = '"+company.getActivity()+"',";
		res += ROLE + " = '"+company.getRole()+"',";
		res += LOGIN + " = '"+company.getLogin()+"',";
		res += PASSWORD + " = '"+company.getPassword()+"',";
		res += VALID + " = "+ (company.getValid()!=null ? "'"+company.getValid() + "'" : "'FALSE'");
		
		return res;
	}

	/**
	 * Retrieve the headhunters working with the company and add them to the entity
	 * @param company
	 * @return the modified enterprise entity
	 */
	public Company getHeadhunters(Company company) {
		//Search all rows where ID_ENTERPRISE = enterprise ID
		ResultSet rs = executeRequest(
				"SELECT * FROM " + ENTERPRISE_HEADHUNTER + " WHERE " + ID_ENTERPRISE + " = " + company.getId());
		
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
			company.getAssociates().add((Headhunter) hDao.get(id));
		}

		return company;
	}

	/**
	 * Add all the associates of enterprise to the DB
	 * @param company
	 * @return int = 
	 * 				number of inserted headhunters
	 */
	public int insertHeadhunter(Company company) {
		int result = 0;
		deleteHeadhunter(company);
		for (Headhunter headhunter : company.getAssociates()) {
			result += executeRequestUpdate("INSERT INTO " + ENTERPRISE_HEADHUNTER + " VALUES(" + company.getId()
					+ "," + headhunter.getId() + ")");
		}
		return result;
	}

	/**
	 * Delete all the associates of enterprise
	 * @param company
	 * @return
	 */
	public int deleteHeadhunter(Company company) {
		return executeRequestUpdate(
				"DELETE FROM " + ENTERPRISE_HEADHUNTER + " WHERE " + ID_ENTERPRISE + " = " + company.getId());
	}

}
