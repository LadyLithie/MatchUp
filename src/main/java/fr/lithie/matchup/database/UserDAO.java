package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.lithie.matchup.database.base.BaseDAO;
import fr.lithie.matchup.entities.Administrator;
import fr.lithie.matchup.entities.Candidate;
import fr.lithie.matchup.entities.Company;
import fr.lithie.matchup.entities.Headhunter;
import fr.lithie.matchup.entities.User;
import fr.lithie.matchup.entities.base.BaseEntity;

public class UserDAO extends BaseDAO {

	public UserDAO() {
		super("NA", "NA");
	}

	public UserDAO(String table, String id) {
		super(table, id);
	}

	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseToString(BaseEntity item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseUpdateToString(BaseEntity item) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User connection(String login, String password) {
		User user = null;
		//Test dans la table Entreprise
		ResultSet rs = executeRequest("SELECT * FROM " + CompanyDAO.TABLE + " WHERE " + CompanyDAO.LOGIN +" = '" + login + "' AND " + CompanyDAO.PASSWORD + " = '" + password + "'");
		try {
			if (rs.next()) {
				user = new Company();
				user.setId(rs.getDouble(CompanyDAO.ID));
				CompanyDAO companyDAO = new CompanyDAO();
				user = (Company) companyDAO.get(user.getId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//Test dans la table Candidate
		rs = executeRequest("SELECT * FROM " + CandidateDAO.TABLE + " WHERE " + CandidateDAO.LOGIN +" = '" +  login + "' AND " + CandidateDAO.PASSWORD + " = '" + password + "'");
		try {
			if (rs.next()) {
				user = new Candidate();
				user.setId(rs.getDouble(CandidateDAO.ID));
				CandidateDAO candidateDAO = new CandidateDAO();
				user = (Candidate) candidateDAO.get( user.getId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Test dans la table Administrator
		rs = executeRequest("SELECT * FROM " + AdministratorDAO.TABLE + " WHERE " + AdministratorDAO.LOGIN +" = '" + login + "' AND " + AdministratorDAO.PASSWORD + " = '" + password + "'");
		try {
			if (rs.next()) {
				user = new Administrator();
				user.setId(rs.getDouble(AdministratorDAO.ID));
				AdministratorDAO administratorDAO = new AdministratorDAO();
				user = (Administrator) administratorDAO.get(user.getId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
}
