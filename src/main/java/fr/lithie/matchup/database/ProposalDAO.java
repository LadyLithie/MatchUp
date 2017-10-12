/**
 * 
 */
package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.lithie.matchup.database.base.BaseDAO;
import fr.lithie.matchup.entities.ContractType;
import fr.lithie.matchup.entities.Company;
import fr.lithie.matchup.entities.Job;
import fr.lithie.matchup.entities.Skill;
import fr.lithie.matchup.entities.base.BaseEntity;

/**
 * @author Audrey
 *
 */
public class ProposalDAO extends BaseDAO {
		public static final String TABLE = "job";
		public static final String ID = "id_job";
		public static final String NAME = "title_job";
		public static final String PRESENTATION = "presentation_job";
		public static final String ADDRESS = "address";
		
		public static final String CONTRACT = "contract_id";
		public static final String ENTERPRISE = "enterprise_id";
		public static final String HEADHUNTER = "headhunter_id";

		public static final String JOB_SKILL = "job_skill";
		public static final String ID_JOB = "job_id";
		public static final String ID_SKILL = "skill_id";
		
		public ProposalDAO() {
			super(TABLE, ID);
		}

		/* (non-Javadoc)
		 * @see fr.yas.matchup.database.IDAOBase#parseToObject(java.sql.ResultSet)
		 */
		@Override
		public BaseEntity parseToObject(ResultSet resultSet) {
			Job job = new Job();
			
			try {
				job.setId(resultSet.getDouble(ID));
				job.setName(resultSet.getString(NAME));
				job.setPresentation(resultSet.getString(PRESENTATION));
				job.setLocalization(resultSet.getString(ADDRESS));
				CompanyDAO enterprise = new CompanyDAO();
				job.setCompany((Company) enterprise.get(resultSet.getDouble(ENTERPRISE)));
				ContractDAO cDao = new ContractDAO();
				job.setContractType((ContractType) cDao.get(resultSet.getDouble(CONTRACT)));
				//missing DAOheadhunter
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return job;
		}

		/* (non-Javadoc)
		 * @see fr.yas.matchup.database.IDAOBase#parseToString(fr.yas.matchup.entities.base.BaseEntity)
		 */
		@Override
		public String parseToString(BaseEntity item) {
			String request;
			
			Job job = ((Job)item);
			request = String.valueOf(job.getId());
			request += ",'"+job.getName()+"'";
			request += ","+(job.getLocalization() == null ? "null" : "'"+job.getLocalization()+"'");	
//			if(job.getLocalization() == null) {
//				request += ",null";				
//			}else {
//				request += ",'"+job.getLocalization()+"'";
//			}
			if(job.getPresentation() == null) {
				request += ",null";				
			}else {
				request += ",'"+job.getPresentation()+"'";
			}
			if(job.getContractType() == null) {
				request += ",null";				
			}else {
				request += ",'"+job.getContractType().getId()+"'";
			}
			if(job.getCompany() == null) {
				request += ",null";				
			}else {
				request += ",'"+job.getCompany().getId()+"'";				
			}
			if(job.getHeadhunter() == null) {
				request += ",null";				
			}else {
				request += ",'"+job.getHeadhunter().getId()+"'";
			}
			
			return request;

		}

		/* (non-Javadoc)
		 * @see fr.yas.matchup.database.IDAOBase#parseUpdateToString(fr.yas.matchup.entities.base.BaseEntity)
		 */
		@Override
		public String parseUpdateToString(BaseEntity item) {
			String request;
			
			Job job = ((Job)item);
			request = NAME +" = '"+job.getName()+"',";
			if(job.getLocalization() == null) {
				request += ADDRESS +" = null,";
			}else {
				request += ADDRESS +" = '"+job.getLocalization()+"',";
			}
			request += PRESENTATION + (job.getPresentation() ==  null ? " = null," : " = '"+job.getPresentation()+"',");
//			if(job.getPresentation() == null) {
//				request += PRESENTATION +" = null,";
//			}else {
//				request += PRESENTATION +" = '"+job.getPresentation()+"',";
//			}
			if(job.getContractType() == null) {
				request += CONTRACT +" = null,";
			}else {
				request += CONTRACT +" = '"+job.getContractType().getId()+"',";
			}
			if(job.getCompany() == null) {
				request += ENTERPRISE +" = null,";
			}else {
				request += ENTERPRISE +" = '"+job.getCompany().getId()+"',";
			}
			if(job.getHeadhunter() == null) {
				request += HEADHUNTER +" = null";
			}else {
				request += HEADHUNTER +" = '"+job.getHeadhunter().getId()+"'";
			}
			
			return request;
		}

		/**
		 * 
		 * @param id of the compagny (user)
		 * @return
		 */
		public ArrayList<Job> getByCompany(double id) {
			ArrayList<Job> jobs = new ArrayList<>();
			ResultSet rs = executeRequest("SELECT * FROM " + TABLE
					+ " WHERE " + ENTERPRISE + " = " + id);

			try {
				while (rs.next()) {
					Job nJob = (Job) parseToObject(rs);
					nJob = getSkills(nJob);
					jobs.add(nJob);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return jobs;
		}
		
		/**
		 * 
		 * @param id of the headhunter (user)
		 * @return
		 */
		public List<Job> getByHeadhunter(double id) {
			ArrayList<Job> jobs = new ArrayList<>();
			ResultSet rs = executeRequest("SELECT * FROM " + TABLE
					+ " WHERE " + HEADHUNTER + " = " + id);

			try {
				while (rs.next()) {
					jobs.add((Job)parseToObject(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return jobs;
		}

		/**
		 * Return all skills associated to a given job
		 * Use relational table job_skill which reference the job id and a skill id per row
		 * @param job
		 * @return
		 */
		public Job getSkills(Job job) {
			ResultSet rs = executeRequest("SELECT * FROM " + JOB_SKILL
					+ " WHERE " + ID_JOB + " = " + job.getId());
			List<Double> skillsId = new ArrayList<Double>();
			try {
				while (rs.next()) {
					skillsId.add(rs.getDouble(ID_SKILL));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			BaseDAO skillDAO = new SkillDAO();

			for (Double id : skillsId) {
				job.getSkills().add( (Skill) skillDAO.get(id));
			}

			return job;
		}

		/**
		 * Insert the list of skills of the job in the data base
		 * It is also use for update
		 * Use relational table job_skill which reference the job id and a skill id per row
		 * @param job
		 * @return
		 */
		public int insertSkills(Job job) {
			int result = 0;
			deleteSkills(job);
			for (Skill skill : job.getSkills()) {
				result += executeRequestUpdate("INSERT INTO " + JOB_SKILL
						+ " VALUES(" + job.getId() + "," + skill.getId()
						+ ")");
			}
			return result;
		}

		/**
		 * Delete all the skills associated to a given job
		 * Use relational table job_skill which reference the job id and a skill id per row
		 * @param job
		 * @return
		 */
		public int deleteSkills(Job job) {
			return executeRequestUpdate("DELETE FROM " + JOB_SKILL + " WHERE "
					+ ID_JOB + " = " + job.getId());
		}


}
