/**
 * 
 */
package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.lithie.matchup.database.base.BaseDAO;
import fr.lithie.matchup.entities.Skill;
import fr.lithie.matchup.entities.base.BaseEntity;

/**
 * @author Audrey
 *
 */
public class SkillDAO extends BaseDAO {
	public static final String TABLE = "skills";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String TYPE = "type";
	
	public SkillDAO() {
		super(TABLE, ID);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parse(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		Skill skill = new Skill();
		
		try {
			skill.setId(resultSet.getDouble(ID));
			skill.setName(resultSet.getString(NAME));
			skill.setSkillType(resultSet.getString(TYPE));
		} catch (SQLException e) {
			skill = null;
			e.printStackTrace();
		}
		
		return skill;
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseToString(BaseEntity item) {
		String request;
		
		Skill skill = ((Skill)item);
		request = String.valueOf(skill.getId());
		request += ",'"+skill.getName().replaceAll("'", " ")+"'";
		request += ",'"+skill.getSkillType()+"'";
		
		return request;
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseUpdateToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseUpdateToString(BaseEntity item) {
		String request;
		
		Skill skill = ((Skill)item);
		request = NAME +" = '"+skill.getName()+"'";
		request += TYPE +" = '"+skill.getSkillType()+"'";
		
		return request;
	}

}
