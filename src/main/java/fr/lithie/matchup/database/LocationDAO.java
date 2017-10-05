/**
 * 
 */
package fr.lithie.matchup.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.lithie.matchup.database.base.BaseDAO;
import fr.lithie.matchup.entities.Location;
import fr.lithie.matchup.entities.base.BaseEntity;

/**
 * @author Audrey
 *
 */
public class LocationDAO extends BaseDAO {
	public static final String TABLE = "Location";
	public static final String ID = "id";
	public static final String PAYS = "pays";
	public static final String ADDRESS = "address";
	public static final String ZIPCODE = "zipcode";
	public static final String CITY = "city";
	
	public LocationDAO() {
		super(TABLE, ID);
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseToObject(java.sql.ResultSet)
	 */
	@Override
	public BaseEntity parseToObject(ResultSet resultSet) {
		Location lieu = new Location();
		
		try {
			lieu.setId(resultSet.getDouble(ID));
			lieu.setPays(resultSet.getString(PAYS));
			lieu.setCity(resultSet.getString(CITY));
			lieu.setZipcode(resultSet.getString(ZIPCODE));
			lieu.setAddress(resultSet.getString(ADDRESS));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return lieu;
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseToString(BaseEntity item) {
		String res = "null,";
		Location lieu = (Location) item;
		
		res +=(lieu.getPays() != null ? "'" + lieu.getPays() + "'" : "null") +",";
		res +=(lieu.getAddress() != null ? "'" + lieu.getAddress() + "'" : "null") +",";
		res +=(lieu.getZipcode() != null ? "'" + lieu.getZipcode() + "'" : "null") +",";
		res +=(lieu.getCity() != null ? "'" + lieu.getCity() + "'" : "null");
		return res;
	}

	/* (non-Javadoc)
	 * @see fr.yas.matchup.database.IDAOBase#parseUpdateToString(fr.yas.matchup.entities.base.BaseEntity)
	 */
	@Override
	public String parseUpdateToString(BaseEntity item) {
		Location lieu = (Location) item;
		
		String res = "";
		res += PAYS + " = " +(lieu.getPays() != null ? "'" + lieu.getPays() + "'" : "null") + ",";
		res += ADDRESS + " = " +(lieu.getAddress() != null ? "'" + lieu.getAddress() + "'" : "null") + ",";
		res += ZIPCODE + " = " +(lieu.getZipcode() != null ? "'" + lieu.getZipcode() + "'" : "null") + ",";
		res += CITY + " = " +(lieu.getCity() != null ? "'" + lieu.getCity() + "'" : "null") + ",";
		return res;
	}

}
