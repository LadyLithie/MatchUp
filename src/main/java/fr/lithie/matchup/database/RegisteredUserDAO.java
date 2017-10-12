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

public class RegisteredUserDAO extends BaseDAO {

	public RegisteredUserDAO() {
		super("NA", "NA");
	}

	public RegisteredUserDAO(String table, String id) {
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
		ResultSet rs = executeRequest("SELECT * FROM " + EnterpriseDAO.TABLE + " WHERE " + EnterpriseDAO.LOGIN +" = '" + login + "' AND " + EnterpriseDAO.PASSWORD + " = '" + password + "'");
		try {
			if (rs.next()) {
				user = new Company();
				user.setId(rs.getDouble(EnterpriseDAO.ID));
				EnterpriseDAO enterpriseDAO = new EnterpriseDAO();
				user = (Company) enterpriseDAO.get(user.getId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Test dans la table Headhunter
		rs = executeRequest("SELECT * FROM " + HeadhunterDAO.TABLE + " WHERE " + HeadhunterDAO.LOGIN +" = '" + login + "' AND " + HeadhunterDAO.PASSWORD + " = '" + password + "'");
		try {
			if (rs.next()) {
				user = new Headhunter();
				user.setId(rs.getDouble(HeadhunterDAO.ID));
				HeadhunterDAO headhunterDAO = new HeadhunterDAO();
				user = (Headhunter) headhunterDAO.get(user.getId());
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
