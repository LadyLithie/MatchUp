package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.lithie.matchup.database.base.BaseDAO;
import fr.lithie.matchup.entities.Administrator;
import fr.lithie.matchup.entities.Candidate;
import fr.lithie.matchup.entities.Company;
import fr.lithie.matchup.entities.Role;
import fr.lithie.matchup.entities.User;
import fr.lithie.matchup.entities.Validity;
import fr.lithie.matchup.entities.base.BaseEntity;

public class UserDAO extends BaseDAO {
	public static final String TABLE = "user";
	public static final String ID = "id";
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String VALID = "valid";
	public static final String CREA_DATE = "created_at";
	public static final String UPDATE = "updated_at";
	public static final String ADDRESS = "location_id";

	public UserDAO() {
		super(TABLE,ID);
	}

	public UserDAO(String table, String id) {
		super(table, id);
	}

	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		User user = null;
		
		try {
			switch (Role.valueOf(resultSet.getString(ROLE))) {
			case COMPANY:
				user = new Company();
				break;
			case CANDIDATE:
				user = new Candidate();
				break;
			case ADMIN:
				user = new Administrator();
				break;
			}
			user.setId(resultSet.getDouble(ID));
			user.setLogin(resultSet.getString(LOGIN));
			user.setPassword(resultSet.getString(PASSWORD));
			user.setValid(Validity.valueOf(resultSet.getString(VALID)));
			user.setCreated_at(resultSet.getString(CREA_DATE));
			user.setUpdated_at(resultSet.getString(UPDATE));
		} catch (SQLException e) {
			user = null;
			e.printStackTrace();
		}
		
		//Missing function to get Location
		
		return user;
	}

	@Override
	public String parseToString(BaseEntity item) {
		String result = "null,";
		User user = (User) item;

		result += "'" + user.getLogin() + "',";
		result += "'" + user.getPassword() + "',";
		result += "'" + user.getRole() + "',";
		result += "'" + user.getValid() + "',";
		result += "NOW(),";
		result += "null,";
		result += "'" + user.getAddress().getId() + "'";

		return result;
	}

	@Override
	public String parseUpdateToString(BaseEntity item) {
		String result = "";
		User user = (User) item;
		
		
		result += LOGIN + " = '" + user.getLogin() + "',";
		result += PASSWORD + " = '" + user.getPassword() + "',";
		result += ROLE + " = '" + user.getRole() + "',";
		result += VALID + " = '" + user.getValid() + "',";
		result += UPDATE + " = NOW(),";
		result += ADDRESS + " = '" + user.getAddress().getId() + "'";

		return result;
	}
	
	public User connection(String login, String password) {
		User user = null;
		//Test dans la table Entreprise
		ResultSet rs = executeRequest("SELECT * FROM " + TABLE + " WHERE " + LOGIN +" = '" + login + "' AND " + PASSWORD + " = '" + password + "'");
		try {
			if (rs.next()) {
				switch (Role.valueOf((rs.getString(ROLE)))) {
				case COMPANY :
					user = new Company();
					user.setId(rs.getDouble(CompanyDAO.ID));
					CompanyDAO companyDAO = new CompanyDAO();
					user = (Company) companyDAO.get(user.getId());
					
					break;
				case ADMIN :
					user = new Administrator();
					user.setId(rs.getDouble(CompanyDAO.ID));
					AdministratorDAO aDao = new AdministratorDAO();
					user = (Administrator) aDao.get(user.getId());
					
					break;
				case CANDIDATE :
					user = new Candidate();
					user.setId(rs.getDouble(CompanyDAO.ID));
					CandidateDAO cDao = new CandidateDAO();
					user = (Candidate) cDao.get(user.getId());
					
					break;

				default:
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
}
