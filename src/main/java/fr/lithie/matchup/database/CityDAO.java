package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.lithie.matchup.database.base.BaseDAO;
import fr.lithie.matchup.entities.City;
import fr.lithie.matchup.entities.base.BaseEntity;

public class CityDAO extends BaseDAO {

	private static final String TABLE = "city";
	private static final String ID = "id_city";
	private static final String NAME = "name_city";
	private static final String POSTAL_CODE = "postal_code_city";
	
	public CityDAO() {
		super(TABLE,ID);
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseToObject(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		
		City city = new City();
		try {
			city.setId(resultSet.getDouble(ID));
			city.setName_city(resultSet.getString(NAME));
			city.setPostal_code_city(resultSet.getString(POSTAL_CODE));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return city;
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseToString(BaseEntity item) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseUpdateToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseUpdateToString(BaseEntity item) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
